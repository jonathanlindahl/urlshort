package com.example.urlshort.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.time.LocalDate;

@Entity
public class UrlPairEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String shortUrl;
    private String url;
    private LocalDate createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
    }

    public UrlPairEntity() {}

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

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
