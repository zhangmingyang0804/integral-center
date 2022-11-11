package com.leimon.backstage.controller;

import com.leimon.backstage.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("test")
    public Map<String, Object> test(@RequestBody Map<String, Object> req) {
        return testService.test(req);
    }
}
