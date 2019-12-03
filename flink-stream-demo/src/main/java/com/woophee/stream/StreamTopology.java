package com.woophee.stream;

import com.woophee.stream.source.KafkaConsumer;
import com.woophee.stream.source.SourceDataModel;
import com.woophee.stream.transform.Filter;
import com.woophee.stream.transform.KeySelect;
import com.woophee.stream.transform.Process;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;


public class StreamTopology {

    public static void build(StreamExecutionEnvironment env){

        KeyedStream<SourceDataModel, Tuple1<String>> stream = env
                .addSource(KafkaConsumer.build())
                .process(new Process())
                .filter(new Filter())
                .keyBy(new KeySelect());
    }
}
