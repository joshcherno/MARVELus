import axios from "axios";

const http = axios.create({
    baseURL: import.meta.env.VITE_REMOTE_API
  });

export default {

    numberOfCollections(){
        return http.get("/collection/collection-total");
    },

    numberOfSavedComics(){
        return http.get("/collection/saved-total")
    },

    numberOfComicsInCollections(){
        return http.get("collection/collection-comics")
    }


}