package com.example.AplikasiPerpustakaan.Filter;

import com.example.AplikasiPerpustakaan.Config.JwtTokenUtil;
import com.example.AplikasiPerpustakaan.Entity.User;
import com.example.AplikasiPerpustakaan.Repository.UserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component

public class JwtAuthFilter extends OncePerRequestFilter
{
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserRepository repository;
    @Override
    protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        String username = null;
        String token = null;

        if (header != null && header.startsWith("Bearer ")){
            token = header.replace("Bearer ", "");

            try {
                username = jwtTokenUtil.getUsernameFromToken(token);
            }catch (IllegalArgumentException e){
                logger.error("Username tidak ditemukan");
            }catch (ExpiredJwtException e){
                logger.warn("Token Expired");
            }catch (SignatureException e){
                logger.error("Username atau password tidak sesuai");
            }
        }else {
            logger.warn("Header tidak di set / tidak menemukan kata Bearer ");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            User users = repository.findByUsername(username);

            if (jwtTokenUtil.validationToken(token, users)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(users, null, new ArrayList<>());

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }

}
