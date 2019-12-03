package com.woophee.stream.transform;

import com.woophee.stream.source.SourceDataModel;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;

public class Process extends ProcessFunction<SourceDataModel, SourceDataModel> {
    @Override
    public void processElement(SourceDataModel sourceDataModel, Context context, Collector<SourceDataModel> collector) throws Exception {

    }
}
