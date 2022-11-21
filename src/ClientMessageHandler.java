import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.*;

public class ClientMessageHandler implements WebsocketClientEndpoint.MessageHandler {
    @Override
    public String handleMessage(String serverMessage, WebsocketClientEndpoint.UserCode userCode) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ObjectType.class,new ObjectTypeSerializer());
        gsonBuilder.registerTypeAdapter(ObjectType.class,new ObjectTypeDeserializer());
        gsonBuilder.registerTypeAdapter(MoveAction.class,new MoveActionSerializer());
        gsonBuilder.registerTypeAdapter(MoveAction.class,new MoveActionDeserializer());
        gsonBuilder.registerTypeAdapter(Angle.class,new AngleDeserializer());
        Gson gson = gsonBuilder.create();
        GameUpdate gameUpdate = gson.fromJson(serverMessage, GameUpdate.class);


        GameAction gameAction = userCode.writeCodeHere(gameUpdate);


        gameAction.setSeq(gameUpdate.getSeq());
        return gson.toJson(gameAction);
    }
}
