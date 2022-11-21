import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.*;

import javax.json.Json;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

public class Main {
    static final String SERVER_ADDRESS = "serverAddress";
    static final String USER_ID = "2020";

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        final WebsocketClientEndpoint clientEndPoint;
        try {
            URI endpointURI = new URI("ws://" + SERVER_ADDRESS + "/register");
            clientEndPoint = new WebsocketClientEndpoint(endpointURI, latch);
            ClientMessageHandler clientMessageHandler = new ClientMessageHandler();
            clientEndPoint.addMessageHandler(clientMessageHandler);
            latch.await();
        } catch (InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
