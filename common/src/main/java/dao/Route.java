package dao;

import entity.WayPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 6/27/2016.
 */
public class Route implements RouteDao{
    private long id;
    private String name;
    private List<WayPoint> wayPoints = new ArrayList<>();

    public Route() {
    }

    public Route(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Route(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWayPoints(List<WayPoint> wayPoints) {
        this.wayPoints = wayPoints;
    }

    public long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public List<WayPoint> getWayPoints() {
        return wayPoints;
    }
}
