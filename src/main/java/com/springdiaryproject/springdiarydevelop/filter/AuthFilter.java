package com.springdiaryproject.springdiarydevelop.filter;

import jakarta.servlet.*;

import java.io.IOException;

@
public class AuthFilter extends Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
