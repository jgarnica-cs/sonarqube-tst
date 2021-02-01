package com.jimbo.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestServiceTest
{
    @Mock
    private TestServiceImpl testService;

    @Test
    public void test() {
        testService.testFunction();
    }
}
