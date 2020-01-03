package com.woophee.stream.transform;

import com.woophee.common.SourceData;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Process extends ProcessFunction<SourceData, SourceData> {

    private final static Logger logger = LoggerFactory.getLogger(Process.class);

    @Override
    public void processElement(SourceData sourceData, Context context, Collector<SourceData> collector) throws Exception {
        logger.info("#Process#");
        collector.collect(sourceData);
    }
}
