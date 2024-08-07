import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API
});

export default {

  getCollections() {
    return http.get('/collections');
  },

  getCollectionById(collectionId) {
    return http.get(`/collections/${collectionId}`)
  },

  getComicById(comicId) {
    return http.get(`/collections/${comicId}`)
  },
  
  addComicToCollection(comic) {
    return http.post('/comics', comic);
  },

  updateComic(comic) {
    return http.put(`/comics/${comic.id}`, comic);
  },

  deleteComicFromCollection(comicId) {
    return http.delete(`/comics/${comicId}`);
  },
  
  addCollection(collection) {
    return http.post('/collections', collection);
  },
  deleteCollection(collectionId) {
    return http.delete(`/collections/${collectionId}`);
  }

}