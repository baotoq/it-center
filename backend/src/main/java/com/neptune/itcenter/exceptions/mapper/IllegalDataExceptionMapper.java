package com.neptune.itcenter.exceptions.mapper;

import com.neptune.itcenter.exceptions.IllegalDataException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by vunguyenhung on 7/14/17.
 */
@Provider
public class IllegalDataExceptionMapper implements ExceptionMapper<IllegalDataException> {

    @Override
    public Response toResponse(IllegalDataException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).type(MediaType.APPLICATION_JSON).build();
    }
}
