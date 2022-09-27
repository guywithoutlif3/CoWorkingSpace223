package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Mitglied;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.algorithm.SignatureAlgorithm;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtSignatureException;


@ApplicationScoped
public class AuthService {

    @Inject
    private EntityManager entityManager;



    @Transactional
    public String login( Mitglied Mitglied) {
        var entity = entityManager.find(Mitglied.class, Mitglied.getId());
        System.out.println("entity "  + entity.getEmail());
        if(entity.getPasswort().equals(Mitglied.getPasswort())  &&  entity.getEmail().equals(Mitglied.getEmail()) ){
                String rolle = Mitglied.getRolle();
                String rolle1 = rolle.replace("\n", "");
                return returnToken(Mitglied.getEmail(), Mitglied.getPasswort(), Mitglied.getRolle());

            
        }else{
            return "Access denied ";
        }


    }

    public String returnToken(String email, String password, String role) {
        String token = Jwt.issuer("https://example.com/issuer")
            .upn(email)
            .subject(role)
            .groups(role)
            .expiresAt(System.currentTimeMillis() + 1000000000L)
            .claim("role", role)
            .sign();
        System.out.println(token);
        return token;
      }
    
    
}
