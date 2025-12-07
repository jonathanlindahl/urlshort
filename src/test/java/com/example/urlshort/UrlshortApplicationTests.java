package com.example.urlshort;

import com.example.urlshort.model.dto.UrlPairDto;
import com.example.urlshort.model.entity.UrlPairEntity;
import com.example.urlshort.repository.UrlPairRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatusCode;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UrlshortApplicationTests {
    @LocalServerPort
    private int port;

    @MockBean
    private UrlPairRepository urlPairRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

	@Test
	void testSaveNullOrEmpty() {
        Mockito.when(urlPairRepository.save(Mockito.any())).thenReturn(new UrlPairEntity());

        String url = "http://localhost:" + port + "/save";

        Assertions.assertEquals(
            HttpStatusCode.valueOf(400),
            this.testRestTemplate.postForEntity(
                url, new HttpEntity<>(new UrlPairDto("short", null)), UrlPairDto.class
            ).getStatusCode()
        );
        Assertions.assertEquals(
            HttpStatusCode.valueOf(400),
            this.testRestTemplate.postForEntity(
                url, new HttpEntity<>(new UrlPairDto(null, "example.com")), UrlPairDto.class
            ).getStatusCode()
        );
        Assertions.assertEquals(
            HttpStatusCode.valueOf(400),
            this.testRestTemplate.postForEntity(
                url, new HttpEntity<>(new UrlPairDto(null, null)), UrlPairDto.class
            ).getStatusCode()
        );
        Assertions.assertEquals(
            HttpStatusCode.valueOf(400),
            this.testRestTemplate.postForEntity(
                url, new HttpEntity<>(new UrlPairDto("", "")), UrlPairDto.class
            ).getStatusCode()
        );
    }
}
