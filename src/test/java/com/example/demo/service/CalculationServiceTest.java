package com.example.demo.service;

import java.util.stream.Stream;

import com.example.demo.exception.WrongParameterException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculationServiceTest {

    @ParameterizedTest
    @MethodSource("getParametersForTest")
    void shouldReturnTheSumOfTwoNumbersWhenCallSumMethod(int argument1, int argument2, int expectedResult) {
        CalculationService calculationService = new CalculationService();

        Integer result = calculationService.sum(argument1, argument2);

        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> getParametersForTest() {
        return Stream.of(
                Arguments.of(3, 4, 7),
                Arguments.of(1, 2, 3),
                Arguments.of(5, 4, 9),
                Arguments.of(2, 2, 4),
                Arguments.of(-1, 5, 4),
                Arguments.of(0, 2, 2)
        );
    }

    @Test
    void shouldThrowWrongParameterExceptionIfFirstArgumentIsNull() {
        CalculationService calculationService = new CalculationService();

       /* assertThrows(WrongParameterException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                calculationService.sum(null, 5);
            }
        });*/
        WrongParameterException exception = assertThrows(WrongParameterException.class, () -> calculationService.sum(null, 5));
        assertThat(exception.getMessage()).contains("First argument is null");
    }

    @Test
    void shouldThrowWrongParameterExceptionIfSecondArgumentIsNull() {
        CalculationService calculationService = new CalculationService();

        WrongParameterException exception = assertThrows(WrongParameterException.class, () -> calculationService.sum(4, null));
        assertThat(exception.getMessage()).contains("Second argument is null");
    }

}