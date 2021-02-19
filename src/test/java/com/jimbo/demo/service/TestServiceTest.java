package com.jimbo.demo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(MockitoJUnitRunner.class)
public class TestServiceTest
{
    private Logger logger = LoggerFactory.getLogger(TestServiceTest.class);
    private TestServiceImpl testService = new TestServiceImpl();

    @Test
    public void test() {
        logger.info("I'm Mr. Meeseeks. Look at me!");
        logger.info("Hey there, I'm Mr. Meeseeks");
        testService.testFunction();
    }

    @Test
    public void failureTest() {
        logger.info("I'mn going to fail dude!");
        testService.testFunction();
        Assert.assertFalse(true);
    }
}
