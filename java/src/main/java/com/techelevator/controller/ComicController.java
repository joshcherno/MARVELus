package com.techelevator.controller;

import com.techelevator.dao.ComicDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ComicController {

    private ComicDao comicDao;


    public ComicController(ComicDao comicDao){
        this.comicDao = comicDao;
    }




}
