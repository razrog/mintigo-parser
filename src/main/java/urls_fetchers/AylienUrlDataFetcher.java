package urls_fetchers;

import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.TextAPIException;
import com.aylien.textapi.parameters.EntitiesParams;
import com.aylien.textapi.responses.Entities;

import java.net.MalformedURLException;
import java.net.URL;

public class AylienUrlDataFetcher implements UrlDataFetcher {


    private String url;

    //TODO - in spring inject
    private TextAPIClient aylienClient = new TextAPIClient("8ce26d46", "4aaf516798c766ad14c22c6215719274");

    private AylienUrlDataFetcher(String url) {
        this.url = url;
    }

    public static AylienUrlDataFetcher fromString(String url) {
        //TODO - Validate url is valid??
        return new AylienUrlDataFetcher(url);
    }


    public String getUrl() {
        return url;
    }


    @Override
    public UrlDataResponse fetch() throws TextAPIException, MalformedURLException {

        EntitiesParams.Builder builder = EntitiesParams.newBuilder();
        builder.setUrl(new URL(this.url));

        //TODO - Error handling...
        Entities entities = aylienClient.entities(builder.build());

        entities.getEntities().forEach(entity -> {
            if (entity.getType().equals("keyword")) {
                entity.getSurfaceForms().forEach(System.out::println);
            }
        });

        return new UrlDataResponse();

    }


    @Override
    public String toString() {
        return "AylienUrlDataFetcher{" +
                "url='" + url + '\'' +
                '}';
    }
}
