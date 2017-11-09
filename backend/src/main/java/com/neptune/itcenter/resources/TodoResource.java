package com.neptune.itcenter.resources;

import com.neptune.itcenter.boms.Todo;
import com.neptune.itcenter.entities.TodoEntity;
import com.neptune.itcenter.services.TodoService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;


@Stateless
@Path("todos")
public class TodoResource {

    @EJB
    private TodoService todoService;

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Todo> read() {
        List<TodoEntity> todoEntities = todoService.findAll();
        return todoService.toBoms(todoEntities);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response add(@Valid Todo todo) {
        TodoEntity todoEntity = todoService.add(todo);
        URI createdUri = appendCurrentUriWith(String.valueOf(todoEntity.getId()));
        return Response.created(createdUri).type(MediaType.APPLICATION_JSON).location(createdUri).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") Integer id, @Valid Todo todo) {
        todo.setId(id);
        todoService.update(todo);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        TodoEntity todoEntity = todoService.findById(id);
        todoService.delete(todoEntity);
        return Response.ok().build();
    }

    private URI appendCurrentUriWith(String fragment) {
        return uriInfo.getAbsolutePathBuilder().path(fragment).build();
    }
}
