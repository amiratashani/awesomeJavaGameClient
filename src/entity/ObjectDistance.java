package entity;

import com.google.gson.annotations.SerializedName;

public class ObjectDistance {
    @SerializedName(value = "Distance")
    double distance;
    @SerializedName(value = "ObjectType")
    ObjectType objectType;

    public ObjectDistance(double distance, ObjectType objectType) {
        this.distance = distance;
        this.objectType = objectType;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }


}
