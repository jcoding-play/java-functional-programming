package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @Test
    void _5보다_큰_수들의_합_구하기() {
        int result = numbers.stream()
                .filter(number -> number > 5)
                .reduce(0, (x, y) -> x + y);
        assertThat(result).isEqualTo(40);
    }

    @Test
    void filterAndSortedTest() {
        List<Integer> expected = Arrays.asList(10, 9, 8, 7, 6);
        List<Integer> actual = numbers.stream()
                .filter(number -> number > 5)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void 모든_값들을_제곱으로_변환후_출력() {
        numbers.stream()
                .map(number -> number * number)
                .forEach(System.out::println);
    }

    @Test
    void 스트림을_이용한_짝수_출력() {
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }

    @Test
    void 짝수를_역순으로_출력() {
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    @Test
    void range_메서드_이용한_합_구하기() {
        int result = IntStream
                .range(1, 11)
                .sum();
        assertThat(result).isEqualTo(55);
    }

    @Test
    void rangeAndSkip() {
        int result = IntStream
                .range(1, 11)
                .skip(5)
                .sum();
        assertThat(result).isEqualTo(40);
    }
}
