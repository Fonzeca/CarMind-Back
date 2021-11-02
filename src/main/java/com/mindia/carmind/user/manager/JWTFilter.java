package com.mindia.carmind.user.manager;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class JWTFilter extends OncePerRequestFilter {

    private final static String HEADER = "Authorization";
	private final static String PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String authenticationHeader = request.getHeader(HEADER);

            if(authenticationHeader != null && authenticationHeader.startsWith(PREFIX)){



            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }

    private boolean validateTokenToUserHub(){
        
    }

}
