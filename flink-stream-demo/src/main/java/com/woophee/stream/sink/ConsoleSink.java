package com.woophee.stream.sink;

import com.alibaba.fastjson.JSON;
import com.woophee.stream.model.SinkData;
import com.woophee.stream.transform.KeySelect;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class ConsoleSink extends RichSinkFunction<SinkData> {

    private final static Logger logger = LoggerFactory.getLogger(KeySelect.class);

    @Override
    public void invoke(SinkData value, Context context) throws Exception {
        logger.info("#ConsoleSink# + '\n'"
                + "startWindow: " + new Date(value.getTimeWindow().getStart())
                + "endWindow: " + new Date(value.getTimeWindow().getEnd())
                + "data: " + JSON.toJSONString(value.getSourceData()));
    }
}
