package lambda.functional;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.*;

public class ConstructorTest {

    @Test
    void SupplierTest() {
        Supplier<Person> supplier = () -> new Person();
        Person person = supplier.get();
        assertThat(person).isEqualTo(new Person("default", 10));
    }

    @Test
    void FunctionTest() {
        Function<Integer, Person> function = age -> new Person(age);
        Person person = function.apply(40);
        assertThat(person).isEqualTo(new Person("default", 40));
    }

    @Test
    void BiFunctionTest() {
        BiFunction<String, Integer, Person> biFunction = (name, age) -> new Person(name, age);
        Person person = biFunction.apply("kim", 20);
        assertThat(person).isEqualTo(new Person("kim", 20));
    }

    static class Person {
        private static final String DEFAULT_NAME = "default";

        private String name;
        private int age;

        public Person() {
            this.name = DEFAULT_NAME;
            this.age = 10;
        }

        public Person(int age) {
            this.name = DEFAULT_NAME;
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
