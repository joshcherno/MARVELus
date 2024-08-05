package com.techelevator.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;

@Service
public class ApiService {

    @Value("${marvel.api.base-url}")
    private String baseUrl;

    @Value("${marvel.api.public-key}")
    private String publicKey;

    @Value("${marvel.api.private-key}")
    private String privateKey;

    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public String getComicById(Long comicId) {
        // Generate timestamp
        String ts = String.valueOf(Instant.now().getEpochSecond());

        // Generate hash
        String hash = DigestUtils.md5Hex(ts + privateKey + publicKey);


        String url = UriComponentsBuilder.fromHttpUrl(baseUrl + "/comics/{id}")
                .queryParam("ts", ts)
                .queryParam("apikey", publicKey)
                .queryParam("hash", hash)
                .buildAndExpand(comicId)
                .toUriString();

        // Make API call
        return restTemplate.getForObject(url, String.class);
    }




}
