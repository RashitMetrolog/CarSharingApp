package com.petproject.car.sharing.service.rest;

import com.petproject.car.sharing.api.CarSharingService;
import com.petproject.car.sharing.api.request.CarRequest;
import com.petproject.car.sharing.service.kafka.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CarSharingServiceRest implements CarSharingService {

    @Value("${car-sharing-app.kafka.topic-name}")
    private String topicName;

    private final KafkaTemplate<String, CarDto> kafkaTemplate;

    @Override
    public void reserve(CarRequest request) {
        CarDto car = new CarDto();
        car.setUserName(request.getUserName());
        car.setCarModel(request.getCarModel());
        car.setIsReservationRequired(Boolean.TRUE);

        kafkaTemplate.send(topicName, car);
    }

    @Override
    public void cancel(CarRequest request) {
        CarDto car = new CarDto();
        car.setUserName(request.getUserName());
        car.setCarModel(request.getCarModel());
        car.setIsReservationRequired(Boolean.FALSE);

        kafkaTemplate.send(topicName, car);
    }
}
