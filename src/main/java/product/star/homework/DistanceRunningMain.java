package product.star.homework;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

    public class DistanceRunningMain {

        public static void main(String[] args) throws IOException {
            var applicationContext = new AnnotationConfigApplicationContext(ResultsProcessorConfig.class);

            var resultsReader = applicationContext.getBean(ResultsReader.class);
            var filePath = new ClassPathResource("results.csv").getFile().toPath();
            var results = resultsReader.readFromFile(filePath);

            var resultsProcessor = new ResultsProcessor(results);
            List<Result> fastestMen = resultsProcessor.getFastest(Gender.MALE, Distance.TEN_KM, 3);

            System.out.println(fastestMen);
        }
    }

