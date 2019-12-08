package com.woophee.stream.model;

import org.apache.flink.streaming.api.windowing.windows.TimeWindow;

public class SinkData {
    private TimeWindow timeWindow;
    private SourceData sourceData;

    public SinkData() {
    }

    public SinkData(TimeWindow timeWindow, SourceData sourceData) {
        this.timeWindow = timeWindow;
        this.sourceData = sourceData;
    }

    public TimeWindow getTimeWindow() {
        return timeWindow;
    }

    public void setTimeWindow(TimeWindow timeWindow) {
        this.timeWindow = timeWindow;
    }

    public SourceData getSourceData() {
        return sourceData;
    }

    public void setSourceData(SourceData sourceData) {
        this.sourceData = sourceData;
    }
}
