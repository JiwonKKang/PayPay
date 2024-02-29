package com.example.taskConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = KafkaProperties.class)
public class TaskConsumerApplication {

    public static void main(String[] arg) {
        SpringApplication.run(TaskConsumerApplication.class, arg);
    }

}
