package com.toolbox.toolbox.security;
import io.jsonwebtoken.security.Keys;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {
    private final Key key = Keys.hmacShaKeyFor(SecurityConsts.JWT_FIRMA.getBytes());


    //generar token
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + SecurityConsts.JWT_EXPIRATION_TIME);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512,SecurityConsts.JWT_FIRMA)
                .compact();
    }
    //extraer username de un token
    public String getUserNameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();

    }

    //validar token
    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(key)
                    .build()  //
                    .parseClaimsJws(token);

            return true;  // Si no hay excepciones, el token es válido
        }catch (Exception e){
            throw new AuthenticationCredentialsNotFoundException("Invalid or expired token");
        }
    }
}
