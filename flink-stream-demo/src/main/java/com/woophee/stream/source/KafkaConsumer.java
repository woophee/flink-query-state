package com.woophee.stream.source;

import org.apache.flink.api.common.serialization.SimpleStringSchema;

import java.util.Properties;

public class KafkaConsumer {

    public static FlinkKafkaConsumer011<String> getConsumer(){
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("group.id", "test");
//        FlinkKafkaConsumer011<String> myConsumer = new FlinkKafkaConsumer011<>(
//                java.util.regex.Pattern.compile("test-topic-[0-9]"),
//                new SimpleStringSchema(),
//                properties);
    }
}
