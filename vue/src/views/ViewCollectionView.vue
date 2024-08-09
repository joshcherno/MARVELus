<template>
  <div>
        <div class="collection-actions">
            <router-link v-bind:to="{ name: 'MyCollectionsView' }">Back to My Collections</router-link>
        </div>
        <div class="loading" v-if="isLoading">
            <img src="../assets/spiderman-loading.gif" />
        </div>
    <div v-else>
        <div class="header">
            <h1> {{collection.title}} </h1>
            <router-link class="btn btn-submit" :to="{ name: 'AddComicView', params: { collectionId: collection.id } }">Add
                New Comic</router-link>
                <button class="btn btn-cancel deleteCollection" v-on:click="deleteCollection">Delete Collection</button>
            <!-- <p> {{ collection.description }} </p> -->
        </div>

        <div id="comics-in-collection">
            <!-- TODO: Figure out how to make this show comics in the collection -->
            <comic-list :comics="comics" :collectionId="collection.id" />

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
            collection: { title: '', description: '', comics: [] },
            isLoading: true
        };
    },
    computed: {
        comics() {
            return this.collection.comics;
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
            this.$router.push({ name: 'MyCollectionsView' });
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
    }
  },
  created() {
    let collectionId = parseInt(this.$route.params.id);
    collectionService.getCollectionById(collectionId)
      .then(response => {
        this.board = response.data;
        this.isLoading = false;
      })
      .catch(error => {
        if (error.response) {
          if (error.response.status === 404) {
            this.$store.commit('SET_NOTIFICATION',
              "Error: Collection " + collectionId + " was not found. This board may have been deleted or you have entered an invalid collection ID.");
            this.$router.push({ name: 'MyCollectionsView' });
          } else {
            this.$store.commit('SET_NOTIFICATION',
              "Error getting board " + collectionId + ". Response received was '" + error.response.statusText + "'.");
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

<style>
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
}
</style>