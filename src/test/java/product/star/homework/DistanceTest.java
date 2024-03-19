package product.star.homework;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DistanceTest {

    @Test
    void testOfValidCode() {
        Distance distance = Distance.of("5 km");
        assertEquals(Distance.FIVE_KM, distance);
    }

    @Test
    void testOfInvalidCode() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Distance.of("15 km");
        });
        assertEquals("Unknown distance: 15 km", exception.getMessage());
    }
}