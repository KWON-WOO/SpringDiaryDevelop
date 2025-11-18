package com.springdiaryproject.springdiarydevelop.filter;

import com.springdiaryproject.springdiarydevelop.exception.CustomException;
import com.springdiaryproject.springdiarydevelop.exception.StateCode;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        boolean isLoggedIn = session == null;

        String uri = request.getRequestURI();
        if (isLoggedIn && (uri.startsWith("/schedules") || uri.startsWith("/users"))) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            String json = String.format("""
                    {
                        code: %d,
                        message: %s
                    }""",StateCode.UNAUTHORIZED.getStatus(),StateCode.UNAUTHORIZED.getMessage());
            response.getWriter().write(json);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}