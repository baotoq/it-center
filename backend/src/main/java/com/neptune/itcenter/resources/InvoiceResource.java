package com.neptune.itcenter.resources;

import com.neptune.itcenter.boms.Invoice;
import com.neptune.itcenter.entities.InvoiceEntity;
import com.neptune.itcenter.services.ClassService;
import com.neptune.itcenter.services.InvoiceService;
import com.neptune.itcenter.services.UserService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response add(Invoice invoice) {
        InvoiceEntity invoiceEntity = invoiceService.add(invoice);
        URI createdUri = appendCurrentUriWith(String.valueOf(invoiceEntity.getId()));
        return Response.created(createdUri).type(MediaType.APPLICATION_JSON).location(createdUri).build();
    }
}
