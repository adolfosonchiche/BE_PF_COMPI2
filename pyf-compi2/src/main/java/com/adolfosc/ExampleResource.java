package com.adolfosc;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class ExampleResource {

    @GET
    //@Produces(MediaType.APPLICATION_JSON_TYPE)
    public String hello() {
        return "TAMFDTS ST";
    }
}
