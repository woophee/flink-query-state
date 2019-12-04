package com.woophee.stream.transform;

import com.woophee.stream.source.SourceDataModel;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public class FlatMap implements FlatMapFunction<SourceDataModel, SourceDataModel> {
    @Override
    public void flatMap(SourceDataModel sourceDataModel, Collector<SourceDataModel> collector) throws Exception {

    }
}
