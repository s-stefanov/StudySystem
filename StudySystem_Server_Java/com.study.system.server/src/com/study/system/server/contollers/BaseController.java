package com.study.system.server.contollers;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

public class BaseController {
    @Context
    protected UriInfo context;
}
