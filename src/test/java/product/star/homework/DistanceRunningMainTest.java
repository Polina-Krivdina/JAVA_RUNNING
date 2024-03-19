package product.star.homework;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DistanceRunningMainTest {

    @Test
    void testMain() throws IOException {
        List<Result> testData = new ArrayList<>();

        File tempFile = File.createTempFile("test", ".csv");
        Path tempFilePath = tempFile.toPath();

        ResultsReader resultsReader = new ResultsReader();

        List<Result> resultsFromFile = resultsReader.readFromFile(tempFilePath);
        assertEquals(testData.size(), resultsFromFile.size());

        ResultsProcessor resultsProcessor = new ResultsProcessor(testData);

        List<Result> processedResults = resultsProcessor.getFastest(Gender.MALE, Distance.TEN_KM, 3);

        assertTrue(processedResults.size() > 0);

        tempFile.delete();
    }
}