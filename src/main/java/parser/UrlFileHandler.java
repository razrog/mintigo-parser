package parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UrlFileHandler {

    public static List<String> readUrlsFromFile(String pathToFile) throws IOException {

        List<String> urlsStrings = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get(pathToFile));
        stream.forEach(urlsStrings::add);

        return urlsStrings;
    }
}
