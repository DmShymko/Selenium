package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CalculatorTest {

    Calculator calculator;
    @Tag("T4")
    @Tag("Regression")
    @DisplayName("Test calculator")
    @Order(4)
    @ParameterizedTest
    @CsvSource({
            "5, 10, 15",
            "15, 20, 35",
            "20, 25, 45"
    })
    void addition(int a, int b, int expectedResult) {
        calculator = new Calculator();


        int actualResult = calculator.addition(a, b);

        assertThat("Result is not correct: ", actualResult, equalTo(expectedResult)); //UWAGA! zamienien miestami actual result i expected result
        System.out.println("END TEST");
    }
//    @Test
//    void addition() {
//        calculator = new Calculator();
//
//        int expectedResult = 15;
//        int actualResult = calculator.addition(5, 10);
//
//        assertThat("Result is not correct: ", expectedResult, equalTo(actualResult));
//        System.out.println("END TEST");
//    }

    @Test
    void subtraction() {
        calculator = new Calculator();

        int expectedResult = 5;
        int actualResult = calculator.subtraction(10, 5);

        assertThat("Result is not correct: ", expectedResult, equalTo(actualResult));
        System.out.println("END TEST");
    }

    @Test
    void multiplication() {
        calculator = new Calculator();

        int expectedResult = 50;
        int actualResult = calculator.multiplication(5, 10);

        assertThat("Result is not correct: ", expectedResult, equalTo(actualResult));
        System.out.println("END TEST");
    }

    @Test
    void division() {
        calculator = new Calculator();

        int expectedResult = 2;
        int actualResult = calculator.division(10, 5);

        assertThat("Result is not correct: ", expectedResult, equalTo(actualResult));
        System.out.println("END TEST");
    }
}