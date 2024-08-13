package com.techelevator.service;

import com.techelevator.dao.ComicDao;
import com.techelevator.model.marvel.MarvelComic;
import com.techelevator.model.marvel.characters.ResultCharacters;
import com.techelevator.model.marvel.comics.ResultComics;
import com.techelevator.model.marvel.comics.Root;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO get this communicating and storing info
//TODO rework the api service to get this working to save data


@Service
@CrossOrigin(origins = "*")
public class ApiService {

    private RestTemplate restTemplate = new RestTemplate();
    public String MARVEL_URL_API = "https://gateway.marvel.com/v1/public";
    public static final String MARVEL_PARAM_APIKEY = "25b2c83d1b49f1d2ab163802b4a2cda6";
    public static final String MARVEL_PARAM_HASH = "bd3b0817e4b8aee1b1e8f226a56de70b";
    //ADDED FIXED LIMIT - RS
    public static final String AUTHORITY_STRING = "&limit=10&ts=1&apikey=25b2c83d1b49f1d2ab163802b4a2cda6&hash=bd3b0817e4b8aee1b1e8f226a56de70b";
    private ComicDao comicDao;


    private HttpEntity<Void> makeHeaders() {
        HttpHeaders headers = new HttpHeaders();
        return new HttpEntity<>(headers);
    }

    public List<ResultComics> searchComicsByTitle(String title) {

        MarvelComic.Result[] results = null;

        Root root = null;

        try {
            String path = MARVEL_URL_API + "/comics?titleStartsWith=" + title + AUTHORITY_STRING;
            ResponseEntity<Root> response = restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), Root.class);

            root = response.getBody();


        } catch (RestClientResponseException re) {
            System.out.println(re.getMessage());
        }

        return root.data.results;

    }

    public List<ResultComics> searchComicsByIsbn(String isbn) {

        MarvelComic.Result[] results = null;
        Root root = null;

        try {
            String path = MARVEL_URL_API + "/comics?isbn=" + isbn + AUTHORITY_STRING;
            ResponseEntity<Root> response = restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), Root.class);
            root = response.getBody();
        } catch (RestClientResponseException re) {
            System.out.println(re.getMessage());
        }
        return root.data.results;

    }

    public List<ResultComics> searchComicsByUPC(String upc) {

        MarvelComic.Result[] results = null;
        Root root = null;

        try {
            String path = MARVEL_URL_API + "/comics?upc=" + upc + AUTHORITY_STRING;
            ResponseEntity<Root> response = restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), Root.class);
            root = response.getBody();
        } catch (RestClientResponseException re) {
            System.out.println(re.getMessage());
        }
        return root.data.results;

    }
    public List<ResultComics> searchComicsByCharacter(String character) {
        List<ResultComics> results = new ArrayList<>();

        Root root = null;
        Root comicsRoot = null;

        try {
            String path = MARVEL_URL_API + "/characters?nameStartsWith=" + character + AUTHORITY_STRING;
            ResponseEntity<Root> response = restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), Root.class);
            root = response.getBody();

            String charIdList = "";

            for( ResultComics charRecord : root.data.results){

                charIdList += charRecord.id + ",";

            }

            if(charIdList.endsWith(",")){
                charIdList = charIdList.substring(0, charIdList.length()-1);
            }

            String pathWithId = MARVEL_URL_API + "/comics?characters=" + charIdList + AUTHORITY_STRING;
            ResponseEntity<Root> comicsResponse = restTemplate.exchange(pathWithId, HttpMethod.GET, makeHeaders(), Root.class);
            comicsRoot = comicsResponse.getBody();

        } catch (RestClientResponseException re) {
            System.out.println(re.getMessage());
        }
        return comicsRoot.data.results;
    }
    public List<ResultComics> getRecentReleases(){
        MarvelComic.Result[] results = null;
        Root root = null;

        try {
            String path = MARVEL_URL_API + "/comics?dateDescriptor=nextWeek&" + "&limit=3&ts=1&apikey=25b2c83d1b49f1d2ab163802b4a2cda6&hash=bd3b0817e4b8aee1b1e8f226a56de70b";
            ResponseEntity<Root> response = restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), Root.class);
            root = response.getBody();
        } catch (RestClientResponseException re) {
            System.out.println(re.getMessage());
        }
        return root.data.results;
    }
}
