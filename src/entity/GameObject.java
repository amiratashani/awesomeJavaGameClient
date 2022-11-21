package entity;

import com.google.gson.annotations.SerializedName;

public class GameObject {
    @SerializedName(value = "Position")
    Vector position;
    @SerializedName(value = "Direction")
    Angle direction;

    public GameObject() {
    }

    public GameObject(Vector position, Angle direction) {
        this.position = position;
        this.direction = direction;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Angle getDirection() {
        return direction;
    }

    public void setDirection(Angle direction) {
        this.direction = direction;
    }
}

