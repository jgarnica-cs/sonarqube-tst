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
        logger.info("Hey there! I'm Mr. Meesesks");
    }
}
