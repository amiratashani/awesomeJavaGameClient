package entity;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class ObjectTypeDeserializer implements JsonDeserializer<ObjectType> {
    @Override
    public ObjectType deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        ObjectType objectType = switch (jsonElement.getAsString()) {
            case "WALL" -> ObjectType.ObjectTypeWall;
            case "TANK" -> ObjectType.ObjectTypeTank;
            case "BULLET" -> ObjectType.ObjectTypeBullet;
            default -> ObjectType.ObjectTypeNothing;
        };
        return objectType;
    }
}
