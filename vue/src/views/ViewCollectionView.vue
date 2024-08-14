<template>
  <div>
        <div class="collection-actions">
            <router-link v-bind:to="{ name: 'my-collections' }"> Back to My Collections</router-link>
        </div>
        <div class="loading" v-if="isLoading">
            <img src="../assets/spiderman-loading.gif" />
        </div>
    <div v-else>
        <div class="header">
            <h1> {{collection.collectionName}} </h1>
            <router-link class="btn-submit" :to="{ name: 'add-comic', params: { collectionId: activeCollectionId} }">Add
                New Comic</router-link>
                <button class="btn-cancel deleteCollection" v-on:click="deleteCollection">Delete Collection</button>
            <!-- <p> {{ collection.description }} </p> -->
        </div>

        <div id="comics-in-collection">
            <!-- TODO: Figure out how to make this show comics in the collection -->
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
            activeCollectionId: 0,
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
        collectionService.deleteCollection(this.collection.id).then(response => {
          this.isLoading = false;
          if (response.status === 200) {
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
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
}

.header {
  display: flex;
  align-items: center;
}

.header h1 {
  flex-grow: 1;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  background-color: rgba(0,0,0,.5);
  width: 33%;
  color: white;
  margin: auto;
  margin-top: 30px;
  padding: 0%;
}
.collection-actions {
  margin-top: 20px;
  margin-left:10px;
  margin-right: 85%;
  background-color: white;
    color: white;
    border: none;
    padding: 12px;
    transition: background-color 0.3s ease, transform 0.3s ease;
    border-radius: 5px;
    font-family: monospace;

}
</style>