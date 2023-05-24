package lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class PersonTest {

    private List<Person> people;

    @BeforeEach
    void setUp() {
        people = Arrays.asList(
                new Person("Kim", 12, Gender.FEMALE),
                new Person("Park", 30, Gender.MALE),
                new Person("Jo", 26, Gender.MALE),
                new Person("Lee", 32, Gender.FEMALE),
                new Person("Hong", 180, Gender.MALE),
                new Person("An", 22, Gender.FEMALE)
        );
    }

    @Test
    void 남자_리스트_구하기() {
        List<Person> males = people.stream()
                .filter(person -> person.isMale())
                .collect(Collectors.toList());

        List<String> malesName = males.stream()
                .map(person -> person.getName())
                .collect(Collectors.toList());

        assertThat(malesName).containsExactly("Park", "Jo", "Hong");
    }

    @Test
    void 여자_리스트_이름을_구한후_소문자로_변환() {
        List<String> femalesName = people.stream()
                .filter(Person::isFemale)
                .map(Person::getName)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        assertThat(femalesName).containsExactly("kim", "lee", "an");
    }

    @Test
    void 나이순으로_정렬후_출력() {
        people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .forEach(System.out::println);
    }
}