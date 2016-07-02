package dao;

import entity.WayPoint;

import java.util.List;

/**
 * Created by Nick on 6/27/2016.
 */
public interface RouteDao {
    public void setId(long id);
    public void setName(String name);
    public void setWayPoints(List<WayPoint> wayPoints);
    public long getId();
    public String getName();
    public List<WayPoint> getWayPoints();
}
