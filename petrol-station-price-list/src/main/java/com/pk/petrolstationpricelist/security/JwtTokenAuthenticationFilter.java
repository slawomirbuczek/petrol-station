package com.pk.petrolstationpricelist.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(JwtTokenAuthenticationFilter.class);
    private final ApiPublicKey apiPublicKey;

    public JwtTokenAuthenticationFilter(ApiPublicKey apiPublicKey) {
        this.apiPublicKey = apiPublicKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        logger.trace("Filtering internal");
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (header == null || !header.startsWith("Bearer ")) {
            logger.trace("Lack of jwt token");
            chain.doFilter(request, response);
            return;
        }

        if (apiPublicKey.getPublicKey() == null) {
            logger.trace("Public key is null");
            chain.doFilter(request, response);
            return;
        }

        String token = header.replace("Bearer ", "");

        try {
            logger.trace("Attempting to parse token");
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(apiPublicKey.getPublicKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            logger.trace("Token successfully parsed");

            String username = claims.getSubject();
            if (username != null) {
                @SuppressWarnings("unchecked")
                List<String> authorities = (List<String>) claims.get("authorities");

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        username, null, authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

                logger.trace("Authenticated user " + username + " with authority " +
                        authorities.stream().reduce((s, s2) -> s + " " + s2).orElse(" empty"));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

        } catch (Exception e) {
            logger.error("Error during token parsing" + e);
            SecurityContextHolder.clearContext();
        }

        chain.doFilter(request, response);
    }

}
