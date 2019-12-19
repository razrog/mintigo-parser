package model;

import urls_fetchers.UrlDataFetcher;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class UrlsQueue {

    private Queue<UrlDataFetcher> urlsQueue;

    public UrlsQueue(int size) {
        urlsQueue = new LinkedBlockingDeque<>(size);
    }

    public UrlDataFetcher pull() {
        if (urlsQueue.isEmpty()) {
            return null;
        }
        return urlsQueue.poll();
    }

    public void push(UrlDataFetcher urlDataFetcher) {
        urlsQueue.add(urlDataFetcher);
    }

    public boolean isEmpty() {
        return urlsQueue.isEmpty();
    }

}
