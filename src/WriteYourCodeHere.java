import entity.GameAction;
import entity.GameUpdate;
import entity.MoveAction;

public class WriteYourCodeHere implements WebsocketClientEndpoint.UserCode {
    @Override
    public GameAction writeCodeHere(GameUpdate gameUpdate) {
        return dance(gameUpdate);
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
