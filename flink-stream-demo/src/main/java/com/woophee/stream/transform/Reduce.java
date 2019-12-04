package com.woophee.stream.transform;

import com.woophee.stream.source.SourceDataModel;
import org.apache.flink.api.common.functions.ReduceFunction;

public class Reduce implements ReduceFunction<SourceDataModel> {
    @Override
    public SourceDataModel reduce(SourceDataModel sourceDataModel, SourceDataModel t1) throws Exception {
        return null;
    }
}
