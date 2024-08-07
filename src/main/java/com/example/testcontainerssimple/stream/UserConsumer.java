package com.example.testcontainerssimple.stream;


import com.example.testcontainerssimple.entities.Customer;
import com.example.testcontainerssimple.repository.CustomerRepository;
import com.example.testcontainerssimple.stream.avro.UserAvro;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {
    @Autowired
    CustomerRepository userRepository;

        @KafkaListener(topics = "users", groupId = "group_id")
        public void onMessage(ConsumerRecord<String, UserAvro> consumerRecord) {

            userRepository.save(new Customer(Long.valueOf((Integer)consumerRecord.value().getId()), consumerRecord.value().getName(), consumerRecord.value().getEmail()));

        }

}
