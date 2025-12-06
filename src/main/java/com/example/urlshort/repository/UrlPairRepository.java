package com.example.urlshort.repository;

import com.example.urlshort.model.entity.UrlPairEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlPairRepository extends JpaRepository<UrlPairEntity, Long> {
    UrlPairEntity getByShortUrl(String shortUrl);
    void deleteByShortUrl(String shortUrl);
}
