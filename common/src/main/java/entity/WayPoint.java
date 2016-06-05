package entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

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
        return routeId == wayPoint.routeId &&
                Double.compare(wayPoint.x, x) == 0 &&
                Double.compare(wayPoint.y, y) == 0 &&
                height == wayPoint.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, x, y, height);
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
