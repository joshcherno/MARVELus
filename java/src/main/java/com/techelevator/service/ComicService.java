package com.techelevator.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.dao.ComicDao;
import com.techelevator.model.Comic;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TODO GET THIS WORKING TOO. NEEDS TO SAVE TO POSTGRES TABLE
@Service
public class ComicService {
    private final ComicDao comicDao;
    private final Comic comic;
    private final ApiService apiService;
    private final ObjectMapper objectMapper;

    public ComicService(ComicDao comicDao, Comic comic, ApiService apiService, ObjectMapper objectMapper) {
        this.comicDao = comicDao;
        this.comic = comic;
        this.apiService = apiService;
        this.objectMapper = objectMapper;
    }
    public Comic getComicById(String comicId){
        return comicDao.getComicById(comicId);
    }
    public List<Comic> getComics(){
        return comicDao.getComics();
    }
    public Comic saveComic(Comic comic){
        return comicDao.saveComic(comic);
    }
    //TODO rework the api service to get this working
   /* public List<Comic> getAndSaveMarvelStuff() throws IOException {
        String comicData = apiService.getComics();
        JsonNode rootNode = objectMapper.readTree(comicData);
        JsonNode resultsNode = rootNode.path("data").path("results");

        List<Comic> comics = new ArrayList<>();
        for (JsonNode node : resultsNode){
            Comic comic = new Comic();
            comic.setTitle(node.path("title").asText());
            comic.setDescription(node.path("description").asText("No description available"));
            JsonNode thumbnail = node.path("thumbnail");
            comic.setCoverArt(thumbnail.path("path").asText() + "." + thumbnail.path("extension").asText());
            comics.add(comic);
        }
        return comics;


    }*/
}
