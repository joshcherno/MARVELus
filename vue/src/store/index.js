import { createStore as _createStore } from 'vuex';
import axios from 'axios';

// LOOKING AT M3D17 LECTURE finally, Store.JS LOOKS TO BE WHERE THE STATE NOTIFICATIONS ARE STORED - 
// THINK WHEN YOU ADD A COMIC AND AFTER ITS ADDED YOU GET A QUICK NOTIFICATION AT THE TOP THAT SAYS "COMIC ADDED TO YOUR LIBRARY"

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      // test comics and collections; remove later!
      comics:[
        {
          id: 1,
          title: 'The Amazing Spiderman',
          issue: 1,
          publisher: 'Marvel',
          date: '1993-01-01',
          isbn: '9780785136927'
        },

        {
          id: 2,
          title: 'The Incredible Hulk',
          issue: 1,
          publisher: 'Marvel',
          date: '1962-05-01',
          isbn: '9780785129387'
        },

        {
          id: 3,
          title: 'The Punisher',
          issue: 1,
          publisher: 'Marvel',
          date: '1986-01-01',
          isbn: '9780785157359'
        },

        {
          id: 4,
          title: 'Iron Man Vol 1',
          issue: 300,
          publisher: 'Marvel',
          date: '2013-01-01',
          isbn: '9780785168331'
        }

      ],
      collections:[
        {
          id: 1,
          title: 'Spiderman Collection',
          description: 'A collection of Spiderman comics',
          comics: [
            {
              id: 1,
              title: 'The Amazing Spiderman',
              issue: 1,
              publisher: 'Marvel',
              date: '1993-01-01',
              isbn: '9780785136927'
            },
          ]
        },

        {
          id: 2,
          title: 'Hulk Collection',
          description: 'A collection of Hulk comics',
          comics: []
        },

        {
          id: 3,
          title: 'Punisher Collection',
          description: 'A collection of Punisher comics',
          comics: []
        },
      ],

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
