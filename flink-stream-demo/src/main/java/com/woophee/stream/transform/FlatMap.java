package com.woophee.stream.transform;

import com.woophee.stream.source.SourceDataModel;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

public class FlatMap extends RichFlatMapFunction<SourceDataModel, SourceDataModel> {

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
    public void flatMap(SourceDataModel sourceDataModel, Collector<SourceDataModel> collector) throws Exception {

    }
}
