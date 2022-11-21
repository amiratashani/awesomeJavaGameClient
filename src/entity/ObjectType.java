package entity;

import com.google.gson.annotations.SerializedName;

public enum ObjectType {
    @SerializedName("WALL")
    ObjectTypeWall("WALL"),
    @SerializedName("TANK")
    ObjectTypeTank("TANK"),
    @SerializedName("BULLET")
    ObjectTypeBullet("BULLET"),
    @SerializedName("NOTHING")
    ObjectTypeNothing("NOTHING");

    final String name;

    ObjectType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}