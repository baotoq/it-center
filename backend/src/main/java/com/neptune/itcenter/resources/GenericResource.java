package com.neptune.itcenter.resources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

public abstract class GenericResource {
    @Context
    private UriInfo uriInfo;

    protected URI appendCurrentUriWith(String fragment) {
        return uriInfo.getAbsolutePathBuilder().path(fragment).build();
    }
}
