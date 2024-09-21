package com.ro.ejb.interceptor;

import com.ro.ejb.annotation.RouteOptimization;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Logger;

@RouteOptimization
@Interceptor
public class RouteInterceptor {

    private static final Logger LOGGER = Logger.getLogger(RouteInterceptor.class.getName());

    @AroundInvoke
    public Object logRouteOptimizationActivity(InvocationContext context) throws Exception {
        LOGGER.info("Method " + context.getMethod().getName() + " is called on " +
                context.getTarget().getClass().getName() + " with parameters " +
                java.util.Arrays.toString(context.getParameters()));
        try {
            return context.proceed();
        } catch (Exception e) {
            LOGGER.severe("Exception in method: " + context.getMethod().getName() + " - " + e.getMessage());
            throw e;
        }
    }

}
