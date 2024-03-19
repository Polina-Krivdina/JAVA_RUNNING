package product.star.homework;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GenderTest {

    @Test
    void testOfMaleCode() {
        Gender male = Gender.of("M");
        assertEquals(Gender.MALE, male);
    }

    @Test
    void testOfFemaleCode() {
        Gender female = Gender.of("F");
        assertEquals(Gender.FEMALE, female);
    }

    @Test
    void testOfInvalidCode() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Gender.of("X");
        });
        assertEquals("Unknown gender: X", exception.getMessage());
    }
}