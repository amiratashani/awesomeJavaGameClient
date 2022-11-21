package entity;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;

import java.util.List;
import java.util.Map;

public class GameUpdate {

    @SerializedName(value = "Seq")
    int seq;
    @SerializedName(value = "Me")
    GameObject me;
    @SerializedName(value = "View")
    Map<Integer, ObjectDistance> view;

    @SerializedName(value = "Bullets")
    List<GameObject> bullets;
    @SerializedName(value = "Tanks")
    List<GameObject> tanks;
    @SerializedName(value = "Potions")
    List<GameObject> potions;
    @SerializedName(value = "Bombs")
    List<GameObject> bombs;

    public GameUpdate() {
    }

    public GameUpdate(int seq, GameObject me, Map<Integer, ObjectDistance> view, List<GameObject> bullets, List<GameObject> tanks, List<GameObject> potions, List<GameObject> bombs) {
        this.seq = seq;
        this.me = me;
        this.view = view;
        this.bullets = bullets;
        this.tanks = tanks;
        this.potions = potions;
        this.bombs = bombs;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public GameObject getMe() {
        return me;
    }

    public void setMe(GameObject me) {
        this.me = me;
    }

    public Map<Integer, ObjectDistance> getView() {
        return view;
    }

    public void setView(Map<Integer, ObjectDistance> view) {
        this.view = view;
    }

    public List<GameObject> getBullets() {
        return bullets;
    }

    public void setBullets(List<GameObject> bullets) {
        this.bullets = bullets;
    }

    public List<GameObject> getTanks() {
        return tanks;
    }

    public void setTanks(List<GameObject> tanks) {
        this.tanks = tanks;
    }

    public List<GameObject> getPotions() {
        return potions;
    }

    public void setPotions(List<GameObject> potions) {
        this.potions = potions;
    }

    public List<GameObject> getBombs() {
        return bombs;
    }

    public void setBombs(List<GameObject> bombs) {
        this.bombs = bombs;
    }
}
