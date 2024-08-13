import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API
});

export default {

  getComics() {
    return http.get('/comics');
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



//   deleteComicFromLibrary(comicId) {
//     return http.delete(`/comics/${comicId}`);
//   }
}