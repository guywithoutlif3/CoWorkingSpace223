package ch.zli.m223.controller;

import java.lang.reflect.Array;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.CascadeType;
import javax.resource.spi.work.SecurityContext;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Mitglied;
import ch.zli.m223.service.MitgliedService;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;

@Path("/mitglied")
@Tag(name = "Entries", description = "Handling of Mitglieden")
public class MitgliedController {

    @Inject
    MitgliedService MitgliedService;

    @Inject
    JsonWebToken jwt;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Mitglieden.", description = "Returns a list of all Mitglieden.")
    @RolesAllowed("Admin")
    public List<Mitglied> index() {
        return MitgliedService.findAll();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Mitglieden.", description = "Returns a list of all Mitglieden.")
    @PermitAll
    public Mitglied findById(@PathParam("id") Long id) {
        if (jwt.getSubject().equals("Mitglied") ) {
            List<Mitglied> listMitglieder = MitgliedService.findAll();
            for (int i = 0; i < listMitglieder.size(); i++) {
                System.out.println(listMitglieder.get(i));
                if (listMitglieder.get(i).getEmail().equals(jwt.getName())) {
                    return MitgliedService.findById(listMitglieder.get(i).getId());
                }
            }

        }
        else if (jwt.getSubject().equals("Admin")) {
            return MitgliedService.findById(id);
        } 
        return null;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new Mitglied.", description = "Creates a new Mitglied and returns the newly added Mitglied.")
    public Mitglied create(Mitglied Mitglied) {
        if (!Mitglied.getEmail().contains("@")) {
            throw new BadRequestException("Must contain @");
        }
        return MitgliedService.createMitglied(Mitglied);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Deletes an Mitglied.", description = "Deletes an Mitglied by its id.")
    @PermitAll
    public void delete(@PathParam("id") Long id) {
        if (jwt.getSubject().equals("Mitglied") ) {
            List<Mitglied> listMitglieder = MitgliedService.findAll();
            for (int i = 0; i < listMitglieder.size(); i++) {
                System.out.println(listMitglieder.get(i));
                if (listMitglieder.get(i).getEmail().equals(jwt.getName())) {
                    MitgliedService.deleteMitglied(listMitglieder.get(i).getId());
                }
            }

        }
        else if (jwt.getSubject().equals("Admin")) {
            MitgliedService.deleteMitglied(id);
        } 
        return;
    }

    @Path("/{id}")
    @PUT
    @Operation(summary = "Updates an Mitglied.", description = "Updates an Mitglied by its id.")
    public Mitglied update(@PathParam("id") Long id, Mitglied Mitglied) {
       

        if (!Mitglied.getEmail().contains("@")) {
            if (jwt.getSubject().equals("Mitglied") ) {
                List<Mitglied> listMitglieder = MitgliedService.findAll();
                for (int i = 0; i < listMitglieder.size(); i++) {
                    System.out.println(listMitglieder.get(i));
                    if (listMitglieder.get(i).getEmail().equals(jwt.getName())) {
                        return MitgliedService.updateMitglied(listMitglieder.get(i).getId(),Mitglied
                        );
                    }
                }
    
            }
            else if (jwt.getSubject().equals("Admin")) {
                return MitgliedService.updateMitglied(id,Mitglied);
            } 
            throw new BadRequestException("Must contain @");
        }
        return null;
    }

    public JsonWebToken getJwt() {
        return jwt;
    }

    public void setJwt(JsonWebToken jwt) {
        this.jwt = jwt;
    }

    public MitgliedService getMitgliedService() {
        return MitgliedService;
    }

    public void setMitgliedService(MitgliedService mitgliedService) {
        MitgliedService = mitgliedService;
    }

}
