package entity;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class MoveActionDeserializer implements JsonDeserializer<MoveAction> {
    @Override
    public MoveAction deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        MoveAction moveAction = switch (jsonElement.getAsString()) {
            case "FORWARD" -> MoveAction.MoveForward;
            case "BACKWARD" -> MoveAction.MoveBackward;
            case "RIGHT" ->MoveAction.MoveRight;
            case "LEFT" -> MoveAction.MoveLeft;
            case "TURN_RIGHT" -> MoveAction.TurnRight;
            case "TURN_LEFT" -> MoveAction.TurnLeft;
            default -> MoveAction.DontMove;
        };
        return moveAction;
    }
}
