package com.example.loggingConsumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoggingConsumer {

    @KafkaListener(topics = "${logging.topic}", groupId = KafkaProperties.CONSUMER_GROUP_ID)
    public void consume(ConsumerRecord<String, String> record) {
        log.info("kafka consume event {}", record.value());
    }

}
