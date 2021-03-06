package com.woophee.stream.transform;


import com.woophee.common.SourceData;
import com.woophee.common.SourceDataValue;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeySelect implements KeySelector<SourceData, Tuple1<String>> {

    private final static Logger logger = LoggerFactory.getLogger(KeySelect.class);

    @Override
    public Tuple1<String> getKey(SourceData sourceData) throws Exception {
        SourceDataValue dataValue = sourceData.getDataValue();
        Integer id = dataValue.getId();
        logger.info("#KeySelect# id:" + id);
        return new Tuple1<>(String.valueOf(id));
    }
}
