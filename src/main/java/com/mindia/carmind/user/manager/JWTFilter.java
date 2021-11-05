package com.mindia.carmind.user.manager;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindia.carmind.user.pojo.LoggedView;
import com.mindia.carmind.user.pojo.UserHubConfig;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JWTFilter extends OncePerRequestFilter {

    private final static String HEADER = "Authorization";
    private final static String PREFIX = "Bearer ";
    
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    UserHubConfig userHubConfig;

    public JWTFilter(UserHubConfig userHubConfig) {
        this.userHubConfig = userHubConfig;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        try {
            String authenticationHeader = request.getHeader(HEADER);

            if (request.getRequestURI().equals("/login")) {
                chain.doFilter(request, response);
                return;
            }

            if (authenticationHeader != null && authenticationHeader.startsWith(PREFIX)
                    && validateTokenToUserHub(authenticationHeader)) {

                // TODO: Log de inicio de session.

            } else {
                SecurityContextHolder.clearContext();
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean validateTokenToUserHub(String token) {

        String pathUserHub = "/logged";

        // Armo el request para mandar a UserHub
        Request userHubRequest = new Request.Builder().url(userHubConfig.getUrl() + pathUserHub)
                .addHeader(HEADER, token).get().build();

        // Llamo a la api
        try (Response userHubResponse = client.newCall(userHubRequest).execute()) {
            if(userHubResponse.code() != 200){
                return false;
            }else{
                LoggedView loggedView = mapper.readValue(userHubResponse.body().string(), LoggedView.class);
                setUpSpringAuthentication(loggedView);

                return true;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    /**
     * Metodo para autenticarnos dentro del flujo de Spring
     * 
     * @param claims
     */
    private void setUpSpringAuthentication(LoggedView loggedUser) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(loggedUser,
                null, loggedUser.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

}
