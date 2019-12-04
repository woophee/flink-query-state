package com.woophee.stream.sink;

import com.woophee.stream.source.SourceDataModel;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

public class ConsoleSink implements SinkFunction<SourceDataModel> {
    @Override
    public void invoke(SourceDataModel value, Context context) throws Exception {

    }
}
