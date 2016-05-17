package ua.vertex.route.Entity;

/**
 * Created by Дмитрий on 17.05.2016.
 */
public class Route {

    private int id;
    private String name;
//    private List<Waypoint> waypoints;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (id != route.id) return false;
        return name != null ? name.equals(route.name) : route.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
