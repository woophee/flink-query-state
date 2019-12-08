package com.woophee.stream;

import com.woophee.stream.model.SinkData;
import com.woophee.stream.sink.ConsoleSink;
import com.woophee.stream.source.KafkaConsumer;
import com.woophee.stream.model.SourceData;
import com.woophee.stream.transform.*;
import com.woophee.stream.transform.Process;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;


public class StreamTopology {

    public static void build(StreamExecutionEnvironment env) {

        DataStreamSink<SinkData> stream = env
                .addSource(KafkaConsumer.build())
                .rebalance()
                .process(new Process())
                .filter(new Filter())
                .flatMap(new FlatMap())
                .keyBy(new KeySelect())
                .window(TumblingEventTimeWindows.of(Time.hours(1)))
                .reduce(new Reduce(), new WindowOpe())
                .addSink(new ConsoleSink());

    }
}
