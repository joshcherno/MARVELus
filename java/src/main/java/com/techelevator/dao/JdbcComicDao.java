package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcComicDao implements ComicDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcComicDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //TODO try to get rid of this method safely. its useless right now
    @Override
    public Comic getAllComics() {
        Comic comic = null;

        String sql = "SELECT * FROM comic";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            if(results.next()){
                comic = mapRowToComic(results);
            }
        }catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }

        return comic;
    }
    @Override
    public Comic getComicById(int comicId) {

        Comic comic = null;

        String sql = "SELECT * FROM comic WHERE comic_id = ?";

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
    public List<Comic> getComicByTitle(String title) {

        List<Comic> comicList = new ArrayList<>();

        String sql = "SELECT * FROM comic WHERE comic_title LIKE ?";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title + "%");
            while(results.next()){
                Comic comicResult = mapRowToComic(results);
                comicList.add(comicResult);
            }
        }catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }

        return comicList;
    }

    @Override
    public Comic getComicByAuthor(String author) {

        Comic comic = null;

        String sql = "SELECT * FROM comic WHERE comic_author = ?";

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

        String sql = "INSERT INTO comic (comic_id, comic_title, comic_author, description, release_date, cover_url) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try{
           String comicId = jdbcTemplate.queryForObject(sql, String.class, comic.getComicId(), comic.getTitle(), comic.getAuthor(),
                   comic.getDescription(), comic.getReleaseDate(), comic.getCoverArt());
           comics = getComicById(comic.getComicId());
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return comics;
    }

    @Override
    public List<Comic> getComicsFromCollection(int collectionId) {
        List<Comic> comicList = new ArrayList<>();
        String sql = "SELECT c.* FROM comic c JOIN collection_comics cc ON c.comic_id = cc.comic_id WHERE cc.collection_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionId);
            while (results.next()) {
                Comic comic = mapRowToComic(results);
                comicList.add(comic);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return comicList;

    }



    private Comic mapRowToComic(SqlRowSet rs) {

        Comic comic = new Comic();
        comic.setComicId(rs.getInt("comic_id"));
        comic.setTitle(rs.getString("comic_title"));
        comic.setAuthor(rs.getString("comic_author"));
        comic.setDescription(rs.getString("description"));
        if(rs.getDate("release_date") != null){
            comic.setReleaseDate(rs.getDate("release_date").toLocalDate());
        }
        comic.setCoverArt(rs.getString("cover_url"));

        return comic;
    }
}
