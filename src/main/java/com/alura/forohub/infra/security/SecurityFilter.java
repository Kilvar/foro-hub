package com.alura.forohub.infra.security;

import com.alura.forohub.domain.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenServ;

    @Autowired
    UsuarioRepository repo;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = obtenerToken(request);
        if (tokenJWT != null){
            var subject = tokenServ.getSubject(tokenJWT);
            var user = repo.findByNombreUsuario(subject);
            var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }

    private String obtenerToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader != null){
            return authHeader.replace("Bearer ", "");
        }
        return null;
    }

}
