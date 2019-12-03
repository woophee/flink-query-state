package com.woophee.stream.transform;

import com.woophee.stream.source.SourceDataModel;
import org.apache.flink.api.common.functions.FilterFunction;

public class Filter implements FilterFunction<SourceDataModel> {
    @Override
    public boolean filter(SourceDataModel sourceDataModel) throws Exception {
        return true;
    }
}
