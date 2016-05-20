package ua.vertex.academy.exception;

/**
 * Created by RASTA on 19.05.2016.
 */
public class RouteNotFoundException extends RuntimeException{
    public RouteNotFoundException() {
    }

    public RouteNotFoundException(String message) {
        super(message);
    }
}
