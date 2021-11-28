package com.petproject.car.sharing.api.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.petproject.car.sharing.api.enums.CarModelEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class CarRequest implements Serializable {

    @NotNull
    private String userName;

    @NotNull
    private CarModelEnum carModel;
}
