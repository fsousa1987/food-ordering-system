package com.food.ordering.system.kafka.producer.service;

import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.Callback;

import java.io.Serializable;

public interface KafkaProducer<K extends Serializable, V extends SpecificRecordBase> {

    void send(String topicName, K key, V message, Callback callback);

}
