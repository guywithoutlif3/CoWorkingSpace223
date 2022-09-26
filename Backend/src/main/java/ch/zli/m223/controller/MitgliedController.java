package ch.zli.m223.controller;

import java.util.List;

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

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Mitglied;
import ch.zli.m223.service.MitgliedService;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;

@Path("/Mitglied")
@Tag(name = "Entries", description = "Handling of Mitglieden")
public class MitgliedController {

    @Inject
    MitgliedService MitgliedService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Mitglieden.", description = "Returns a list of all Mitglieden.")
    public List<Mitglied> index() {
        return MitgliedService.findAll();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Mitglieden.", description = "Returns a list of all Mitglieden.")
    public Mitglied findById(@PathParam("id") Long id) {
        return MitgliedService.findById(id);

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new Mitglied.", description = "Creates a new Mitglied and returns the newly added Mitglied.")
    public Mitglied create(Mitglied Mitglied) {
        if(!Mitglied.getEmail().contains("@")){
            throw new BadRequestException("Must contain @");
        }
        return MitgliedService.createMitglied(Mitglied);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Deletes an Mitglied.", description = "Deletes an Mitglied by its id.")
    public void delete(@PathParam("id") Long id) {
        MitgliedService.deleteMitglied(id);
    }

    @Path("/{id}")
    @PUT
    @Operation(summary = "Updates an Mitglied.", description = "Updates an Mitglied by its id.")
    public Mitglied update(@PathParam("id") Long id, Mitglied Mitglied) {
        if(!Mitglied.getEmail().contains("@")){
            throw new BadRequestException("Must contain @");
        }
        return MitgliedService.updateMitglied(id, Mitglied);
    }

}
