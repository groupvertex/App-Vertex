package dao;

import java.sql.Timestamp;

/**
 * Created by Nick on 6/27/2016.
 */
public interface WayPointDao {
    public long getId();
    public long getRouteId();
    public double getX();
    public double getY();
    public int getHeight();
    public int getAccuracy();
    public Timestamp getAddTime();
}
