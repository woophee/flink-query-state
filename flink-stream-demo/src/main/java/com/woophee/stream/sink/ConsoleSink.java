package com.woophee.stream.sink;

import com.woophee.stream.model.SourceData;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

public class ConsoleSink extends RichSinkFunction<SourceData> {
    @Override
    public void invoke(SourceData value, Context context) throws Exception {

    }
}
