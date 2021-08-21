package ru.redsquid.examples.ms.order.filters;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserContextInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("@@@ (CORRELATED-ID) ORDER: intercept");
        requestTemplate.header(UserContext.CORRELATION_ID, UserContextHolder.getUserContext().getCorrelationId());
    }
}
