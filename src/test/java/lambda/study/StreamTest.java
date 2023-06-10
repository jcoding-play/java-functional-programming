package lambda.study;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class StreamTest {
    @Test
    void 배열로_반환하기() {
        int[] result = IntStream.range(5, 11)
                .toArray();

        assertThat(result).containsExactly(5, 6, 7, 8, 9, 10);
    }

    @Test
    void x만큼_증가하여_배열로_반환하기() {
        int x = 5;
        int[] result = IntStream.iterate(0, i -> i + x)
                .limit(5)
                .toArray();

        assertThat(result).containsExactly(0, 5, 10, 15, 20);
    }

    @Test
    void List를_배열로_반환하기() {
        List<String> source = List.of("hello", "stream");

        String[] result = source.toArray(new String[0]);
        assertThat(result).containsExactly("hello", "stream");
    }

    @Test
    void x값에대해_약수_찾기() {
        int x = 10;
        int[] result = IntStream.range(1, x)
                .filter(num -> x % num == 0)
                .toArray();

        assertThat(result).containsExactly(1, 2, 5);
    }

    @Test
    void x값에대해_약수_더하기() {
        int x = 10;
        int result = IntStream.range(1, x)
                .filter(num -> x % num == 0)
                .sum();

        assertThat(result).isEqualTo(8);
    }

    @Test
    void 해당_값이_짝수면_Even_홀수면_Odd_값_얻기() {
        int num = 4;
        String result = Optional.of(num)
                .filter(n -> n % 2 == 0)
                .map(n -> "Even")
                .orElse("Odd");

        assertThat(result).isEqualTo("Even");
    }
}
