package com.neptune.itcenter.resources;

import com.neptune.itcenter.boms.Class;
import com.neptune.itcenter.boms.Invoice;
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
import java.net.URI;
import java.util.List;

@Stateless
@Path("invoices")
public class InvoiceResource extends GenericResource {

    @EJB
    private InvoiceService invoiceService;
    @EJB
    private UserService userService;
    @EJB
    private ClassService classService;
    @EJB
    private RegistrationService registrationService;

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Invoice get(@PathParam("id") Integer id) {
        InvoiceEntity invoiceEntity = invoiceService.findById(id);
        return invoiceService.toBom(invoiceEntity);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Invoice> getAll() {
        List<InvoiceEntity> invoiceEntities = invoiceService.findAll();
        return invoiceService.toBoms(invoiceEntities);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") Integer id, Invoice invoice) {
        invoiceService.update(invoiceService.toEntity(invoice));
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        InvoiceEntity invoiceEntity = invoiceService.findById(id);
        registrationService.delete(registrationService.findAllByInvoiceId(invoiceEntity.getId()));
        invoiceService.delete(invoiceEntity);
        return Response.noContent().build();
    }

    @POST
    @Path("{studentId}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response add(@PathParam("studentId") Integer studentId, @Valid List<Class> classes) {
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setStudent(userService.findByUserId(studentId));
        int total = 0;
        for (Class c : classes) {
            RegistrationEntity registrationEntity = new RegistrationEntity();
            registrationEntity.setInvoice(invoiceEntity);
            registrationEntity.setAttendedClass(classService.findById(c.getId()));
            registrationService.add(registrationEntity);
            total += c.getTuition();
        }
        invoiceEntity.setTotal(total);
        invoiceService.add(invoiceEntity);
        URI createdUri = appendCurrentUriWith(String.valueOf(invoiceEntity.getId()));
        return Response.created(createdUri).type(MediaType.APPLICATION_JSON).location(createdUri).build();
    }
}
