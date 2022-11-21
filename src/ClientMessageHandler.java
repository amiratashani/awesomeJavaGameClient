import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.*;

public class ClientMessageHandler implements WebsocketClientEndpoint.MessageHandler {
    @Override
    public String handleMessage(String serverMessage) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ObjectType.class,new ObjectTypeSerializer());
        gsonBuilder.registerTypeAdapter(ObjectType.class,new ObjectTypeDeserializer());
        gsonBuilder.registerTypeAdapter(MoveAction.class,new MoveActionSerializer());
        gsonBuilder.registerTypeAdapter(MoveAction.class,new MoveActionDeserializer());
        Gson gson = gsonBuilder.create();
        GameUpdate gameUpdate = gson.fromJson(serverMessage, GameUpdate.class);



        GameAction gameAction = dance(gameUpdate);



        gameAction.setSeq(gameUpdate.getSeq());
        String clientMessage = gson.toJson(gameAction);
        return clientMessage;
    }

    private GameAction dance(GameUpdate gameUpdate) {
        GameAction gameAction = new GameAction();

        gameAction.setMoveAction(MoveAction.MoveForward);

        gameAction.setFire(true);

        if (gameUpdate.getSeq() > 100) {
            gameAction.setMoveAction(MoveAction.MoveBackward);
        }
        if (gameUpdate.getSeq() > 200) {
            gameAction.setMoveAction(MoveAction.MoveRight);
        }
        if (gameUpdate.getSeq() > 300) {
            gameAction.setMoveAction(MoveAction.MoveLeft);
        }

        if (gameUpdate.getSeq() % 100 < 50) {
            gameAction.setValue(50.0f);
        } else {
            gameAction.setValue(100.0f);
        }

        if (gameUpdate.getSeq() > 400) {
            gameAction.setMoveAction(MoveAction.TurnRight);
            gameAction.setValue(2.0f);
        }

        if (gameUpdate.getSeq() > 500) {
            gameAction.setMoveAction(MoveAction.TurnLeft);
            gameAction.setValue(2.0f);
        }


        return gameAction;
    }
}
