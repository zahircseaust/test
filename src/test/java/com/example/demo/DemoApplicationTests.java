package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testSum() {
		int expectedValue = 15;
		Calculator calculator = new Calculator();
		int desValue = calculator.addValue(10, 5);
		assertThat(expectedValue).isEqualTo(desValue);


		System.out.println("this value are equeal");
	}
}
