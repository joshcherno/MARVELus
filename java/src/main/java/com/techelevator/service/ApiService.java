package com.techelevator.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.time.Instant;


// @Service
public class ApiService {

//    @Value("${marvel.api.base-url}")
//    private String baseUrl;
//
//    @Value("${marvel.api.public-key}")
//    private String publicKey;
//
//    @Value("${marvel.api.private-key}")
//    private String privateKey;
//
//    private final RestTemplate restTemplate;
//
//    public ApiService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//    public String getComicById(Long comicId) {
//        // Generate timestamp
//        String ts = String.valueOf(Instant.now().getEpochSecond());
//
//        // Generate hash
//        String hash = DigestUtils.md5Hex(ts + privateKey + publicKey);
//
//
//        String url = UriComponentsBuilder.fromHttpUrl(baseUrl + "/comics/{id}")
//                .queryParam("ts", ts)
//                .queryParam("apikey", publicKey)
//                .queryParam("hash", hash)
//                .buildAndExpand(comicId)
//                .toUriString();
//
//        // Make API call
//        return restTemplate.getForObject(url, String.class);
//    }
//    public String getComics(){
//        String ts = String.valueOf(Instant.now().getEpochSecond());
//        String hash = DigestUtils.md5Hex(ts + privateKey + publicKey);
//        String url = UriComponentsBuilder.fromHttpUrl(baseUrl + "/comics/{id}")
//                .queryParam("ts", ts)
//                .queryParam("apikey", publicKey)
//                .queryParam("hash", hash)
//                .toUriString();
//        return restTemplate.getForObject(url, String.class);
//    }

    public static final String MARVEL_URL_API = "https://gateway.marvel.com/v1/public";
    public static final String MARVEL_URI_COMICS = "/comics";
    public static final String MARVEL_URI_CHARACTERS = "/characters";
    public static final String MARVEL_URI_CREATORS = "/creators";
    public static final String MARVEL_URI_EVENTS = "/events";
    public static final String MARVEL_URI_SERIES = "/series";
    public static final String MARVEL_PARAM_TIMESTAMP = "1";
    public static final String MARVEL_PARAM_APIKEY = "25b2c83d1b49f1d2ab163802b4a2cda6";
    public static final String MARVEL_PARAM_HASH = "bd3b0817e4b8aee1b1e8f226a56de70b";
    public static final String MARVEL_PARAM_LIMIT = "limit";

    public ApiService(){

    }




}
