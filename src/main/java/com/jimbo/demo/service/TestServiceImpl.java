package com.jimbo.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService
{
    private Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);
    @Override
    public void testFunction()
    {
        logger.info("This is a test");
        logger.info("This is another test dude");
        logger.info("Hello world!");
        logger.info("Hey I'm Mr. Meeseeks, look at me");
    }

    public void testFunction2() {
        logger.info("Hello world!");
        logger.info("We're actually doing some records here :)");
        logger.info("Why don't you test me?");
    }
}
