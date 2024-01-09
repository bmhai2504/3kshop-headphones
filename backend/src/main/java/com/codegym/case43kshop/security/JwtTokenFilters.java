package com.codegym.case43kshop.security;

import com.codegym.case43kshop.entity.User;
import com.codegym.case43kshop.repository.UserRepository;
import com.codegym.case43kshop.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtTokenFilters extends OncePerRequestFilter {
    @Autowired
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

//        String token = request.getHeader(String.valueOf(Header.Authorization));
        String token = request.getHeader("Authorization");
        String email = null;
        String jwtToken = null;
        if (token != null && token.startsWith("Bearer "))
        {
            jwtToken = token.substring(7);
            if (jwtTokenUtil.isTokenExpired(jwtToken)) {
                throw new ExpiredJwtException(null, null, "Jwt expired");
            }
            email = jwtTokenUtil.getEmailFromToken(jwtToken);

        } else {
            logger.warn("JWT Token does not begin with Bearer String");
        }
        if (email != null){
            User user = null;
            try {
                user = userRepository.findByEmail(email);
                request.setAttribute("user", user);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    user,
                    null,
                    authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request,response);

    }
}
