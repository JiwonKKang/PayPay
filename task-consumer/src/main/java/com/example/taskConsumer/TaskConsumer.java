package com.example.taskConsumer;

import com.example.common.RechargingMoneyTask;
import com.example.common.SubTask;
import com.example.common.TaskStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskConsumer {

    private final TaskResultProducer taskResultProducer;

    @KafkaListener(topics = "${task.topic}", groupId = KafkaProperties.CONSUMER_GROUP_ID)
    public void consume(ConsumerRecord<String, String> record) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            RechargingMoneyTask rechargingMoneyTask = objectMapper.readValue(record.value(), RechargingMoneyTask.class);
            for (SubTask subTask : rechargingMoneyTask.getSubTaskList()) {
                subTask.setStatus(TaskStatus.SUCCESS);
            }
            taskResultProducer.send(rechargingMoneyTask.getTaskId(), rechargingMoneyTask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
