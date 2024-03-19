package product.star.homework;

import java.time.Duration;
import org.springframework.stereotype.Service;
import product.star.homework.Distance;
import product.star.homework.Gender;
import product.star.homework.Person;
import product.star.homework.Result;

@Service
public class ResultParser {

    private static final String SEPARATOR = ",";

    public Result parseResult(String line) {
        var resultParts = line.split(SEPARATOR);

        var name = resultParts[0];
        var gender = Gender.of(resultParts[1]);
        var distance = Distance.of(resultParts[2]);
        var time = parseTime(resultParts[3]);

        var person = new Person(name, gender);
        return new Result(person, distance, time);
    }

    private Duration parseTime(String time) {
        var timeParts = time.split(":");

        var totalSecond = Integer.valueOf(timeParts[0]) * 60 + Integer.valueOf(timeParts[1]);
        return Duration.ofSeconds(totalSecond);
    }
}