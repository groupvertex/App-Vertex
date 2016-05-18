package ua.vertex.route.Entity;

import ua.vertex.waypoint.Entity.WayPoint;

import java.util.List;

/**
 * Created by Дмитрий on 17.05.2016.
 */
public class Route {

    private int id;
    private String name;

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wayPointList=" + wayPointList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (id != route.id) return false;
        if (name != null ? !name.equals(route.name) : route.name != null) return false;
        return wayPointList != null ? wayPointList.equals(route.wayPointList) : route.wayPointList == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (wayPointList != null ? wayPointList.hashCode() : 0);
        return result;
    }

    public void setWayPointList(List<WayPoint> wayPointList) {

        this.wayPointList = wayPointList;
    }

    public List<WayPoint> getWayPointList() {

        return wayPointList;
    }

    private List<WayPoint> wayPointList;


    public Route() {
    }

    public Route(int id, String name) {

        this.id = id;
        this.name = name;
    }



    public void setId(int id) {

        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

}
