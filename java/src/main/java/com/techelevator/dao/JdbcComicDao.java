package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Comic;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcComicDao implements ComicDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcComicDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //TODO set up comic table in pgadmin
    @Override
    public Comic getComicById(String comicId) {

        Comic comic = null;

        String sql = "SELECT * FROM comic";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, comicId);
            if(results.next()){
                comic = mapRowToComic(results);
            }
        }catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }

        return comic;
    }



    @Override
    public Comic getComicByTitle(String title) {

        Comic comic = null;

        String sql = "SELECT * FROM comic";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title);
            if(results.next()){
                comic = mapRowToComic(results);
            }
        }catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }

        return comic;
    }

    @Override
    public Comic getComicByAuthor(String author) {

        Comic comic = null;

        String sql = "SELECT * FROM comic";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, author);
            if(results.next()){
                comic = mapRowToComic(results);
            }
        }catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }

        return comic;
    }

    @Override
    public List<Comic> getComics() {

        List<Comic> comicList = new ArrayList<>();

        String sql = "SELECT * FROM comic";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()){
                Comic comicResult = mapRowToComic(results);
                comicList.add(comicResult);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return comicList;
    }

    @Override
    public Comic saveComic(Comic comic) {

        Comic comics = null;

        String sql = "INSERT INTO comic (title, author, description, release_date, cover_art) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING comic_id";

        try{
           String comicId = jdbcTemplate.queryForObject(sql, String.class, comic.getTitle(), comic.getAuthor(),
                   comic.getDescription(), comic.getReleaseDate(), comic.getCoverArt());
           comics = getComicById(comicId);
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return comics;
    }

    private Comic mapRowToComic(SqlRowSet rs) {

        Comic comic = new Comic();
        comic.setComicId(rs.getString("comic_id"));
        comic.setTitle(rs.getString("title"));
        comic.setAuthor(rs.getString("author"));
        comic.setDescription(rs.getString("description"));
        if(rs.getDate("release_date") != null){
            comic.setReleaseDate(rs.getDate("release_date").toLocalDate());
        }
        comic.setCoverArt(rs.getString("cover_art"));

        return comic;
    }
}
