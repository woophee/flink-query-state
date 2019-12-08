package com.woophee.stream.source;

import com.alibaba.fastjson.JSON;
import com.woophee.stream.model.SourceData;
import com.woophee.stream.model.SourceDataValue;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.connectors.kafka.KafkaDeserializationSchema;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;

public class KafkaDeserializer implements KafkaDeserializationSchema<SourceData> {
    @Override
    public boolean isEndOfStream(SourceData sourceData) {
        return false;
    }

    @Override
    public SourceData deserialize(ConsumerRecord<byte[], byte[]> consumerRecord) throws Exception {
        byte[] key = consumerRecord.key();
        byte[] value = consumerRecord.value();
        Map<String, Object> dataKey = JSON.parseObject(key, Map.class);
        SourceDataValue dataValue = JSON.parseObject(value, SourceDataValue.class);
        return new SourceData(dataKey, dataValue);
    }

    @Override
    public TypeInformation<SourceData> getProducedType() {
        return TypeInformation.of(SourceData.class);
    }
}
