package com.woophee.server.service;

import java.io.IOException;
import java.net.UnknownHostException;

public interface StateService {
    void query(String jobIdStr, String address) throws IOException;
}
