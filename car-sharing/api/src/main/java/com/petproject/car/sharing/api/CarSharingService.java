package com.petproject.car.sharing.api;

import com.petproject.car.sharing.api.request.CarRequest;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cars")
@Produces(MediaType.APPLICATION_JSON)
public interface CarSharingService {

    @POST
    @Path("/reserve")
        //TODO: подумать про ответ из кафки
    void reserve(@Valid CarRequest request);

    @POST
    @Path("/cancel")
        //TODO: подумать про ответ из кафки
    void cancel(@Valid CarRequest request);
}
