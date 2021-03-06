package com.fitness.interceptors;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Configuration
public class RequestInterceptor extends HandlerInterceptorAdapter {
//    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Autowired
    public RequestInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        String requestUrlEndPoint = request.getRequestURI();
        log.info("End point where request landed - {} ", requestUrlEndPoint);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executionTime = endTime-startTime;
        log.info("Total execution time - {} ", executionTime);
        log.info("Response Status - {} ", response.getStatus());
    }
}