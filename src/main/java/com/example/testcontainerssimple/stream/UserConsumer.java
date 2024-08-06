package com.example.testcontainerssimple.stream;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

        @KafkaListener(topics = "users", groupId = "group_id")
        public void consume(String message) {
            System.out.println("Consumed message: " + message);
        }

}
