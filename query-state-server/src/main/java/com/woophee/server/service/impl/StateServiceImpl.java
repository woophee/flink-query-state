package com.woophee.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.woophee.server.SourceData;
import com.woophee.server.service.StateService;
import org.apache.flink.api.common.JobID;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.queryablestate.client.QueryableStateClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Service
public class StateServiceImpl implements StateService {
    private final static Logger logger = LoggerFactory.getLogger(StateServiceImpl.class);

    @Override
    public void query(String jobIdStr, String address) throws IOException {
        JobID jobId = JobID.fromHexString(jobIdStr);
        long key = 1L;

        QueryableStateClient client = new QueryableStateClient(address, 9069);

        ValueStateDescriptor<SourceData> descriptor =
                new ValueStateDescriptor<>(
                        "value-descriptor",
                        TypeInformation.of(new TypeHint<SourceData>() {}));

        CompletableFuture<ValueState<SourceData>> resultFuture =
                client.getKvState(jobId, "stream-query", key, BasicTypeInfo.LONG_TYPE_INFO, descriptor);

        logger.info("get kv state return future, waiting......");
        ValueState<SourceData> res = resultFuture.join();
        logger.info("query result:{} ",res.value());
        logger.info("JSON string result:{} ", JSON.toJSONString(res.value()));
        client.shutdownAndWait();
    }
}
