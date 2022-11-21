package entity;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class ObjectTypeSerializer implements JsonSerializer<ObjectType> {
    @Override
    public JsonElement serialize(ObjectType objectType, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(objectType.toString());
    }
}
