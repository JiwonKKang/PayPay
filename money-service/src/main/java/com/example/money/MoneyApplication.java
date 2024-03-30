package com.example.money;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class MoneyApplication {

    public static void main(String[] arg) {
        SpringApplication.run(MoneyApplication.class, arg);
    }

}
