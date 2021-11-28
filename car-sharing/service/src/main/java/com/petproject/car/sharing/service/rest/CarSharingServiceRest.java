package com.petproject.car.sharing.service.rest;

import com.petproject.car.sharing.api.CarSharingService;
import com.petproject.car.sharing.api.enums.CarModelEnum;
import com.petproject.car.sharing.api.request.CarRequest;
import com.petproject.car.sharing.service.kafka.dto.CarDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CarSharingServiceRest implements CarSharingService {

    @Value("${car-sharing-app.kafka.topic-name}")
    private String topicName;

    private final KafkaTemplate<String, CarDto> kafkaTemplate;

    @Override
    public String getHello() {
        return "Hello";
    }

//    @Override
//    public void reserve(String userName, CarModelEnum carModel) {
//        CarDto car = new CarDto();
//        car.setUserName(userName);
//        car.setCarModel(carModel);
//        car.setIsReservationRequired(Boolean.TRUE);
//
//        kafkaTemplate.send(topicName, car);
//    }

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
