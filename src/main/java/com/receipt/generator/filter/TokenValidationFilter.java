package com.receipt.generator.filter;

import com.receipt.generator.utilities.JwtUtility;
import io.jsonwebtoken.Claims;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TokenValidationFilter implements Filter {

    private final JwtUtility jwtUtility;

    // Constructor-based injection
    public TokenValidationFilter(JwtUtility jwtUtility) {
        this.jwtUtility = jwtUtility;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");

        // Allow OPTIONS requests to pass through without validation
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        String authHeader = httpRequest.getHeader("Authorization");

        if (authHeader == null || authHeader.isEmpty()) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("Missing Authorization header");
            return;
        }

        // Extract token (for non-Bearer tokens, you can adjust the logic here)
        String token = authHeader.startsWith("Bearer ") ? authHeader.substring(7) : authHeader;

        try {
            // Validate and parse JWT token
            Claims success = validateToken(token);
        } catch (Exception e) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("Invalid or expired token: " + e.getMessage());
            return;
        }

        chain.doFilter(request, response);
    }

    // Validate and parse JWT token
    private Claims validateToken(String token) throws Exception {
        return jwtUtility.validateToken(token);
    }
}

