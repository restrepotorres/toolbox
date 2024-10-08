package com.toolbox.toolbox.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

import java.util.Date;

@Component
public class JwtProvider {

    //generar token
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        String role = authentication.getAuthorities().toString();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + SecurityConsts.JWT_EXPIRATION_TIME);
        return Jwts.builder() //Construimos un token JWT llamado token
                .setSubject(username) //Aca establecemos el nombre de usuario que está iniciando sesión
                .claim("role", role) // Agregamos el rol al token como un claim
                .setIssuedAt(new Date()) //Establecemos la fecha de emisión del token en el momento actual
                .setExpiration(expiryDate) //Establecemos la fecha de caducidad del token
                .signWith(SignatureAlgorithm.HS512, SecurityConsts.JWT_SIGNATURE) /*Utilizamos este método para firmar
                nuestro token y de esta manera evitar la manipulación o modificación de este*/
                .compact();

    }
    //extraer username de un token
    public String getUserNameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConsts.JWT_SIGNATURE).build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    //validar token
    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SecurityConsts.JWT_SIGNATURE)
                    .build()
                    .parseClaimsJws(token);

            return true;
        }catch (Exception e){
            throw new AuthenticationCredentialsNotFoundException("Invalid or expired token");
        }
    }
}
