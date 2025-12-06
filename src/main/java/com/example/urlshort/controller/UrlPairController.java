package com.example.urlshort.controller;

import com.example.urlshort.model.dto.UrlPairDto;
import com.example.urlshort.service.UrlPairService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UrlPairController {
    private final UrlPairService urlPairService;

    public UrlPairController(UrlPairService urlPairService) {
        this.urlPairService = urlPairService;
    }

    @GetMapping("/fetch/{shortUrl}")
    public ResponseEntity<UrlPairDto> getPair(@PathVariable String shortUrl) {
        return ResponseEntity.of(urlPairService.getUrlPair(shortUrl));
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirect(@PathVariable String shortUrl) {
        String url = urlPairService.getUrlPair(shortUrl).orElseThrow().getUrl();

        return ResponseEntity
            .status(HttpStatus.FOUND)
            .location(URI.create(url))
            .build();
    }

    @PostMapping("/save")
    public ResponseEntity<String> savePair(@RequestBody UrlPairDto dto) {
        urlPairService.saveUrlPair(dto);
        return ResponseEntity.ok("");
    }
}
