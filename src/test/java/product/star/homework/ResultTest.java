package product.star.homework;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import product.star.homework.Distance;
import product.star.homework.Gender;
import product.star.homework.Person;
import product.star.homework.Result;

public class ResultTest {

    @Test
    void testHasGender() {
        Person person = new Person("John", Gender.MALE);
        Distance distance = Distance.FIVE_KM;
        Duration time = Duration.ofMinutes(25);

        Result result = new Result(person, distance, time);

        assertTrue(result.hasGender(Gender.MALE));
        assertFalse(result.hasGender(Gender.FEMALE));
    }

    @Test
    void testHasDistance() {
        Person person = new Person("Alice", Gender.FEMALE);
        Distance distance = Distance.TEN_KM;
        Duration time = Duration.ofMinutes(40);

        Result result = new Result(person, distance, time);

        assertTrue(result.hasDistance(Distance.TEN_KM));
        assertFalse(result.hasDistance(Distance.FIVE_KM));
    }
}