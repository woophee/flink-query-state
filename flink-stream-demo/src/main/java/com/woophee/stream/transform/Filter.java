package com.woophee.stream.transform;

import com.woophee.stream.model.SourceData;
import org.apache.flink.api.common.functions.RichFilterFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Filter extends RichFilterFunction<SourceData> {

    private final static Logger logger = LoggerFactory.getLogger(Filter.class);

    @Override
    public boolean filter(SourceData sourceData) throws Exception {
        logger.info("#Filter#");
        return true;
    }
}
