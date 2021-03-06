package com.woophee.stream.transform;

import com.woophee.common.SourceData;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlatMap extends RichFlatMapFunction<SourceData, SourceData> {

    private final static Logger logger = LoggerFactory.getLogger(FlatMap.class);


    @Override
    public void open(Configuration config) {
    }

    @Override
    public void flatMap(SourceData sourceData, Collector<SourceData> collector) throws Exception {
        logger.info("#FlatMap#");
        collector.collect(sourceData);
    }
}
