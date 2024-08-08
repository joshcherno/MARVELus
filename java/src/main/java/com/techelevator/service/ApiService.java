package com.techelevator.service;

import com.techelevator.model.Comic;
import com.techelevator.model.marvel.MarvelComic;
import com.techelevator.model.marvel.comics.Result;
import com.techelevator.model.marvel.comics.Root;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//TODO get this communicating and storing info
//TODO rework the api service to get this working to save data


@Service
public class ApiService {

    private RestTemplate restTemplate = new RestTemplate();
    public String MARVEL_URL_API = "https://gateway.marvel.com/v1/public";
    public static final String MARVEL_URI_COMICS = "/comics";
    public static final String MARVEL_URI_CHARACTERS = "/characters";
    public static final String MARVEL_URI_CREATORS = "/creators";
    public static final String MARVEL_URI_EVENTS = "/events";
    public static final String MARVEL_URI_SERIES = "/series";
    public static final String MARVEL_PARAM_APIKEY = "25b2c83d1b49f1d2ab163802b4a2cda6";
    public static final String MARVEL_PARAM_HASH = "bd3b0817e4b8aee1b1e8f226a56de70b";
    public static final String MARVEL_PARAM_LIMIT = "limit";
    public static final String AUTHORITY_STRING = "&ts=1&apikey=25b2c83d1b49f1d2ab163802b4a2cda6&hash=bd3b0817e4b8aee1b1e8f226a56de70b";



    private HttpEntity<Void> makeHeaders(){
        HttpHeaders headers = new HttpHeaders();
        return new HttpEntity<>(headers);
    }

    public List<Comic> getComicByCharacter(String characterName){
        List<Comic> listComics = new ArrayList<>();
       //int
        return null;
    }
    public Comic getComicById(int id){
        String listComicJsonString = null;
        Comic comic = null;
        try {
            String path = MARVEL_URL_API + "/comics" + id + AUTHORITY_STRING;
            ResponseEntity<String> response = restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), String.class);
            comic = restTemplate.getForObject(path, Comic.class);
            listComicJsonString = response.getBody();
        } catch (RestClientResponseException re){
            System.out.println(re.getMessage());
        }
        return comic;
        //TODO make a method to convert to json comicJsonString()
    }
//    public Comic getComicByCreater(String author){
//        Comic comic = null;
//        try{
//            String path =
//    }


    public List<Result> searchComicsByTitle(String title){

        MarvelComic.Result[] results = null;

        Root root = null;

        try {
            String path = MARVEL_URL_API + "/comics?titleStartsWith=" + title + AUTHORITY_STRING;
            ResponseEntity<Root> response = restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), Root.class);

            root = response.getBody();


        } catch (RestClientResponseException re){
            System.out.println(re.getMessage());
        }

        return root.data.results;

    }


}
