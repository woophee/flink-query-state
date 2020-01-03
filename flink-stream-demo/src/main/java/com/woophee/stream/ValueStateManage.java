package com.woophee.stream;


import com.woophee.common.SourceData;
import org.apache.flink.api.common.state.ReducingStateDescriptor;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;

public class ValueStateManage {

    public static ValueStateDescriptor<SourceData> getValueStateDescriptor(){
        ValueStateDescriptor<SourceData> descriptor =
                new ValueStateDescriptor<>(
                        "value-descriptor",
                        TypeInformation.of(new TypeHint<SourceData>() {}));
        return descriptor;
    }

    public static ReducingStateDescriptor getFoldingStateDescriptor (){
        return null;
    }
}
