package com.petproject.aws.s3.service.rest;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.petproject.aws.s3.api.S3ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class S3ClientServiceRest implements S3ClientService {

    @Value("${car-sharing-app.aws.s3.bucket-name}")
    private String bucketName;

    @Value("${car-sharing-app.kafka.topic-name}")
    private String topicName;

    private final AmazonS3 s3;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    @Scheduled(fixedDelay = 5000)
    public void unload() throws IOException {
        List<String> jsonNames = s3.listObjectsV2(bucketName).getObjectSummaries().stream()
                .map(S3ObjectSummary::getKey)
                .collect(Collectors.toList());


        for (String jsonName : jsonNames) {
            S3Object s3Object = s3.getObject(bucketName, jsonName);
            S3ObjectInputStream inputStream = s3Object.getObjectContent();

            kafkaTemplate.send(topicName, StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8));
        }
    }
}
