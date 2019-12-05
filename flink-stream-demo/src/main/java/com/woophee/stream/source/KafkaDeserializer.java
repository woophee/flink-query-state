package com.woophee.stream.source;

import com.alibaba.fastjson.JSON;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.connectors.kafka.KafkaDeserializationSchema;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;

public class KafkaDeserializer implements KafkaDeserializationSchema<SourceDataModel> {
    @Override
    public boolean isEndOfStream(SourceDataModel sourceDataModel) {
        return false;
    }

    @Override
    public SourceDataModel deserialize(ConsumerRecord<byte[], byte[]> consumerRecord) throws Exception {
        byte[] key = consumerRecord.key();
        byte[] value = consumerRecord.value();
        Map<String, Object> dataKey = JSON.parseObject(key, Map.class);
        SourceDataModel.DataValue dataValue = JSON.parseObject(value, SourceDataModel.DataValue.class);
        return new SourceDataModel(dataKey, dataValue);
    }

    @Override
    public TypeInformation<SourceDataModel> getProducedType() {
        return TypeInformation.of(SourceDataModel.class);
    }
}
