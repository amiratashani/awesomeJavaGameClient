package entity;

import com.google.gson.annotations.SerializedName;

public class Vector {
    @SerializedName(value = "X")
    double x;
    @SerializedName(value = "Y")
    double y;

    public Vector() {
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double dist(Vector position){
        return Math.sqrt(Math.pow((position.x-this.x),2) + Math.pow((position.y-this.y),2));
    }
}
