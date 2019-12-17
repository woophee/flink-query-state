package com.woophee.server.service.impl;

import com.woophee.server.service.StateService;
import org.apache.flink.api.common.JobID;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple2;
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
        //flink-core-1.7.0-sources.jar!/org/apache/flink/configuration/QueryableStateOptions.java
        QueryableStateClient client = new QueryableStateClient("127.0.0.1", 9069);

        // the state descriptor of the state to be fetched.
        ValueStateDescriptor<Tuple2<Long, Long>> descriptor =
                new ValueStateDescriptor<>(
                        "average",
                        TypeInformation.of(new TypeHint<Tuple2<Long, Long>>() {}));

        CompletableFuture<ValueState<Tuple2<Long, Long>>> resultFuture =
                client.getKvState(jobId, "query-name", key, BasicTypeInfo.LONG_TYPE_INFO, descriptor);

        logger.info("get kv state return future, waiting......");
        // org.apache.flink.queryablestate.exceptions.UnknownKeyOrNamespaceException: Queryable State Server : No state for the specified key/namespace.
        ValueState<Tuple2<Long, Long>> res = resultFuture.join();
        logger.info("query result:{}",res.value());
        client.shutdownAndWait();
    }
}
