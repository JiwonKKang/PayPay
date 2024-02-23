package com.example.loggingConsumer;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("kafka")
@Data
public class KafkaProperties {

    public static final String CONSUMER_GROUP_ID = "paypay.logging.out.stdout";

    @Value("${kafka.clusters.bootstrapservers}")
    private String bootStrapServers;
}
