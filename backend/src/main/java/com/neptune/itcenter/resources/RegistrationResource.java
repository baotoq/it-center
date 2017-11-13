package com.neptune.itcenter.resources;

import com.neptune.itcenter.boms.Registration;
import com.neptune.itcenter.entities.InvoiceEntity;
import com.neptune.itcenter.entities.RegistrationEntity;
import com.neptune.itcenter.services.ClassService;
import com.neptune.itcenter.services.InvoiceService;
import com.neptune.itcenter.services.RegistrationService;
import com.neptune.itcenter.services.UserService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("registrations")
public class RegistrationResource extends GenericResource {

    @EJB
    private RegistrationService registrationService;
    @EJB
    private UserService userService;
    @EJB
    private ClassService classService;
    @EJB
    private InvoiceService invoiceService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Registration> getAll() {
        List<RegistrationEntity> registrationEntities = registrationService.findAll();
        return registrationService.toBoms(registrationEntities);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response add(@Valid List<Registration> registrations) {
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setStudent(userService.findByUserId(registrations.get(0).getStudent().getId()));
        invoiceService.add(invoiceEntity);
        for (Registration r : registrations) {
            RegistrationEntity registrationEntity = new RegistrationEntity();
            registrationEntity.setInvoice(invoiceEntity);
            registrationEntity.setAttendedClass(classService.findById(r.getAttendedClass().getId()));
            registrationService.add(registrationEntity);
        }
        return Response.ok().build();
    }
}
