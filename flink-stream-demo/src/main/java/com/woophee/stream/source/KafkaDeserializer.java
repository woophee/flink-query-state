package com.woophee.stream.source;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.connectors.kafka.KafkaDeserializationSchema;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class KafkaDeserializer implements KafkaDeserializationSchema<SourceDataModel> {
    @Override
    public boolean isEndOfStream(SourceDataModel sourceDataModel) {
        return false;
    }

    @Override
    public SourceDataModel deserialize(ConsumerRecord<byte[], byte[]> consumerRecord) throws Exception {
        return null;
    }

    @Override
    public TypeInformation<SourceDataModel> getProducedType() {
        return TypeInformation.of(SourceDataModel.class);
    }
}
