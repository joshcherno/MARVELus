import axios from 'axios';

axios.interceptors.request.use(
  config => {
    const token = localStorage.getItem('token');
    console.log(`Token being used in request: ${token}`); // Log the token
    if (token) {
      config.headers['Authorization'] = `Bearer ${token}`;
    }
    return config;
  },
  error => {
    return Promise.reject(error);
  }
);


//delete this later before final delivery
// const http = axios.create({
//   baseURL: import.meta.env.VITE_REMOTE_API
// });

export default {

  getCollections() {
    return axios.get('/collections');
  },

  getCollectionById(collectionId) {
    return axios.get(`/collections/${collectionId}`)
  },

  getComicById(comicId) {
    return axios.get(`/collections/${comicId}`)
  },
  
  //Does this jawn work?  I don't know.  I'm just trying to get the collections to show up in the console.

  addComicToCollection(comic, collectionId) {
    return axios.post(`/collections/${collectionId}`, comic);
  },

  updateComic(comic) {
    return axios.put(`/comics/${comic.id}`, comic);
  },

  deleteComicFromCollection(comicId) {
    return axios.delete(`/comics/${comicId}`);
  },
  
  addCollection(collection) {
    return axios.post('/collection/create-collection', collection);
  },
  
  deleteCollection(collectionId) {
    return axios.delete(`/collections/${collectionId}`);
  }

}