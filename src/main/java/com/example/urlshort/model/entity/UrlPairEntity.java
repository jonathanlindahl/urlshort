package com.example.urlshort.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UrlPairEntity {
    @Id
    @GeneratedValue
    private Long id;
    private final String shortUrl;
    private final String url;

    public UrlPairEntity(String shortUrl, String url) {
        this.shortUrl = shortUrl;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getUrl() {
        return url;
    }
}
