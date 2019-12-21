package com.woophee.stream.transform;

import com.woophee.stream.model.SinkData;
import com.woophee.stream.model.SourceData;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.windowing.RichWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowOpe extends RichWindowFunction<SourceData, SinkData, Tuple1<String>, TimeWindow> {

    private final static Logger logger = LoggerFactory.getLogger(WindowOpe.class);

    private transient ValueState<Tuple2<Long, Long>> sum;

    @Override
    public void open(Configuration config) {
        ValueStateDescriptor<Tuple2<Long, Long>> descriptor =
                new ValueStateDescriptor<>(
                        "average", // the state name
                        TypeInformation.of(new TypeHint<Tuple2<Long, Long>>() {})); // type information
        descriptor.setQueryable("query-name");
        sum = getRuntimeContext().getState(descriptor);
    }
    @Override
    public void apply(Tuple1<String> stringTuple1, TimeWindow timeWindow, Iterable<SourceData> iterable, Collector<SinkData> collector) throws Exception {
        logger.info("#WindowOpe#");
        logger.info("keystate, " + sum);
        iterable.forEach(sourceData -> collector.collect(new SinkData(timeWindow, sourceData)));
    }
}
