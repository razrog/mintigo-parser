package urls_fetchers;

import com.aylien.textapi.TextAPIException;

import java.net.MalformedURLException;

public interface UrlDataFetcher {

    UrlDataResponse fetch() throws TextAPIException, MalformedURLException;

}
