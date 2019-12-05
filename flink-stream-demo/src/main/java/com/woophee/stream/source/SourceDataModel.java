package com.woophee.stream.source;

import java.util.Map;

public class SourceDataModel {
    private Map<String, Object> dataKey;
    private DataValue dataValue;

    public SourceDataModel(Map<String, Object> dataKey, DataValue dataValue){
        this.dataKey = dataKey;
        this.dataValue = dataValue;
    }

    public Map<String, Object> getDataKey() {
        return dataKey;
    }

    public void setDataKey(Map<String, Object> dataKey) {
        this.dataKey = dataKey;
    }

    public DataValue getDataValue() {
        return dataValue;
    }

    public void setDataValue(DataValue dataValue) {
        this.dataValue = dataValue;
    }

    public class DataValue {
        private Integer id;
        private Boolean flag;
        private String attachment;
        private String message;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Boolean getFlag() {
            return flag;
        }

        public void setFlag(Boolean flag) {
            this.flag = flag;
        }

        public String getAttachment() {
            return attachment;
        }

        public void setAttachment(String attachment) {
            this.attachment = attachment;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
