package com.jimbo.demo.controller;

import com.jimbo.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/api/v1")
public class TestController
{
    private final Logger logger = LoggerFactory.getLogger(TestController.class);
    TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<Void> call() {
        logger.info("Calling to the service");
        logger.info("This is a new line hahahahaha");
        logger.warn("This is a warn line");
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/test/new", method = RequestMethod.GET)
    public ResponseEntity<Void> newTest() {
        logger.info("Calling to the service 2");
        logger.info("This is a new line hahahahaha");
        logger.info("This is anotherr new line hahahaha");
        return ResponseEntity.ok(null);
    }
}
