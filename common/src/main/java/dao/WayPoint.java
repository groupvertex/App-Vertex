package dao;

import java.sql.Timestamp;

/**
 * Created by Nick on 6/27/2016.
 */
public class WayPoint implements WayPointDao{
    private static long serialVersionUID = 123456789L;

    private long id;
    private long routeId;
    private double x;
    private double y;
    private int height;
    private int accuracy;
    private Timestamp addTime;

    private WayPoint() {
    }


    public long getId() {
        return id;
    }

    public long getRouteId() {
        return routeId;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public Timestamp getAddTime() {
        return addTime;
    }
}
