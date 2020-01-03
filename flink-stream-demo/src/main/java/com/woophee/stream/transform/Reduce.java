package com.woophee.stream.transform;

import com.woophee.common.SourceData;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reduce implements ReduceFunction<SourceData> {

    private final static Logger logger = LoggerFactory.getLogger(Reduce.class);

    @Override
    public SourceData reduce(SourceData t1, SourceData t2) throws Exception {
        logger.info("#Reduce#");
        return t2;
    }
}
