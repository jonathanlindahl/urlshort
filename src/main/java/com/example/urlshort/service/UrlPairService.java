package com.example.urlshort.service;

import com.example.urlshort.model.dto.UrlPairDto;
import com.example.urlshort.model.entity.UrlPairEntity;
import com.example.urlshort.repository.UrlPairRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UrlPairService {
    private final UrlPairRepository urlPairRepository;

    public UrlPairService(UrlPairRepository urlPairRepository) {
        this.urlPairRepository = urlPairRepository;
    }

    @Cacheable(value = "url", key = "#shortUrl")
    public Optional<UrlPairDto> getUrlPair(String shortUrl) {
        System.out.printf("Fetching %s from DB...", shortUrl);
        return Optional.of(toDto(urlPairRepository.getByShortUrl(shortUrl)));
    }

    public void saveUrlPair(UrlPairDto dto) {
        urlPairRepository.save(toEntity(dto));
    }

    @CacheEvict(value = "urlPair", key = "#shortUrl")
    public void deleteByShortUrl(String shortUrl) {
        urlPairRepository.deleteByShortUrl(shortUrl);
    }

    private UrlPairEntity toEntity(UrlPairDto dto) {
        if (dto == null || ObjectUtils.isEmpty(dto.getShortUrl()) || ObjectUtils.isEmpty(dto.getUrl()))
            throw new NoSuchElementException();
        return new UrlPairEntity(dto.getShortUrl(), dto.getUrl());
    }

    private UrlPairDto toDto(UrlPairEntity entity) {
        return new UrlPairDto(entity.getShortUrl(), entity.getUrl());
    }
}
