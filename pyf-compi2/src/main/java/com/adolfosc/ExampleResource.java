package com.adolfosc;

import com.adolfosc.model.Demo;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class ExampleResource {

    @GET
    //@Produces(MediaType.APPLICATION_JSON_TYPE)
    public Response hello() {
        var dem = new Demo();

        dem.setId(1L);
        dem.setName("D");
        dem.setMessage(" te amo");
        return Response.ok(dem).build();
    }
}
