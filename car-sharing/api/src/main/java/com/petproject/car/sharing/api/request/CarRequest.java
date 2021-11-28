package com.petproject.car.sharing.api.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.petproject.car.sharing.api.enums.CarModelEnum;
import lombok.*;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {

    @NotNull
    private String userName;

    @NotNull
    private CarModelEnum carModel;
}
