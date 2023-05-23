package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * 람다 학습을 위한 간단한 예제
 */
public class JavaStreams {

    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test
    void 모든_수의_합_구하기() {
        int result = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        assertThat(result).isEqualTo(55);
    }

    @Test
    void 짝수_합_구하기() {
        int result = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::valueOf)
                .sum();
        assertThat(result).isEqualTo(30);
    }

    @Test
    void 홀수_합_구하기() {
        int result = numbers.stream()
                .filter(number -> number % 2 == 1)
                .reduce(0, (x, y) -> x + y);
        assertThat(result).isEqualTo(25);
    }
}
