package com.techelevator.dao;

import com.techelevator.model.Comic;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcComicDao implements ComicDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcComicDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //TODO set up comic table in pgadmin
    @Override
    public Comic getComicById(String comicId) {
        return null;
    }

    @Override
    public Comic getComicByTitle(String title) {
        return null;
    }

    @Override
    public Comic getComicByAuthor(String author) {
        return null;
    }

    @Override
    public List<Comic> getComics() {
        return null;
    }

    @Override
    public Comic saveComic(Comic comic) {
        return null;
    }
}
