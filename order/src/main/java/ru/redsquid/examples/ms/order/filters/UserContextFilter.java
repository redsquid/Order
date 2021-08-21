package ru.redsquid.examples.ms.order.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class UserContextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("@@@ (CORRELATED-ID) ORDER: doFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        UserContextHolder.getUserContext().setCorrelationId(request.getHeader(UserContext.CORRELATION_ID));
        filterChain.doFilter(request, servletResponse);
    }
}
