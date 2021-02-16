package com.jimbo.demo.controller;

import com.jimbo.demo.service.TestServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class TestControllerTest
{
    @Mock
    private TestServiceImpl testService;

    @Test
    public void test() {
        TestController testController = new TestController(testService);
        testController.call();
    }

    @Test
    public void test2() {
        TestController testController = new TestController(testService);
        testController.newTest();
    }
}
