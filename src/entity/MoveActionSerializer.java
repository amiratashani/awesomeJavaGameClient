package entity;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class MoveActionSerializer implements JsonSerializer<MoveAction> {
    @Override
    public JsonElement serialize(MoveAction moveAction, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(moveAction.toString());
    }
}
