package com.example.taskConsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskResultProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${task.result.topic}")
    private String topic;

    public void send(String key, Object message) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStringToProduce;

        try {
            jsonStringToProduce = objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error while converting object to json string", e);
        }

        kafkaTemplate.send(topic, key, jsonStringToProduce);
    }


}
