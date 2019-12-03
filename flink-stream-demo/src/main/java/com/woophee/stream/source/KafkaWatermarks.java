package com.woophee.stream.source;

import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;

import javax.annotation.Nullable;

public class KafkaWatermarks implements AssignerWithPeriodicWatermarks<SourceDataModel> {
    @Nullable
    @Override
    public Watermark getCurrentWatermark() {
        return null;
    }

    @Override
    public long extractTimestamp(SourceDataModel sourceDataModel, long l) {
        return 0;
    }
}
