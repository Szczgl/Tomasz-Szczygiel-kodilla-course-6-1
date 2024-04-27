package com.kodilla.patterns2.facade.aop;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProcessingOrderAop {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessingOrderAop.class);
    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))"+ "&&args(orderDto, userId)&&target(object)")
    public void logEvent(OrderDto orderDto, Long userId, Object object) throws NoSuchMethodException{
        LOGGER.info("Class: " + object.getClass().getName() + ", Method: "
                + object.getClass().getMethod("processOrder", OrderDto.class, Long.class) + ", orderDto: "
                +orderDto.toString() + " userId: " + userId);
    }
}
