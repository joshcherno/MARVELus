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
  
  //Does this jawn work?  I don't know.  I'm just trying to get the collections to show up in the console.

  addComicToCollection(comic, collectionId) {
    return http.post(`/collections/${collectionId}`, comic);
  },

  updateComic(comic) {
    return http.put(`/comics/${comic.id}`, comic);
  },

  deleteComicFromCollection(comicId) {
    return http.delete(`/comics/${comicId}`);
  },
  
  addCollection(collection) {
    return http.post('/collection/create-collection', collection);
  },
  deleteCollection(collectionId) {
    return http.delete(`/collections/${collectionId}`);
  }

}