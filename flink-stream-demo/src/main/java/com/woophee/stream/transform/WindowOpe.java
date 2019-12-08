package com.woophee.stream.transform;

import com.woophee.stream.model.SourceData;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.streaming.api.functions.windowing.RichWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowOpe extends RichWindowFunction<SourceData, SourceData, Tuple1<String>, TimeWindow> {

    private final static Logger logger = LoggerFactory.getLogger(WindowOpe.class);

    @Override
    public void apply(Tuple1<String> stringTuple1, TimeWindow timeWindow, Iterable<SourceData> iterable, Collector<SourceData> collector) throws Exception {

    }
}
