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

import ch.zli.m223.model.Monitor;
import ch.zli.m223.service.MonitorService;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;

@Path("/monitor")
@Tag(name = "Entries", description = "Handling of Monitoren")
public class MonitorController {

    @Inject
    MonitorService MonitorService;

    
    @Inject
    JsonWebToken jwt; 

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new Monitor.", description = "Creates a new Monitor and returns the newly added Monitor.")
    @RolesAllowed("Admin")
    public Monitor create(Monitor Monitor) {
        
        return MonitorService.createMonitor(Monitor);
    }

    
}
