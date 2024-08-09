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
    public static final String AUTHORITY_STRING = "&ts=1&apikey=25b2c83d1b49f1d2ab163802b4a2cda6&hash=bd3b0817e4b8aee1b1e8f226a56de70b";
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

    //TODO #1 search by character but return comics
    //TODO character ID must be supplied by seperate API call
    public List<ResultComics> searchComicsByCharacter(String character) {
        List<ResultComics> results = new ArrayList<>();
        Root root = null;
        try {
            String path = MARVEL_URL_API + "/characters?nameStartsWith=" + character + AUTHORITY_STRING;
            ResponseEntity<Root> response = restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), Root.class);
            root = response.getBody();

            if ( root != null && root.data.results != null){
                for (ResultComics characterResult : root.data.results){
                    int characterId = characterResult.id;
                    String pathWithId = MARVEL_URL_API + "/characters/" + characterId + "/comics" + AUTHORITY_STRING;
                    ResponseEntity<Root> comicsResponse = restTemplate.exchange(pathWithId, HttpMethod.GET, makeHeaders(), Root.class);
                    Root comicsRoot = comicsResponse.getBody();
                    if (comicsRoot != null){
                        //results.addAll;
                        return null;

                    }
                }
            }

        } catch (RestClientResponseException re) {
            System.out.println(re.getMessage());
        }
        return root.data.results;
    }

//    public int getCharacterIdByName(String characterName) {
//        int characterId = 0;
//        try {
//            String exchangePath = MARVEL_URL_API + "/characters?nameStartsWith=" + characterName + AUTHORITY_STRING;
//            ResponseEntity<String> response = restTemplate.exchange(exchangePath, HttpMethod.GET, makeHeaders(), String.class);
//            String characterJsonString = response.getBody();
//
//            // Extract the character ID from the JSON string using a JSON parser
//            characterId = extractCharacterIdFromJson(characterJsonString);
//        } catch (RestClientResponseException re) {
//            System.out.println(re.getMessage());
//        }
//
//        characterId = Integer.valueOf(("\"id\""));
//
//        return characterId;
//
//
//    }
//    private int extractCharacterIdFromJson(String jsonString) {
//        JSONObject jsonObject = new JSONObject(jsonString);
//        // Assuming the structure returned by the Marvel API
//        return jsonObject.getJSONObject("data")
//                .getJSONArray("results")
//                .getJSONObject(0)
//                .getInt("id");
}
