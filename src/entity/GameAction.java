package entity;

public class GameAction {
    int seq;
    MoveAction moveAction;
    double value;
    boolean fire;

    public GameAction() {
    }

    public GameAction(int seq, MoveAction moveAction, double value, boolean fire) {
        this.seq = seq;
        this.moveAction = moveAction;
        this.value = value;
        this.fire = fire;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public MoveAction getMoveAction() {
        return moveAction;
    }

    public void setMoveAction(MoveAction moveAction) {
        this.moveAction = moveAction;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isFire() {
        return fire;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }

}


