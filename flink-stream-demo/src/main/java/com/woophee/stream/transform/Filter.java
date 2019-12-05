package com.woophee.stream.transform;

import com.woophee.stream.source.SourceDataModel;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.RichFilterFunction;

public class Filter extends RichFilterFunction<SourceDataModel> {
    @Override
    public boolean filter(SourceDataModel sourceDataModel) throws Exception {
        return true;
    }
}
