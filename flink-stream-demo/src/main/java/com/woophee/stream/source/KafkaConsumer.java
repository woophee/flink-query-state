package com.woophee.stream.source;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class KafkaConsumer {

    private static final String topic = "test";

    public static FlinkKafkaConsumer<SourceDataModel> build(){
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("group.id", "test");
        FlinkKafkaConsumer<SourceDataModel> kafkaConsumer = new FlinkKafkaConsumer<>(
                topic,
                new KafkaDeserializer(),
                properties);
        kafkaConsumer.assignTimestampsAndWatermarks(new KafkaWatermarks());
        return kafkaConsumer;
    }
}
