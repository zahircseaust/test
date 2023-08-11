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
		//global exception handler link
                //https://www.geeksforgeeks.org/spring-boot-exception-handling/

		//System.out.println("this value are equeal");
		    @Override
    public ApiResponse getBloodSugarListDaily(String userId, LocalDate date) {
        LocalDateTime dayStart = dateUtilityService.getDayStart(date);
        LocalDateTime dayEnd = dateUtilityService.getDayEnd(date);

        List<BloodSugarListDailyDto> bloodSugarListDailyDtos = bloodSugarRepository.getBloodSugarDaily(dayStart, dayEnd, userId, false).stream().map(bloodSugar -> mapper.map(bloodSugar, BloodSugarListDailyDto.class)).collect(Collectors.toList());
        ApiResponse apiResponse = new ApiResponse(true, DiabeticServiceConstant.BLOOD_SUGAR_LEVEL_DAILY_SUCCESS_MSG,
                bloodSugarListDailyDtos, null);
        return apiResponse;
    }

	}
}
