package com.woophee.stream;

import com.woophee.stream.sink.ConsoleSink;
import com.woophee.stream.source.KafkaConsumer;
import com.woophee.stream.source.SourceDataModel;
import com.woophee.stream.transform.*;
import com.woophee.stream.transform.Process;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;


public class StreamTopology {

    public static void build(StreamExecutionEnvironment env) {

        DataStreamSink<SourceDataModel> stream = env
                .addSource(KafkaConsumer.build())
                .rebalance()
                .process(new Process())
                .filter(new Filter())
                .flatMap(new FlatMap())
                .keyBy(new KeySelect())
                .timeWindow(Time.seconds(5))
                .reduce(new Reduce())
                .addSink(new ConsoleSink());

    }
}
