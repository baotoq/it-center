package com.neptune.itcenter.resources;

import com.neptune.itcenter.boms.Registration;
import com.neptune.itcenter.entities.RegistrationEntity;
import com.neptune.itcenter.services.RegistrationService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("registrations")
public class RegistrationResource extends GenericResource {

    @EJB
    private RegistrationService registrationService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Registration> getAll() {
        List<RegistrationEntity> registrationEntities = registrationService.findAll();
        return registrationService.toBoms(registrationEntities);
    }

    @GET
    @Path("user/{studentId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Registration> getAllByStudentId(@PathParam("studentId") Integer studentId) {
        List<RegistrationEntity> registrationEntities = registrationService.findAllByStudentId(studentId);
        return registrationService.toBoms(registrationEntities);
    }

    @GET
    @Path("class/{classId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Registration> getAllByClassId(@PathParam("classId") Integer classId) {
        List<RegistrationEntity> registrationEntities = registrationService.findAllByClassId(classId);
        return registrationService.toBoms(registrationEntities);
    }

    @PUT
    @Path("update-point")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(List<Registration> registrations) {
        List<RegistrationEntity> registrationEntities = registrationService.toEntities(registrations);
        for (RegistrationEntity r : registrationEntities) {
            registrationService.update(r);
        }
        return Response.ok().build();
    }
}
