import axios from 'axios';

axios.interceptors.request.use(
  config => {
    const token = localStorage.getItem('token');
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
  //add a method to get comics by collection ID so that when you click "view collection" it will show the comics in that collection

  getCollectionById(collectionId) {
    return axios.get(`/collections/${collectionId}`)
  },

  getCollectionByUserId(userId) {
    return axios.get(`/collection/user/${userId}`)
  },

  getComicById(comicId) {
    return axios.get(`/collections/${comicId}`)
  },
  

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