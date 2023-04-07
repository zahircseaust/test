package com.example.demo.controller;

import com.example.demo.Calculator;
import org.junit.jupiter.api.Test;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

    class AppControllerTest {
    @Test
    void testSum() {
        int expectedValue = 15;
        Calculator calculator = new Calculator();
        int desValue = calculator.addValue(10, 5);
        assertThat(expectedValue).isEqualTo(desValue);
    }
    }

