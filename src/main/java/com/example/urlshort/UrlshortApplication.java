package com.example.urlshort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class UrlshortApplication {
	public static void main(String[] args) {
		SpringApplication.run(UrlshortApplication.class, args);
	}
}
