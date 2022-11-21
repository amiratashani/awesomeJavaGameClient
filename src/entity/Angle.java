package entity;

import com.google.gson.annotations.JsonAdapter;


public class Angle {
    double angle;

    public Angle() {
    }

    public Angle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double radian() {
        return normalizeRadian(angle);
    }

    public double degree() {
        return normalizeDegree(angle / Math.PI * 180.0);
    }

    public Angle addRadian(double f) {
        return new Angle(normalizeRadian(angle + f));
    }

    public Angle addDegree(double f)  {
        return fromDegree(degree() + f);
    }

    public Angle fromRadian(double r) {
        return new Angle(normalizeRadian(r));
    }

    public Angle fromDegree(double degree)  {
        return new Angle(normalizeDegree(degree) / 180.0 * Math.PI);
    }

    private double normalizeDegree(double degree) {
        while (true) {
            if (degree > 180) {
                degree -= 360;
            } else {
                break;
            }
        }
        return degree;
    }

    private double normalizeRadian(double radian) {
        while (true) {
            if (radian > Math.PI) {
                radian -= 2.0 * Math.PI;
            } else {
                break;
            }
        }
        return radian;
    }
}
