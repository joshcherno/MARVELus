import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      // test comics and collections; remove later!
      comics:[
        {
          title: 'The Amazing Spiderman',
          issue: 1,
          publisher: 'Marvel',
          date: '1993-01-01',
          isbn: '9780785136927'
        },

        {
          title: 'The Incredible Hulk',
          issue: 1,
          publisher: 'Marvel',
          date: '1962-05-01',
          isbn: '9780785129387'
        },

        {
          title: 'The Punisher',
          issue: 1,
          publisher: 'Marvel',
          date: '1986-01-01',
          isbn: '9780785157359'
        },

        {
          title: 'Iron Man Vol 1',
          issue: 300,
          publisher: 'Marvel',
          date: '2013-01-01',
          isbn: '9780785168331'
        }

      ],
      collections:[],

      token: currentToken || '',
      user: currentUser || {}
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      }
    },
  });
  return store;
}
