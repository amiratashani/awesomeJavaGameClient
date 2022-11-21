import javax.websocket.*;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@ClientEndpoint(configurator = WebsocketClientEndpoint.ClientConfigurator.class)
public class WebsocketClientEndpoint {
    Session userSession = null;
    CountDownLatch latch;
    private MessageHandler messageHandler;

    public WebsocketClientEndpoint(URI endpointURI, CountDownLatch latch) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);
            this.latch = latch;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Callback hook for Connection open events.
     *
     * @param userSession the userSession which is opened.
     */
    @OnOpen
    public void onOpen(Session userSession) {
        this.userSession = userSession;
    }

    /**
     * Callback hook for Connection close events.
     *
     * @param userSession the userSession which is getting closed.
     * @param reason      the reason for connection close
     */
    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        this.userSession = null;
        latch.countDown();
    }

    /**
     * Callback hook for Message Events. This method will be invoked when a
     * client send a message.
     *
     * @param message The text message
     */
    @OnMessage
    public void onMessage(String message) {
        if (this.messageHandler != null) {
            String clientMessage = this.messageHandler.handleMessage(message);
            sendMessage(clientMessage);
        }
    }

    /**
     * register message handler
     */
    public void addMessageHandler(MessageHandler msgHandler) {
        this.messageHandler = msgHandler;
    }

    /**
     * Send a message.
     */
    public void sendMessage(String message) {
        this.userSession.getAsyncRemote().sendText(message);
    }

    /**
     * Message handler.
     *
     * @author Jiji_Sasidharan
     */
    public interface MessageHandler {
        String handleMessage(String serverMessage);
    }

    public static class ClientConfigurator extends ClientEndpointConfig.Configurator {
        @Override
        public void beforeRequest(Map<String, List<String>> headers) {
            headers.put("ID", List.of(Main.USER_ID));
        }
    }
}
