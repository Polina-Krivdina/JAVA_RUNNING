package product.star.homework;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

import product.star.homework.Distance;
import product.star.homework.Gender;
import product.star.homework.Person;
import product.star.homework.Result;

public class ResultsProcessorTest {

    @Test
    void testGetFastest() {
        // Создаем коллекцию результато
        Collection<Result> results = new ArrayList<>();
        results.add(new Result(new Person("John", Gender.MALE), Distance.FIVE_KM,25:45));
        results.add(new Result(new Person("Alice", Gender.FEMALE), Distance.TEN_KM,23:45));
        results.add(new Result(new Person("Bob", Gender.MALE), Distance.FIVE_KM, 20:30));
        results.add(new Result(new Person("Carol", Gender.FEMALE), Distance.FIVE_KM, 24:46));

        // Создаем экземпляр ResultsProcessor
        ResultsProcessor resultsProcessor = new ResultsProcessor(results);

        // Получаем список самых быстрых мужчин на дистанции 5 км
        List<Result> fastestMen = resultsProcessor.getFastest(Gender.MALE, Distance.FIVE_KM, 2);

        // Проверяем, что результаты обработаны корректно
        assertEquals(2, fastestMen.size());
        assertEquals("Bob", fastestMen.get(0).person().name());
        assertEquals("John", fastestMen.get(1).person().name());
    }
}