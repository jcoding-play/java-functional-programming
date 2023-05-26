package optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class OptionalTest {
    @Test
    void create_emptyOptional() {
        Optional<String> empty = Optional.empty();
        assertThat(empty.isPresent()).isFalse();
    }

    @Test
    void create_NonNullable() {
        String name = "kim";
        Optional<String> nameOpt = Optional.of(name);
        assertThat(nameOpt.isPresent()).isTrue();
    }

    @Test
    @DisplayName("of 메서드는 null 값을 입력하면 에러가 발생한다.")
    void create_NonNullable_error() {
        String name = null;
        assertThatThrownBy(() -> Optional.of(name))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("null 값이 필요한 경우 ofNullable() 메서드를 사용한다.")
    void create_nullable() {
        String name = null;
        Optional<String> nameOpt = Optional.ofNullable(name);
        assertThat(nameOpt.isPresent()).isFalse();
    }

    @Test
    @DisplayName("isPresent(), isEmpty() 메서드를 통해 Optional 객체의 값이 존재하는지 알 수 있다.")
    void isPresent_isEmpty() {
        Optional<String> nameNull = Optional.ofNullable(null);
        Optional<String> nameNotNull = Optional.ofNullable("kim");

        assertThat(nameNull.isPresent()).isFalse();
        assertThat(nameNotNull.isPresent()).isTrue();

        assertThat(nameNull.isEmpty()).isTrue();
        assertThat(nameNotNull.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("Optional 객체가 빈 객체일 때 orElse() 메서드를 통해 값을 얻을 수 있다.")
    void orElse() {
        String nameNull = null;
        String name = Optional.ofNullable(nameNull).orElse("kim");
        assertThat(name).isEqualTo("kim");
    }

    @Test
    void orElseGet() {
        String nameNull = null;
        String name = Optional.ofNullable(nameNull).orElseGet(() -> "kim");
        assertThat(name).isEqualTo("kim");
    }

    @Test
    void orElseThrow() {
        String nullName = null;
        assertThatThrownBy(() -> Optional.ofNullable(nullName).orElseThrow())
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void get() {
        Optional<String> nameOpt = Optional.of("kim");
        String name = nameOpt.get();
        assertThat(name).isEqualTo("kim");
    }

    @Test
    void get_예외발생() {
        Optional<String> nameOpt = Optional.ofNullable(null);
        assertThatThrownBy(() -> nameOpt.get())
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void filerWithOptional_true() {
        Optional<String> nameOpt = Optional.of("kim");
        boolean result = nameOpt.filter(name -> name.startsWith("k"))
                .isPresent();
        assertThat(result).isTrue();
    }

    @Test
    void filerWithOptional_false() {
        Optional<String> nameOpt = Optional.of("lee");
        boolean result = nameOpt.filter(name -> name.startsWith("k"))
                .isPresent();
        assertThat(result).isFalse();
    }
}
