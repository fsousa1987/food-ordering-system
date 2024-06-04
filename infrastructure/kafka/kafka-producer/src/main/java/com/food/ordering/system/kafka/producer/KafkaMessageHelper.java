package com.food.ordering.system.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaMessageHelper {

    public <T> Callback getKafkaCallback(String responseTopicName, T avroModel, String orderId, String avroModelName) {
        return (metadata, ex) -> {
            if (ex != null) {
                log.error("Error while sending {} message {} to topic {}",
                        avroModelName, avroModel.toString(), responseTopicName, ex);
            } else {
                log.info("Received successful response from Kafka for order id: {}" +
                                " Topic: {} Partition: {} Offset: {} Timestamp: {}",
                        orderId,
                        metadata.topic(),
                        metadata.partition(),
                        metadata.offset(),
                        metadata.timestamp());
            }
        };
    }

}
