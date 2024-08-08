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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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



    private HttpEntity<Void> makeHeaders(){
        HttpHeaders headers = new HttpHeaders();
        return new HttpEntity<>(headers);
    }
    //TODO make sure we can delete this
//    public Comic getComicById(int id){
//        String listComicJsonString = null;
//        Comic comic = null;
//        try {
//            String path = MARVEL_URL_API + "/comics" + id + AUTHORITY_STRING;
//            ResponseEntity<String> response = restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), String.class);
//            comic = restTemplate.getForObject(path, Comic.class);
//            listComicJsonString = response.getBody();
//        } catch (RestClientResponseException re){
//            System.out.println(re.getMessage());
//        }
//        return comic;
//        //TODO make a method to convert to json comicJsonString()
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

    public List<Result> searchComicsByIsbn(int isbn){

        MarvelComic.Result[] results = null;
        Root root = null;

        try {
            String path = MARVEL_URL_API + "/comics?isbn=" + isbn + AUTHORITY_STRING;
            ResponseEntity<Root> response = restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), Root.class);
            root = response.getBody();
        } catch (RestClientResponseException re){
            System.out.println(re.getMessage());
        }
        return root.data.results;

    }

    //TODO search by character. need to go over what the return is and see if we need to make
    //another model folder to go with the comic folder

    public List<Result> searchComicsByCharacter(String character){
        MarvelComic.Result[] results = null;
        Root root = null;
        try{
            String path = MARVEL_URL_API + "/characters?nameStartsWith=" + character + AUTHORITY_STRING;
            ResponseEntity<Root> response = restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), Root.class);
            root = response.getBody();

        } catch (RestClientResponseException re){
            System.out.println(re.getMessage());
        }
        return root.data.results;
    }


}
