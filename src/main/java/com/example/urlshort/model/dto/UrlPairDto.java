package com.example.urlshort.model.dto;

public class UrlPairDto {
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
