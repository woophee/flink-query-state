package com.woophee.stream.transform;

import com.woophee.stream.model.SourceData;
import org.apache.flink.api.common.functions.RichReduceFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reduce extends RichReduceFunction<SourceData> {

    private final static Logger logger = LoggerFactory.getLogger(Reduce.class);

    @Override
    public SourceData reduce(SourceData sourceData, SourceData t1) throws Exception {
        return null;
    }
}
