import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.TextAPIException;
import com.aylien.textapi.parameters.EntitiesParams;
import com.aylien.textapi.responses.Entities;
import model.UrlsQueue;
import parser.UrlFileHandler;
import urls_fetchers.AylienUrlDataFetcher;
import urls_fetchers.UrlDataFetcher;
import urls_fetchers.UrlDataResponse;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, TextAPIException {
        String pathToFile = "/Users/raz.rogek/dev/mintigo-parser/urls";

        //read from file
        List<String> urls = UrlFileHandler.readUrlsFromFile(pathToFile);

        //populate data to queue
        UrlsQueue queue = new UrlsQueue(urls.size());
        urls.forEach(url -> queue.push(AylienUrlDataFetcher.fromString(url)));

        //multithreaded get data from queue and fetch it.
        while (!queue.isEmpty()){
            UrlDataFetcher pull = queue.pull();
            UrlDataResponse fetch = pull.fetch();



        }
//        queue.pull().fetch();


    }

}


