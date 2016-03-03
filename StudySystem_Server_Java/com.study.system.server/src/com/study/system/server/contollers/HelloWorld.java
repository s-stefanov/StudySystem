package com.study.system.server.contollers;

//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.system.server.entities.User;
import com.study.system.server.services.ServiceProvider;
 
/**
 * Root resource (exposed at "helloworld" path)
 */
@Path("helloworld")
public class HelloWorld {
    @Context
    private UriInfo context;
 
    /** Creates a new instance of HelloWorld */
    public HelloWorld() {
    }
 
    /**
     * Retrieves representation of an instance of helloWorld.HelloWorld
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getHtml() {
    	ObjectMapper mapper = new ObjectMapper();
    	
    	User user = ServiceProvider.getInstance().getUserService().getUserById(1);
        try {
			return mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			return e.getMessage();
		}
    }
}
