package com.petproject.car.sharing.service.kafka.dto;

import com.petproject.car.sharing.api.enums.CarModelEnum;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CarDto implements Serializable {
    private String userName;
    private CarModelEnum carModel;
    private Boolean isReservationRequired;
}
