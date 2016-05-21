package ua.vertex.academy.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
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

    @Around("execution(* ua.vertex.academy.service.RouteServiceImpl.create(..)) && args(route)")
    public Object aroundCreate(ProceedingJoinPoint joinPoint, Route route) {
        if (route == null) {
            return -1l;
        }
        try {
            long id = ThreadLocalRandom.current().nextInt(3000000); // TODO: 21.05.2016 do the same but with long
            route.setId(id);
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.info("route with id:" + route.getId() + " is already exist!", throwable);
            return aroundCreate(joinPoint, route);
        }
    }

    @Around("execution(* ua.vertex.academy.service.RouteServiceImpl.read(..))")
    public Object aroundGet(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            return new Route(-1, "empty");
        }
    }

    @AfterThrowing(value = "execution(* ua.vertex.academy.service.RouteServiceImpl.update(..))", throwing = "throwable")
    public void aroundUpdate(Throwable throwable) {
        logger.warn("error in update", throwable);
    }


    @AfterThrowing(value = "execution(* ua.vertex.academy.service.RouteServiceImpl.delete(..))", throwing = "throwable")
    public void aroundDelete(Throwable throwable) {
        logger.warn("error in delete", throwable);
    }

}
