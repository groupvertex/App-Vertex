package ua.vertex.academy.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import ua.vertex.route.Entity.Route;

import java.util.concurrent.ThreadLocalRandom;


/**
 * Created by RASTA on 20.05.2016.
 */
@Aspect
public class ServiceAspect {
    private static final Logger logger = Logger.getLogger(ServiceAspect.class.getName());
    private final Route emptyRoute = new Route(-1, "empty");

    @Around("execution(* ua.vertex.academy.service.RouteServiceImpl.create(..)) && args(route)")
    public Object aroundCreate(ProceedingJoinPoint joinPoint, Route route) {
        if (route == null) {
            return -1l;
        }
        try {
            long id = ThreadLocalRandom.current().nextLong();
            route.setId(id);
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.warn("route with id:" + route.getId() + " is already exist!", throwable);
            return aroundCreate(joinPoint, route);
        }
    }

    @Around("execution(* ua.vertex.academy.service.RouteServiceImpl.read(..))")
    public Object aroundGet(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            return emptyRoute;
        }
    }

    @Around(value = "execution(* ua.vertex.academy.service.RouteServiceImpl.update(..))")
    public void aroundUpdate(ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.warn("error in update", throwable);
        }
    }


    @Around(value = "execution(* ua.vertex.academy.service.RouteServiceImpl.delete(..))")
    public void aroundDelete(ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.warn("error in delete", throwable);
        }

    }

}
