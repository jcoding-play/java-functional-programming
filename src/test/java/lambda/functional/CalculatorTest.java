package lambda.functional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    void calculateTest_더하기() {
        MyCalculator calculator = (a, b) -> a + b;
        assertThat(calculator.calculate(10, 2)).isEqualTo(12);
    }

    @Test
    void calculateTest_빼기() {
        MyCalculator calculator = (a, b) -> a - b;
        assertThat(calculator.calculate(10, 2)).isEqualTo(8);
    }

    @Test
    void calculateTest_곱하기() {
        MyCalculator calculator = (a, b) -> a * b;
        assertThat(calculator.calculate(10, 2)).isEqualTo(20);
    }

    @Test
    void calculateTest_나누기() {
        MyCalculator calculator = (a, b) -> a / b;
        assertThat(calculator.calculate(10, 2)).isEqualTo(5);
    }
}
