package com.example.urlshort.model.dto;

import java.io.Serializable;

public class UrlPairDto implements Serializable {
    private final String shortUrl;
    private final String url;

    public UrlPairDto(String shortUrl, String url) {
        this.shortUrl = shortUrl;
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getUrl() {
        return url;
    }
}
