package com.fitness.aspects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {
    private static final Logger logger = LoggerFactory.getLogger(TracingAspect.class);

    @Autowired
    ObjectMapper objectMapper;

    int totalHit=0;

    @Before(
            "execution(* com.fitness.controller.*.*(..))"
    )
    public void controllerlevelCount(){
        logger.info("Current Hit count - {} ", totalHit++);
    }

    @AfterReturning(value = "execution(* com.fitness.service.*.*(..))", returning = "result")
    public void afterReturningService(JoinPoint joinPoint, Object result) throws JsonProcessingException {
        logger.info("{} returned with value {}", joinPoint, objectMapper.writeValueAsString(result));
    }

//    @AfterReturning(value = "execution(* com.fitness.repository.*.*(..))", returning = "result")
//    public void afterReturningRepository(JoinPoint joinPoint, Object result) throws JsonProcessingException {
//        logger.info("{} returned with value {}", joinPoint, objectMapper.writeValueAsString(result));
//    }
}
