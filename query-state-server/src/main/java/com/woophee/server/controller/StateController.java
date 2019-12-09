package com.woophee.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/state/v1")
public class StateController {

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public void query() {
    }
}
