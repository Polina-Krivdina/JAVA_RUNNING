package product.star.homework;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import product.star.homework.Result;
import product.star.homework.ResultsReader;
import product.star.homework.ResultsProcessor;
import product.star.homework.ResultParser;

public class ResultsReaderTest {

    private ResultsReader resultsReader;

    @BeforeEach
    void setUp() {
        ResultParser resultParser = new ResultParser();

        resultsReader = new ResultsReader(resultParser);
    }

    @Test
    void testReadFromFile() {
        Path filePath = Path.of("src/test/resources/test_results.csv");

        List<Result> results = resultsReader.readFromFile(filePath);

        assertFalse(results.isEmpty());

    }
}