package com.woophee.stream.source;

import com.woophee.common.SourceData;
import com.woophee.common.SourceDataValue;
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.util.Map;

public class KafkaWatermarks implements AssignerWithPeriodicWatermarks<SourceData> {

    private final static Logger logger = LoggerFactory.getLogger(KafkaWatermarks.class);

    private final long maxOutOfOrderness = 3000; // 3.0 seconds

    private long currentMaxTimestamp;

    @Nullable
    @Override
    public Watermark getCurrentWatermark() {
        return new Watermark(System.currentTimeMillis() - maxOutOfOrderness);
    }

    @Override
    public long extractTimestamp(SourceData sourceData, long l) {
        Map<String, Object> dataKey = sourceData.getDataKey();
        SourceDataValue dataValue = sourceData.getDataValue();
        Long timestamp = dataValue.getTimestamp();
        logger.info("timestamp: " + timestamp);
        currentMaxTimestamp = Math.max(timestamp, currentMaxTimestamp);
        logger.info("currentMaxTimestamp: " + currentMaxTimestamp);
        return timestamp;
    }
}
