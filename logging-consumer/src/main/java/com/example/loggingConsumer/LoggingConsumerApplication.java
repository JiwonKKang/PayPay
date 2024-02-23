package com.example.loggingConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = KafkaProperties.class)
public class LoggingConsumerApplication {

    public static void main(String[] arg) {
        SpringApplication.run(LoggingConsumerApplication.class, arg);
    }

}
