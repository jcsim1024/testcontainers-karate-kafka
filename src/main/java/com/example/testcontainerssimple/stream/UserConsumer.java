package com.example.testcontainerssimple.stream;


import com.example.testcontainerssimple.stream.avro.UserAvro;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

        @KafkaListener(topics = "users", groupId = "group_id")
        public void consume(ConsumerRecord<String, UserAvro> consumerRecord) {
            System.out.println("Consumed message: " + consumerRecord.value());
        }

}
