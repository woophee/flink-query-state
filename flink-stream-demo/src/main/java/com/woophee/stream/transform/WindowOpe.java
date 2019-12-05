package com.woophee.stream.transform;

import com.woophee.stream.source.SourceDataModel;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.streaming.api.functions.windowing.RichWindowFunction;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.api.windowing.windows.Window;
import org.apache.flink.util.Collector;

public class WindowOpe extends RichWindowFunction<SourceDataModel, SourceDataModel, Tuple1<String>, TimeWindow> {
    @Override
    public void apply(Tuple1<String> stringTuple1, TimeWindow timeWindow, Iterable<SourceDataModel> iterable, Collector<SourceDataModel> collector) throws Exception {

    }
}
