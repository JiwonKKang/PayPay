package com.example.money;

import com.example.money.config.KafkaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = KafkaProperties.class)
public class MoneyApplication {

    public static void main(String[] arg) {
        SpringApplication.run(MoneyApplication.class, arg);
    }

}
