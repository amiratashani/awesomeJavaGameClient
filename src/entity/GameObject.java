package entity;

import com.google.gson.annotations.SerializedName;

public class GameObject {
    @SerializedName(value = "Position")
    Vector position;
    @SerializedName(value = "Direction")
    double direction;

    public GameObject() {
    }

    public GameObject(Vector position, double direction) {
        this.position = position;
        this.direction = direction;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }
}

