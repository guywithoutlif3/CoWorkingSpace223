package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.persistence.CascadeType;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.CafeUser;
import ch.zli.m223.service.CafeUserService;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;

@Path("/cafeUser")
@Tag(name = "Entries", description = "Handling of CafeUseren")
public class CafeUserController {

    @Inject
    CafeUserService CafeUserService;


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new CafeUser.", description = "Creates a new CafeUser and returns the newly added CafeUser.")
    @RolesAllowed("Mitglied")
    public CafeUser create(CafeUser cafeUser) {
        System.out.println(cafeUser.getTimestamp());
        return CafeUserService.createCafeUser(cafeUser);
    }

    
}
