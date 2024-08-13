import { createStore as _createStore } from 'vuex';
import axios from 'axios';

// LOOKING AT M3D17 LECTURE finally, Store.JS LOOKS TO BE WHERE THE STATE NOTIFICATIONS ARE STORED - 
// THINK WHEN YOU ADD A COMIC AND AFTER ITS ADDED YOU GET A QUICK NOTIFICATION AT THE TOP THAT SAYS "COMIC ADDED TO YOUR LIBRARY"

const NOTIFICATION_TIMEOUT = 6000;

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      // test comics and collections; remove later!
      comics:[
        // {
        //   id: 1,
        //   title: 'The Amazing Spiderman',
        //   issue: 1,
        //   publisher: 'Marvel',
        //   date: '1993-01-01',
        //   isbn: '9780785136927'
        // },

        // {
        //   id: 2,
        //   title: 'The Incredible Hulk',
        //   issue: 1,
        //   publisher: 'Marvel',
        //   date: '1962-05-01',
        //   isbn: '9780785129387'
        // },

        // {
        //   id: 3,
        //   title: 'The Punisher',
        //   issue: 1,
        //   publisher: 'Marvel',
        //   date: '1986-01-01',
        //   isbn: '9780785157359'
        // },

        // {
        //   id: 4,
        //   title: 'Iron Man Vol 1',
        //   issue: 300,
        //   publisher: 'Marvel',
        //   date: '2013-01-01',
        //   isbn: '9780785168331'
        // }

      ],
      collections:[
        // {
        //   id: 1,
        //   title: 'First Editions',
        //   description: 'A collection of First Edition comics',
        //   comics: [
        //     {
        //       id: 1,
        //       title: 'The Amazing Spiderman',
        //       issue: 1,
        //       publisher: 'Marvel',
        //       date: '1993-01-01',
        //       isbn: '9780785136927'
        //     },
        //     {
        //       id: 2,
        //       title: 'The Incredible Hulk',
        //       issue: 1,
        //       publisher: 'Marvel',
        //       date: '1962-05-01',
        //       isbn: '9780785129387'
        //     },
    
        //     {
        //       id: 3,
        //       title: 'The Punisher',
        //       issue: 1,
        //       publisher: 'Marvel',
        //       date: '1986-01-01',
        //       isbn: '9780785157359'
        //     }
        //   ]
        // },

        // {
        //   id: 2,
        //   title: 'Hulk Collection',
        //   description: 'A collection of Hulk comics',
        //   comics: []
        // },

        // {
        //   id: 3,
        //   title: 'Punisher Collection',
        //   description: 'A collection of Punisher comics',
        //   comics: []
        // },
      ],

      token: currentToken || '',
      user: currentUser || {},
      notification: null,
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
      },
      //lines 7, and lines 105-134 is straight copy pasta from exercise m3d17 - this is the notification stuff and timeout stuff
      SET_NOTIFICATION(state, notification) {
        // Clear the current notification if one exists
        if (state.notification) {
          this.commit('CLEAR_NOTIFICATION');
        }

        if (typeof notification === 'string') {
          // If only a string was sent, create a notification object with defaults
          notification = {
            message: notification,
            type: 'error',
            timeout: NOTIFICATION_TIMEOUT
          }
        } else {
          // Else add default values if needed
          notification.type = notification.type || 'error';
          notification.timeout = notification.timeout || NOTIFICATION_TIMEOUT;
        }

        // Set the notification in state
        state.notification = notification;

        // Clear the message after timeout (see https://developer.mozilla.org/en-US/docs/Web/API/setTimeout)
        notification.timer = window.setTimeout(() => {
          this.commit('CLEAR_NOTIFICATION');
        }, notification.timeout);
      },
      
      setCollections(state, collections){
        state.collections = collections;
      },

      // ------------------------------- trying to change the state of the store to be adding comics from database
      setCollection(state, collection) {
        const index = state.collections.findIndex(c => c.id === collection.id);
        if (index !== -1) {
          state.collections.splice(index, 1, collection);
        } else {
          state.collections.push(collection);
        }
      },
    
      setComicsForCollection(state, { collectionId, comics }) {
        const collection = state.collections.find(c => c.id === collectionId);
        if (collection) {
          collection.comics = comics;
        }
      },

      // --------------------------



      CLEAR_NOTIFICATION(state) {
        if (state.notification && state.notification.timer) {
          window.clearTimeout(state.notification.timer);
        }
        state.notification = null;
      },
    },
  });
  return store;
}
