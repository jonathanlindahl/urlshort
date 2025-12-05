package com.example.urlshort.model;

import java.net.URL;

public class UrlPair {
    private final String shortUrl;
    private final URL url;

    public UrlPair(String shortUrl, URL url) {
        this.shortUrl = shortUrl;
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public URL getUrl() {
        return url;
    }
}
