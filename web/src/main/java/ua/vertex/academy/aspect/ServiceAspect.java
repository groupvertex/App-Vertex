package ua.vertex.academy.aspect;

import liquibase.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import ua.vertex.route.Entity.Route;


/**
 * Created by RASTA on 20.05.2016.
 */
@Aspect
public class ServiceAspect {

    @Around("execution(* ua.vertex.academy.service.RouteServiceImpl.create(..)) && args(route)")
    public Object aroundCreate(ProceedingJoinPoint joinPoint, Route route) {
        long id = -1;
        try {
            if (route != null) {
                id = (long) joinPoint.proceed();
                return id;
            }
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
        return id;
    }

    @AfterThrowing("execution(* ua.vertex.academy.service.RouteServiceImpl.get(..))")
    public Object aroundGet() {
        return new Route(-1, "empty");
    }

    @AfterThrowing("execution(* ua.vertex.academy.service.RouteServiceImpl.update(..))")
    public void aroundUpdate() {
        System.out.println("error on update");
    //// TODO: 20.05.2016 Add logger
    }


    @AfterThrowing("execution(* ua.vertex.academy.service.RouteServiceImpl.delete(..))")
    public void aroundDelete() {
        System.out.println("error on delete");
    }

    @AfterThrowing("execution(* ua.vertex.academy.service.RouteServiceImpl.addWaypoint(..))")
    public void aroundAddWaypoint() {
        System.out.println("error on add waypoint");
    }

    @AfterThrowing("execution(* ua.vertex.academy.service.RouteServiceImpl.deleteWayPoint(..))")
    public void aroundDeleteWaypoint() {
        System.out.println("error on delete waypoint");

    }
}
