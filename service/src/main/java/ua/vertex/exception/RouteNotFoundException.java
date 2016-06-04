package ua.vertex.exception;

public class RouteNotFoundException extends RuntimeException {

    public RouteNotFoundException() {
    }

    public RouteNotFoundException(String message) {
        super(message);
    }
}
