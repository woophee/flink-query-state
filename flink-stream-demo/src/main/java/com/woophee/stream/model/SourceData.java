package com.woophee.stream.model;

import java.util.Map;

public class SourceData {
    private Map<String, Object> dataKey;
    private SourceDataValue dataValue;

    public SourceData() {
    }

    public SourceData(Map<String, Object> dataKey, SourceDataValue dataValue){
        this.dataKey = dataKey;
        this.dataValue = dataValue;
    }

    public Map<String, Object> getDataKey() {
        return dataKey;
    }

    public void setDataKey(Map<String, Object> dataKey) {
        this.dataKey = dataKey;
    }

    public SourceDataValue getDataValue() {
        return dataValue;
    }

    public void setDataValue(SourceDataValue dataValue) {
        this.dataValue = dataValue;
    }
}
