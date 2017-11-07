package com.vunguyenhung.todo.rest;

import com.vunguyenhung.todo.boms.Todo;
import com.vunguyenhung.todo.entities.TodoEntity;
import com.vunguyenhung.todo.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

/**
 * Created by vunguyenhung on 7/14/17.
 */
@Stateless
@Path("todos")
public class TodoResource {

    private static final Logger logger = LoggerFactory.getLogger(TodoResource.class);

    @EJB
    TodoService todoService;

    @Context
    UriInfo uriInfo;

    /**
     * Save a valid todo into database
     *
     * @param todo is pollutant object in JSON format.
     * @return 201 - CREATED if todo is saved successfully.
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response save(@Valid Todo todo) {
        TodoEntity todoEntity = todoService.save(todo);
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
        todoService.delete(id);
        return Response.ok().build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Todo> read() {
        List<TodoEntity> todoEntities = todoService.findAll();
        return todoService.toBoms(todoEntities);
    }

    private URI appendCurrentUriWith(String fragment) {
        return uriInfo.getAbsolutePathBuilder().path(fragment).build();
    }
}
