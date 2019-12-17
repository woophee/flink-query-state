package com.woophee.server.controller;

import com.woophee.server.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/state/v1")
public class StateController {

    @Autowired
    private StateService stateService;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public void query(@RequestParam String jobIdStr,
                      @RequestParam String address) throws IOException {
        stateService.query( jobIdStr, address);
    }
}
