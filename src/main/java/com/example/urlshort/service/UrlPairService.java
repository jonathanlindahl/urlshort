package com.example.urlshort.service;

import com.example.urlshort.model.dto.UrlPairDto;
import com.example.urlshort.model.entity.UrlPairEntity;
import com.example.urlshort.repository.UrlPairRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlPairService {
    private final UrlPairRepository urlPairRepository;

    public UrlPairService(UrlPairRepository urlPairRepository) {
        this.urlPairRepository = urlPairRepository;
    }

    public Optional<UrlPairDto> getUrlPair(String shortUrl) {
        return Optional.of(toDto(urlPairRepository.getByShortUrl(shortUrl)));
    }

    public void saveUrlPair(UrlPairDto dto) {
        urlPairRepository.save(toEntity(dto));
    }

    private UrlPairEntity toEntity(UrlPairDto dto) {
        return new UrlPairEntity(dto.getShortUrl(), dto.getUrl());
    }

    private UrlPairDto toDto(UrlPairEntity entity) {
        return new UrlPairDto(entity.getShortUrl(), entity.getUrl());
    }
}
