package entity;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class MoveActionDeserializer implements JsonDeserializer<MoveAction> {
    @Override
    public MoveAction deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        MoveAction moveAction;
        switch (jsonElement.getAsString()) {
            case "FORWARD":
                moveAction = MoveAction.MoveForward;
                break;
            case "BACKWARD":
                moveAction = MoveAction.MoveBackward;
                break;
            case "RIGHT":
                moveAction = MoveAction.MoveRight;
                break;
            case "LEFT":
                moveAction = MoveAction.MoveLeft;
                break;
            case "TURN_RIGHT":
                moveAction = MoveAction.TurnRight;
                break;
            case "TURN_LEFT":
                moveAction = MoveAction.TurnLeft;
                break;
            default:
                moveAction = MoveAction.DontMove;
        }
        return moveAction;
    }
}
