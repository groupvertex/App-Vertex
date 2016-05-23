package ua.vertex.waypoint.Entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Vasyl on 18/05/2016.
 */
public class WayPoint implements Serializable, Comparable<WayPoint> {

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

    public static Builder newBuilder() {
        return new WayPoint().new Builder();
    }
    public class Builder {
        private Builder() {
        }

        public Builder setId(long id) {
            WayPoint.this.id = id;
            return this;
        }
        public Builder setRouteId(long routeId) {
            WayPoint.this.routeId = routeId;
            return this;
        }
        public Builder setX(double x) {
            WayPoint.this.x = x;
            return this;
        }
        public Builder setY(double y) {
            WayPoint.this.y = y;
            return this;
        }
        public Builder setHeight(int height) {
            WayPoint.this.height = height;
            return this;
        }
        public Builder setAccuracy(int accuracy) {
            WayPoint.this.accuracy = accuracy;
            return this;
        }
        public Builder setAddTime(Timestamp addTime) {
            WayPoint.this.addTime = addTime;
            return this;
        }
        public WayPoint build() {
            return WayPoint.this;
        }
    }

    @Override
    public int compareTo(WayPoint o) {
        if (o == null) {
            throw new NullPointerException("Argument with reference NULL in method compareTo");
        }
        return this.addTime.compareTo(o.getAddTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WayPoint wayPoint = (WayPoint) o;

        if (id != wayPoint.id) return false;
        if (routeId != wayPoint.routeId) return false;
        if (Double.compare(wayPoint.x, x) != 0) return false;
        if (Double.compare(wayPoint.y, y) != 0) return false;
        if (height != wayPoint.height) return false;
        if (accuracy != wayPoint.accuracy) return false;
        return addTime != null ? addTime.equals(wayPoint.addTime) : wayPoint.addTime == null;

    }

    @Override
    public int hashCode() {
        long result;
        long temp;
        result = id;
        result = 31 * result + routeId;
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + height;
        result = 31 * result + accuracy;
        result = 31 * result + (addTime != null ? addTime.hashCode() : 0);
        return (int) result;
    }

    @Override
    public String toString() {
        return "WayPoint{" +
                "id=" + id +
                ", routeId=" + routeId +
                ", x=" + x +
                ", y=" + y +
                ", height=" + height +
                ", accuracy=" + accuracy +
                ", addTime=" + addTime +
                '}';
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
