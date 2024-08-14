import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API
});

export default {

  getComics() {
    return http.get('/comics');
  },

  getUpcomingComic() {
    return http.get('/comic/search/upcoming-releases');
  },

  getComicByTitle(comicTitle) {
    return http.get(`/comic/search/title/${comicTitle}`)
  },

  getComicByUPC(comicUPC) {
    return http.get(`/comic/search/upc/${comicUPC}`)
  },

  getComicByCharacter(comicCharacter) {
    return http.get(`/comic/search/character/${comicCharacter}`)
  },
  
  addComicToLibrary(collectionId, comic) {
    return http.post(`/collection/${collectionId}/add`, comic);
   },

  deleteComicFromCollection(collectionId, comicId) {
     return axios.delete(`/collection/${collectionId}/comic/${comicId}`);
   },




}