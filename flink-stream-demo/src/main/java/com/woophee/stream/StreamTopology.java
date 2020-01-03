package com.woophee.stream;

import com.woophee.common.SourceData;
import com.woophee.stream.model.SinkData;
import com.woophee.stream.sink.ConsoleSink;
import com.woophee.stream.source.KafkaConsumer;
import com.woophee.stream.transform.*;
import com.woophee.stream.transform.Process;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;


public class StreamTopology {

    public static void build(StreamExecutionEnvironment env) {

        KeyedStream<SourceData, Tuple1<String>> keyedStream = env
                .addSource(KafkaConsumer.build())
                .rebalance()
                .process(new Process())
                .filter(new Filter())
                .flatMap(new FlatMap())
                .keyBy(new KeySelect());

        //老组合
        SingleOutputStreamOperator<SinkData> singleOutputStreamOperator = keyedStream
                .window(TumblingEventTimeWindows.of(Time.minutes(1)))
                .reduce(new Reduce(), new WindowOpe());

        singleOutputStreamOperator.addSink(new ConsoleSink());

        keyedStream.asQueryableState("stream-query", ValueStateManage.getValueStateDescriptor());
    }
}
