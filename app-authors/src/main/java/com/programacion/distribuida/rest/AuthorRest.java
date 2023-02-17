package com.programacion.distribuida.rest;

import com.programacion.distribuida.db.Authors;
import com.programacion.distribuida.servicios.AuthorRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorRest {

    @GET
    @Path("/{id}")
    @Operation(summary = "Author por id")
    @APIResponse(responseCode = "200", description = "OK",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Authors.class)))
    @APIResponse(responseCode = "404", description = "NOT FOUND")
    public Authors findById(@Parameter(description = "Id author", required = true) @PathParam("id") Integer id) {
        return repository.findById(id);
    }

    @Inject AuthorRepository repository;

    @GET
    @Operation(summary = "Obtiene authors")
    @APIResponse(responseCode = "200", description = "OK",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Authors.class, type = SchemaType.ARRAY)))
    @APIResponse(responseCode = "404", description = "NOT FOUND")
    public List<Authors> findAll() {
        return repository
                .findAll()
                .list();
    }

    @POST
    @Operation(summary = "Nuevo author", description = "Crea nuevo author")
    @APIResponse(responseCode = "204", description = "NOCONTENT")
    public void insert(@RequestBody(description = "Author", required = true,
                                    content = @Content(schema = @Schema(implementation = Authors.class))) Authors obj) {
        repository.persist(obj);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Actualiza author", description = "Actualiza autor por id")
    @APIResponse(responseCode = "204", description = "NO CONTENT")
    public void update(@RequestBody(description = "Author", required = true,
                                    content = @Content(schema = @Schema(implementation = Authors.class))) Authors obj,
                       @Parameter(description = "Id author", required = true) @PathParam("id") Integer id) {

        var author = repository.findById(id);
        author.setFirtName(obj.getFirtName());
        author.setLastName(obj.getLastName());
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Elimina author", description = "Elimina author por id")
    @APIResponse(responseCode = "204", description = "NO CONTENT")
    public void delete(@Parameter(description = "Id author", required = true) @PathParam("id") Integer id ) {
        repository.deleteById(id);
    }
}
