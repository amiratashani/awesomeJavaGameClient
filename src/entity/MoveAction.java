package entity;

import com.google.gson.annotations.SerializedName;

public enum MoveAction {
    @SerializedName("FORWARD")
    MoveForward("FORWARD"),
    @SerializedName("BACKWARD")
    MoveBackward("BACKWARD"),
    @SerializedName("RIGHT")
    MoveRight("RIGHT"),
    @SerializedName("LEFT")
    MoveLeft("LEFT"),
    @SerializedName("TURN_RIGHT")
    TurnRight("TURN_RIGHT"),
    @SerializedName("TURN_LEFT")
    TurnLeft("TURN_LEFT"),
    @SerializedName("")
    DontMove("");
    final String name;
    MoveAction(String s) {
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
