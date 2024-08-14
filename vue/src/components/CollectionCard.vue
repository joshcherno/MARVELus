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
    height: 400px;
    margin: 10px;
    position: relatve;
    background-color: white;
  }
  
  .collection-img {
    width: 100%;
    height:50%;
  }
  
  #view-collection-router {
    text-decoration: none;
    color: #4c69f6;
  }

  .collectionDetails{
    background-color: #4c69f6;
    color: white;
    border: none;
    border-radius: 5px;
    padding: 15px;
    margin: 10px;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.3s ease;
  }
  .collectionDetails:hover{
    transform: scale(1.10);
    box-shadow: 0px 10px 20px rgb(30, 255, 0, 1);
  }
  </style>
  