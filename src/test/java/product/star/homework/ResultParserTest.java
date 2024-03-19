package product.star.homework;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import product.star.homework.Distance;
import product.star.homework.Gender;
import product.star.homework.Person;
import product.star.homework.Result;

public class ResultParserTest {

    @Test
    void testParseResult() {
        ResultParser resultParser = new ResultParser();
        Result result = resultParser.parseResult("John,M,5 km,25:30");

        Person expectedPerson = new Person("John", Gender.MALE);
        Distance expectedDistance = Distance.FIVE_KM;
        Duration expectedTime = Duration.ofMinutes(25).plusSeconds(30);

        assertEquals(expectedPerson, result.person());
        assertEquals(expectedDistance, result.distance());
        assertEquals(expectedTime, result.time());
    }

    @Test
    void testParseTime() {
        ResultParser resultParser = new ResultParser();
        Duration duration = resultParser.parseTime("25:30");

        Duration expectedDuration = Duration.ofMinutes(25).plusSeconds(30);
        assertEquals(expectedDuration, duration);
    }
}