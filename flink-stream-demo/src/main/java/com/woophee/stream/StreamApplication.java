package com.woophee.stream;

import org.apache.flink.api.java.ExecutionEnvironment;

public class StreamApplication {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.execute("Window WordCount");
    }
}
