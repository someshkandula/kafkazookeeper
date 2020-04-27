package com.somesh.kafkasample;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "firstgroup");
        properties.put("auto.offset.reset", "earliest");

        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer<String,String>(properties);
        List topics = new ArrayList();
        topics.add("firstTopic");
        kafkaConsumer.subscribe(topics);
        try{
            while (true){
                ConsumerRecords<String,String> records = kafkaConsumer.poll(10);
                for (ConsumerRecord<String,String> record: records){
                    System.out.println(String.format("Topic - %s, Partition - %d, Value: %s", record.topic(), record.partition(), record.value()));
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            kafkaConsumer.close();
        }
    }
}