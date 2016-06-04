package entity;

import java.util.ArrayList;
import java.util.List;

public class Route {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (id != route.id) return false;
        if (name != null ? !name.equals(route.name) : route.name != null) return false;
        return wayPoints != null ? wayPoints.equals(route.wayPoints) : route.wayPoints == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (wayPoints != null ? wayPoints.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wayPoints=" + wayPoints +
                '}';
    }
}




