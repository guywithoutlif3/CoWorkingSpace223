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

import ch.zli.m223.model.Buchung;
import ch.zli.m223.service.BuchungService;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;

@Path("/buchung")
@Tag(name = "Entries", description = "Handling of buchungen")
public class BuchungController {

    @Inject
    BuchungService buchungService;


    
    @Inject
    JsonWebToken jwt; 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all buchungen.", description = "Returns a list of all buchungen.")
    @RolesAllowed("Admin")

    public List<Buchung> index() {
        return buchungService.findAll();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all buchungen.", description = "Returns a list of all buchungen by ID.")
    public Buchung findById(@PathParam("id") Long id) {
        return buchungService.findById(id);

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"Admin","Mitglied"})
    @Operation(summary = "Creates a new buchung.", description = "Creates a new buchung and returns the newly added buchung.")
    public Buchung create(Buchung buchung) {
        
        return buchungService.createBuchung(buchung);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Deletes an buchung.", description = "Deletes an buchung by its id.")
    public void delete(@PathParam("id") Long id) {
        buchungService.deleteBuchung(id);
    }

    @Path("/{id}")
    @PUT
    @Operation(summary = "Updates an Buchung.", description = "Updates an Buchung by its id.")
    @RolesAllowed("Admin")

    public Buchung update(@PathParam("id") Long id, Buchung buchung) {
        return buchungService.updateBuchung(id, buchung);
    }

}
