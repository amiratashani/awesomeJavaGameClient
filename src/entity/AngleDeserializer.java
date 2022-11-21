package entity;

import com.google.gson.*;

import java.lang.reflect.Type;

public class AngleDeserializer implements JsonDeserializer<Angle> {
    @Override
    public Angle deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        double direction = jsonElement.getAsDouble();
        Angle angle = new Angle(direction);
        return angle;
    }
}
