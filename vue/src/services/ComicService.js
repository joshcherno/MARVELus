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

  getComicByIsbn(comicIsbn) {
    return http.get(`/comic/search/isbn/${comicIsbn}`)
  },

  getComicByCharacter(comicCharacter) {
    return http.get(`/character/search/character/${comicCharacter}`)
  },
  
//   TODO: FINISH THIS FUNCTION
//     addComicToLibrary(comic) {
//     return http.post('/comics', comic);
//   },

//   deleteComicFromLibrary(comicId) {
//     return http.delete(`/comics/${comicId}`);
//   }
}