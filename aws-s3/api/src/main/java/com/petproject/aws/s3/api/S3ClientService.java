package com.petproject.aws.s3.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("aws-s3")
@Produces(MediaType.APPLICATION_JSON)
public interface S3ClientService {

    @POST
    @Path("/unload")
    void unload() throws IOException;
}
