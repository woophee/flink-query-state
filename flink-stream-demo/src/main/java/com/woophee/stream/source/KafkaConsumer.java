package com.woophee.stream.source;

import com.woophee.stream.model.SourceData;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class KafkaConsumer {

    private static final String topic = "state";

    public static FlinkKafkaConsumer<SourceData> build(){
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "47.110.139.169:9092");
        properties.setProperty("group.id", "stream_demo");
        FlinkKafkaConsumer<SourceData> kafkaConsumer = new FlinkKafkaConsumer<>(
                topic,
                new KafkaDeserializer(),
                properties);
        kafkaConsumer.assignTimestampsAndWatermarks(new KafkaWatermarks());
        return kafkaConsumer;
    }
}
