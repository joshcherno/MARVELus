package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao{

    private  final JdbcTemplate jdbcTemplate;

    public  JdbcCollectionDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
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
    public Collection getCollectionByUserId(int userId) {

        Collection collection = null;

        String sql = "SELECT * FROM collection";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if(results.next()){
                collection = mapRowToCollection(results);
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
    public Collection createCollection(Collection newCollection) {

        Collection collection = null;

        String sql = "INSERT INTO collection (collection_name, collection_description, user_id)" +
                "VALUES (?, ?, ?) RETURNING collection_id";

        try{
            int collectId = jdbcTemplate.queryForObject(sql, Integer.class, newCollection.getCollectionName(),
                    newCollection.getColDescription(), newCollection.getUserId());
            collection = getCollectionById(collectId);
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return collection;
    }

    @Override
    public Collection addingComic(Comic comic) {

        String sql = "INSERT INTO collection (collection_name, collection_description, user_id, comic_id)"
                + "VALUES (?,?,?,?) RETURNING collection_id";


        

        return null;
    }

    private  Collection mapRowToCollection(SqlRowSet rs){

        Collection collection = new Collection();

        collection.setCollectionId(rs.getInt("collection_id"));
        collection.setCollectionName(rs.getString("collection_name"));
        collection.setColDescription(rs.getString("col_description"));
        collection.setUserId(rs.getInt("user_id"));

        return collection;

    }
}
