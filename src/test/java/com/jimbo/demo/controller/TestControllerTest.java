package com.jimbo.demo.controller;

import com.jimbo.demo.service.TestServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class TestControllerTest
{
    @Mock
    private TestServiceImpl testService;

    @InjectMocks
    private TestController testController;

    @Test
    public void test() {
        testController.call();
    }

    @Test
    public void test2() {
        testController.newTest();
    }
}
