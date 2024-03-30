package com.example.money.adapter.out.kafka;

import com.example.common.RechargingMoneyTask;
import com.example.money.applicaiton.port.out.SendRechargingMoneyTaskPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

//@Component
//@RequiredArgsConstructor
//public class TaskProducer implements SendRechargingMoneyTaskPort {
//
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    @Value("${topic.task}")
//    private String topic;
//
//    @Override
//    public void sendRechargingMoneyTask(RechargingMoneyTask task) {
//        String jsonToProduce;
//        try {
//            jsonToProduce = new ObjectMapper().writeValueAsString(task);
//        } catch (Exception e) {
//            throw new RuntimeException("Error while converting object to json string", e);
//        }
//        ProducerRecord<String, String> record = new ProducerRecord<>(topic, task.getTaskId(), jsonToProduce);
//        kafkaTemplate.send(record);
//    }
//
//}
