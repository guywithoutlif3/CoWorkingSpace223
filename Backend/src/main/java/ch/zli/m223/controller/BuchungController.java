package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all buchungen.", description = "Returns a list of all buchungen.")
    public List<Buchung> index() {
        return buchungService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new entry.", description = "Creates a new entry and returns the newly added entry.")
    public Buchung create(Buchung buchung) {
       return buchungService.createEntry(buchung);
    }
    @DELETE
    @Path("/{id}")
    @Operation(
        summary = "Deletes an buchung.",
        description = "Deletes an buchung by its id."
    )
    public void delete(@PathParam("id") Long id) {
        buchungService.deleteEntry(id);
    }

    @Path("/{id}")
    @PUT
    @Operation(
        summary = "Updates an entry.",
        description = "Updates an entry by its id."
    )
    public Buchung update(@PathParam("id") Long id, Buchung buchung) {
        return buchungService.updateEntry(id, buchung);
    }
    

}
