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

import io.quarkus.security.UnauthorizedException;
import io.smallrye.jwt.algorithm.SignatureAlgorithm;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtSignatureException;


@ApplicationScoped
public class AuthService {

    @Inject
    private EntityManager entityManager;



    @Transactional
    public String login( Mitglied mitglied) {
        var entity = entityManager.find(Mitglied.class, mitglied.getId());

        System.out.println("iD: "+entity.getId());
        System.out.println(entity.getPasswort() +"' ist das selbe wie '" + mitglied.getPasswort() +"': "+ entity.getPasswort().equals(mitglied.getPasswort()));
        System.out.println(entity.getEmail().equals(mitglied.getEmail()));
        if(entity.getPasswort().equals(mitglied.getPasswort())  &&  entity.getEmail().equals(mitglied.getEmail()) ){
                String rolle = mitglied.getRolle();
                String rolle1 = rolle.replace("\n", "");
                Long id = mitglied.getId();
                return returnToken(mitglied.getEmail(), mitglied.getPasswort(), rolle1, id);

            
        }else{
            return "no access";
        }


    }

    public String returnToken(String email, String password, String role, Long id) {
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
