package com.petproject.car.sharing.api;

import com.petproject.car.sharing.api.enums.CarModelEnum;
import com.petproject.car.sharing.api.request.CarRequest;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("cars")
@Produces("application/json;charset=UTF-8")
public interface CarSharingService {

    @GET
    @Path("/")
    String getHello();

//    @POST
//    @Path("/reserve")
//    //TODO: подумать про ответ из кафки
//    void reserve(@FormParam("userName") String userName,
//                 @FormParam("carModel") CarModelEnum carModel);

    @POST
    @Path("/reserve")
    @Consumes(MediaType.APPLICATION_JSON)
        //TODO: подумать про ответ из кафки
    void reserve(CarRequest request);

    @POST
    @Path("/cancel")
        //TODO: подумать про ответ из кафки
    void cancel(@Valid CarRequest request);
}
