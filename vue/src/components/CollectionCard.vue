<template>
    <!-- Use the router-link to navigate to the collection's details page -->
    <!-- <router-link id="view-collection-router" :to="{ name: 'my-collections', params: { id: collection.id } }">  -->
      <div class="card">
        <!-- Display the collection's title -->
        <h2 class="collection-card-header">{{ collection.collectionName }}</h2>
        <!-- Display the collection's image -->
        <img class="collection-img" src="@/assets/createdcollectionimage.jpg" alt="created-collection-cover-image">
        <button class = "collectionDetails" @click="viewCollection">View Collection</button>
      </div>
    <!-- </router-link> -->
  </template>
  
  <script>
  import CollectionService from '../services/CollectionService';
  export default {
    props: {
      collection: {
        type: Object,
        required: true
      }
    },
    methods:{
        viewCollection(){
            CollectionService.getComicsByCollectionId(this.collection.collectionId)
              .then((response) => {
                console.log('Comics:', response.data);
                this.$router.push({ name: 'view-collection', params: { id: this.collection.collectionId } });
              });
        },
       
    }
  }
  </script>
  
  <style scoped>
  .card {
    border: 3px solid #4c69f6;
    border-radius: 10px;
    width: 250px;
    height: 500px;
    margin: 10px;
    position: relative;
  }
  
  .collection-img {
    width: 100%;
    height: 80%;
  }
  
  #view-collection-router {
    text-decoration: none;
    color: #4c69f6;
  }
  </style>
  