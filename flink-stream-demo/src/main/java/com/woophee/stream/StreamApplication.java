package com.woophee.stream;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StreamApplication {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        StreamTopology.build(env);
        env.execute("Stream Demo");
    }
}
