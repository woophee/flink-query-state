package com.woophee.stream.source;

import com.woophee.stream.model.SourceData;
import com.woophee.stream.model.SourceDataValue;
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;

import javax.annotation.Nullable;
import java.util.Map;

public class KafkaWatermarks implements AssignerWithPeriodicWatermarks<SourceData> {

    private final long maxOutOfOrderness = 3000; // 3.0 seconds

    private long currentMaxTimestamp;

    @Nullable
    @Override
    public Watermark getCurrentWatermark() {
        return new Watermark(currentMaxTimestamp - maxOutOfOrderness);
    }

    @Override
    public long extractTimestamp(SourceData sourceData, long l) {
        Map<String, Object> dataKey = sourceData.getDataKey();
        SourceDataValue dataValue = sourceData.getSourceDataValue();
        Long timestamp = dataValue.getTimestamp();
        currentMaxTimestamp = Math.max(timestamp, currentMaxTimestamp);
        return timestamp;
    }
}
