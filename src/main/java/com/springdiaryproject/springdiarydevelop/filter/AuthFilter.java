package com.springdiaryproject.springdiarydevelop.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);

        boolean isLoggedIn = session == null;

        String uri = request.getRequestURI();
        if (isLoggedIn && (uri.startsWith("/schedules") || uri.startsWith("/users"))) {
            throw new IllegalArgumentException("로그인 해주쇼");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
