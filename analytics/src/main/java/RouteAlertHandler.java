import entity.Route;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

public class RouteAlertHandler {
    Route route;
    int[] results;
    Object obj;

    public void processRoute(Route route) {
        Class cls = null;
        Object obj = null;
        try {
            cls = Class.forName("DoStatistic");
            obj = cls.newInstance();
        } catch (Exception e) {
        }

        this.route = route;
        this.obj = obj;
        System.out.println(route.toString());
        Method[] methods = Statistics.class.getMethods();
        int methodsQuontity = methods.length;
        results = new int[methodsQuontity];
        CountDownLatch latch = new CountDownLatch(methodsQuontity);
        for (int i = 0; i < methodsQuontity; i++) {
            Thread thread = new Thread((Runnable) new DoWork(methods[i], latch, i, obj));
            thread.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("Exception in await");
        }
        System.out.println("After all threads finish");

//        TODO Write to DB
//        TODO Send message via JmsTemplate

    }

    private class DoWork implements Runnable {
        CountDownLatch latch;
        Method method;
        int index;

        public DoWork(Method method, CountDownLatch latch, int index, Object obj) {
            this.latch = latch;
            this.method = method;
            this.index = index;
        }

        @Override
        public void run() {
            try {
                int result = (int) method.invoke(obj, new Object[1]);
                synchronized (results) {
                    results[index] = result;
                }
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            } catch (InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
