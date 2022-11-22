import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

public class Main {
    static final String SERVER_ADDRESS = "172.26.10.115:8080";
    static final String USER_ID = "2020";

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        final WebsocketClientEndpoint clientEndPoint;
        try {
            URI endpointURI = new URI("ws://" + SERVER_ADDRESS + "/register");
            System.out.println(endpointURI.toString());
            clientEndPoint = new WebsocketClientEndpoint(endpointURI, latch);
            ClientMessageHandler clientMessageHandler = new ClientMessageHandler();
            WriteYourCodeHere writeYourCodeHere = new WriteYourCodeHere();
            clientEndPoint.addMessageHandler(clientMessageHandler,writeYourCodeHere);
            latch.await();
        } catch (InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
