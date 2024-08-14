package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import com.techelevator.model.marvel.MarvelComic;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCollectionDao implements CollectionDao{

    private  final JdbcTemplate jdbcTemplate;

    private final UserDao userdao;

    public  JdbcCollectionDao(JdbcTemplate jdbcTemplate, UserDao userdao){
        this.jdbcTemplate = jdbcTemplate;
        this.userdao = userdao;
    }


    @Override
    public Collection getCollectionById(int collectionId) {
        Collection collection = null;

        String sql = "SELECT * FROM collection WHERE collection_id = ?;";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionId);
            if(results.next()){
                collection = mapRowToCollection(results);
            }
        }catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }

        return collection;
    }

    @Override
    public List <Collection> getCollectionsByUserId(int userId) {

        List <Collection> collection = new ArrayList<>();

        String sql = "SELECT * FROM collection WHERE user_id = ?";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while(results.next()){
                collection.add(mapRowToCollection(results));
            }
        }catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }

        return collection;


    }

    @Override
    public Collection getCollectionByName(String collectionName) {

        Collection collection = null;

        String sql = "SELECT * FROM collection WHERE collection_name = ?;";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionName);
            if(results.next()){
                collection = mapRowToCollection(results);
            }
        }catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }

        return collection;
    }

    @Override
    public List<Collection> getCollections() {

        List<Collection> listCollection = new ArrayList<>();

        String sql = "SELECT * FROM collection";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()){
                Collection collectionResult = mapRowToCollection(results);
                listCollection.add(collectionResult);
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return listCollection;
    }


    @Override
    public Collection createCollection(Collection newCollection, Principal principal) {

        Collection collection;

        int userid = userdao.getUserByUsername(principal.getName()).getId();

        String sql = "INSERT INTO collection (collection_name, collection_description, user_id)" +
                "VALUES (?, ?, ?) RETURNING collection_id";
        System.out.println("COLLECTION NAME HERE: " + newCollection.getCollectionName());
        try{
            int collectId = jdbcTemplate.queryForObject(sql, Integer.class, newCollection.getCollectionName(),
                    newCollection.getColDescription(), userid);
            collection = getCollectionById(collectId);
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return collection;
    }


    @Override
    public Collection addComicToCollection(int collectionId, int comicId) {

        String sql = "INSERT INTO collection_comics (collection_id, comic_id) VALUES (?,?)";

        try{
            jdbcTemplate.update(sql, collectionId, comicId);
            return getCollectionById(collectionId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

    }

    @Override
    public List<Comic> getComicsByCollectionId(int collectionId) {
        List<Comic> comics = new ArrayList<>();

        String sql = "SELECT c.* FROM comic c " +
                "JOIN collection_comics cc ON c.comic_id = cc.comic_id " +
                "WHERE cc.collection_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionId);
            while (results.next()) {
                comics.add(mapRowToComic(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return comics;
    }


    @Override
    public int totalNumberOfCollections() {
        String sql = "SELECT COUNT(*) FROM collection";
        int count = 0;
        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return count;
    }

    @Override
    public int numberOfSavedComics() {
        String sql = "SELECT COUNT(*) FROM comic";
        int count = 0;
        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return count;
    }

    @Override
    public int numberOfComicsInCollections() {
        String sql = "SELECT COUNT(*) FROM collection_comics";
        int count = 0;
        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return count;
    }


    //added by Dylan
//    @Override
//    public Collection deleteComicFromCollection(int collectionId, int comicId){
//        Collection collection = getCollectionById(collectionId);
//        List <Comic> comic = getComicsByCollectionId(comicId);
////        String sql = "DELETE FROM collection_comics WHERE collection_id = ? AND comic_id = ?";
//
//
//    return ;
//
//    }

    /*   it wants me to implement the next two methods (when the one above is commented out)
            from the CollectionDao so i did below but how is it
            different from whats right above this? and why does it
            satisfy intellij if it doesn't have the parameters in the Dao???? ROb????*/
    @Override
    public Collection deleteComicFromCollection() {
        return null;
    }

    @Override
    public Collection deleteComicFromCollection(int collectionId, int comicId) {
        return null;
    }


    private  Collection mapRowToCollection(SqlRowSet rs){

        Collection collection = new Collection();

        collection.setCollectionId(rs.getInt("collection_id"));
        collection.setCollectionName(rs.getString("collection_name"));
        collection.setColDescription(rs.getString("collection_description"));
        collection.setUserId(rs.getInt("user_id"));

        return collection;

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
