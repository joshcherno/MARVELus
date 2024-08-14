<template>
  <div>
        <!-- <div class="collection-actions">
            <router-link v-bind:to="{ name: 'my-collections' }"> Back to My Collections</router-link>
        </div> -->
        <div class="loading" v-if="isLoading">
            <img src="../assets/spiderman-loading.gif" />
        </div>
    <div v-else>
        <div class="header">
            <router-link class="collection-actions" v-bind:to="{ name: 'my-collections' }"> Back to My Collections</router-link>
            <h1> {{collection.collectionName}} </h1>
            <router-link class="btn-submit" :to="{ name: 'add-comic', params: { collectionId: activeCollectionId} }">Add New Comic</router-link>
            <button class="btn-delete" v-on:click="deleteCollection">Delete Collection</button>
            <!-- <p> {{ collection.description }} </p> -->
        </div>

        <div id="comics-in-collection">
            <comic-list :comics="collection.comics"/>

        </div>

    </div>

  </div>
</template>

<script>

import ComicList from '../components/ComicList.vue';
import collectionService from '../services/CollectionService';

export default {
  components: { 
    ComicList 
    },
    data() {
        return {
            collection: { id: '', title: '', description: '', comics: [] },
            isLoading: true,
            activeCollectionId: '',
        };
    },
    computed: {
        comics() {
            return this.collection.comics || [];
        }
    },
    methods: {

    deleteCollection() {
      if (confirm("Are you sure you want to delete this collection and all associated comics? This action cannot be undone.")) {
        this.isLoading = true;
        collectionService.deleteCollection(this.activeCollectionId).then(response => {
          this.isLoading = false;
          if (response.status === 204 || response.status === 200) {
            this.$store.commit('SET_NOTIFICATION',
              {
                message: `Collection has been deleted`,
                type: 'success'
              });
            this.$router.push({ name: "my-collections" });
          }
        }).catch(error => {
          if (error.response) {
            this.$store.commit('SET_NOTIFICATION',
              "Error deleting collection. Response received was '" + error.response.statusText + "'.");
          } else if (error.request) {
            this.$store.commit('SET_NOTIFICATION',
              "Error deleting collection. Server could not be reached.");
          } else {
            this.$store.commit('SET_NOTIFICATION',
              "Error deleting collection. Request could not be created.");
          }
          this.isLoading = false;
        });
      }
    },

    loadComics() {

      

    },
  },
   mounted() {
    this.activeCollectionId = parseInt(this.$route.params.id);

    //alert(this.activeCollectionId);

    collectionService.getCollectionById(this.activeCollectionId)
      .then((response) => {

        this.collection = response.data;


        collectionService.getComicsByCollectionId(this.activeCollectionId)
          .then((response) => {
            this.collection.comics = response.data;
            this.isLoading = false;
          })
          .catch(error => {
            if (error.response) {
              if (error.response.status === 404) {
                this.$store.commit('SET_NOTIFICATION',
                  "Error: Collection " + this.activeCollectionId + " was not found. This collection may have been deleted or you have entered an invalid collection ID.");
                this.router.push({ name: "my-collections" });
              } else {
                this.$store.commit('SET_NOTIFICATION',
                  "Error getting collection " + this.activeCollectionId + ". Response received was '" + error.response.statusText + "'.");
              }
            } else if (error.request) {
              this.$store.commit('SET_NOTIFICATION', "Error getting collection. Server could not be reached.");
            } else {
              this.$store.commit('SET_NOTIFICATION', "Error getting collection. Request could not be created.");
            }
          });

        this.isLoading = false;
      })
      .catch(error => {
        if (error.response) {
          if (error.response.status === 404) {
            this.$store.commit('SET_NOTIFICATION',
              "Error: Collection " + this.activeCollectionId + " was not found. This collection may have been deleted or you have entered an invalid collection ID.");
            this.router.push({ name: "my-collections" });
          } else {
            this.$store.commit('SET_NOTIFICATION',
              "Error getting collection " + this.activeCollectionId + ". Response received was '" + error.response.statusText + "'.");
          }
        } else if (error.request) {
          this.$store.commit('SET_NOTIFICATION', "Error getting collection. Server could not be reached.");
        } else {
          this.$store.commit('SET_NOTIFICATION', "Error getting collection. Request could not be created.");
        }
      });
    

   },

  created() {
    this.activeCollectionId = parseInt(this.$route.params.id);

    alert(this.activeCollectionId);

    collectionService.getCollectionById(this.activeCollectionId)
      .then((response) => {
        this.collection = response.data;
        this.isLoading = false;
      })
      .catch(error => {
        if (error.response) {
          if (error.response.status === 404) {
            this.$store.commit('SET_NOTIFICATION',
              "Error: Collection " + this.activeCollectionId + " was not found. This collection may have been deleted or you have entered an invalid collection ID.");
            this.router.push({ name: "my-collections" });
          } else {
            this.$store.commit('SET_NOTIFICATION',
              "Error getting collection " + this.activeCollectionId + ". Response received was '" + error.response.statusText + "'.");
          }
        } else if (error.request) {
          this.$store.commit('SET_NOTIFICATION', "Error getting collection. Server could not be reached.");
        } else {
          this.$store.commit('SET_NOTIFICATION', "Error getting collection. Request could not be created.");
        }
      });
  }
}
</script>

<style scoped>
#comics-in-collection {

  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;

}

.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 2%;
}

.header h1 {
  font-family: monospace;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  border-radius: 5px;
  padding: 15px;
  margin: 10px;
  flex-grow: 1;
  background-color: #4c94f6;
  color: white;
  text-align: center;
}

.collection-actions {
  background-color: #4c69f6;
  color: white;
  border: none;
  border-radius: 5px;
  padding: 15px;
  margin: 10px;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.3s ease;
  font-family: monospace;
}
.collection-actions:hover {
  background-color: #4c69f6;
  transform: scale(1.10);
  box-shadow: 0px 10px 20px rgb(30, 255, 0, 1);
}

.btn-submit {
  background-color: #4c69f6;
  color: white;
  border: none;
  border-radius: 5px;
  padding: 15px;
  margin: 10px;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.3s ease;
  font-family: monospace;
}

.btn-submit:hover {
  background-color: #4c69f6;
  transform: scale(1.10);
  box-shadow: 0px 10px 20px rgb(30, 255, 0, 1);
}

.btn-delete {
  background-color: #4c69f6;
  color: white;
  border: none;
  border-radius: 5px;
  padding: 15px;
  margin: 10px;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.3s ease;
  font-family: monospace;
}
.btn-delete:hover {
  background-color: #4c69f6;
  transform: scale(1.10);
  box-shadow: 0px 10px 20px #ee5454;
}

.loading {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
</style>