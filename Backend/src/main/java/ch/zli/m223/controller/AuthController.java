package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.CascadeType;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Buchung;
import ch.zli.m223.model.Mitglied;
import ch.zli.m223.service.AuthService;
import ch.zli.m223.service.BuchungService;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;

@Path("/auth")
@Tag(name = "Auth", description = "Handling of Authorizinh")
public class AuthController {

    @Inject
    AuthService authService;

    

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    @Operation(summary = "Creates a new buchung.", description = "Creates a new buchung and returns the newly added buchung.")
    public String login(Mitglied Mitglied) {
        
        return authService.login(Mitglied);
    }

    

}
