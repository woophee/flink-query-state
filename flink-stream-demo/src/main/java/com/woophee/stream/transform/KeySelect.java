package com.woophee.stream.transform;


import com.woophee.stream.source.SourceDataModel;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple0;
import org.apache.flink.api.java.tuple.Tuple1;

public class KeySelect implements KeySelector<SourceDataModel, Tuple1<String>> {
    @Override
    public Tuple1<String> getKey(SourceDataModel sourceDataModel) throws Exception {
        return null;
    }
}
