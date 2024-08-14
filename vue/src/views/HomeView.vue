<template>
<div class="home">
  <div class="left-home">
  
    <div class = "comicsInDb">
      <h2>Comics in Database</h2>
      <router-link :to="'/collection/:collectionId/add'"><img class= "lotsComicPic" src="src\assets\SearchComics.jpg" alt="60k"></router-link>
      <p>Click above to search the database</p>
    </div>
    
    <div class = "collections" v-if="isLoggedIn"> 
      <h2>Manage Collections</h2>
      <router-link :to="'/my-collections'"><img class= "manageCollImg" src="src\assets\manageCollections.jpeg" alt="manageCollImg"></router-link>
      <p>Click above to view or manage your collections</p>

      <!-- <collection-card v-for="collection in this.$store.state.collections" :key="collection.id" :collection="collection" class="collection-card"/> -->
    </div>

    <div class = "stats"> 
      <h2>Statistics</h2>
      <h4>Total Collections: {{ numCollections }}</h4>
    </div>


  </div>
    <div class="right-home">
        <div class="upcomingComics">
          <h2>Upcoming Comics</h2>
        </div>
        <div class = "about">
          <h2 class="aboutUs">About Us</h2>
          <p class="aboutUsText">
            We are a group of comic book enthusiasts who have come together to create a platform for comic book lovers to manage their collections. 
            We have a database of over 60,000 comics for you to search through and add to your collection. 
            We hope you enjoy our platform and find it useful for managing your comic book collection.
            </p>
            <p> We're happy you are here - Dylan, Josh, Rob, and Mehmet.</p>

        </div>
    </div>


  </div>

</template>

<script>

import StatService from '../services/StatService';
// import CollectionCard from '../components/CollectionCard.vue';

export default {
  // components: {
  //   CollectionCard
  // },
  data(){
    return {
      numCollections: 0
    }
  },
  computed: {
    // collections() {
    //   return this.$store.state.collections;
    // },
    isLoggedIn() {
      return this.$store.state.token != '';
    }
  },
  mounted() {
    // this.getCollectionByUserId();
    this.getNumCollections();
  },
  
  methods: {
    goToAddComicView() {
      const collectionId = this.collectionId;
      if (!collectionId) {
        console.error("Missing collectionId");
        return;
      }
      this.$router.push({ name: 'add-comic', params: { id: collectionId} });
    },

    async getNumCollections() {
      try {
        const response = await StatService.numberOfCollections();
        this.numCollections = response.data; // Assuming response.data contains the number of collections
      } catch (error) {
        console.error("Error fetching number of collections:", error);
      }
    }

  }, 


};
</script>

<style scoped>

.comicsInDb{
    border: 3px solid #4c94f6;
    border-radius: 20px;
    width: 450px;
    height: 400px;
    margin: 10px;
    position: relative;
    background-color: white;
    text-align: center;
}

.stats{
    border: 3px solid #4c94f6;
    border-radius: 20px;
    width: 450px;
    height: 400px;
    margin: 10px;
    position: relative;
    background-color: white;
    text-align: center;
    
}
.collections{
  border: 3px solid #4c94f6;
  border-radius: 20px;
  width: 450px;
  height: 400px;
  margin: 10px;
  position: relative;
  text-align: center;
  background-color: white;
  display: flex;
  flex-direction: column; /* Arrange items vertically */
}
.collection-card {
  border: 1px solid #4c94f6;
  border-radius: 10px;
  padding: 15px;
  background-color: #f9f9f9;
  text-align: left;
  width: 100%; 
}

.upcomingComics{
  border: 3px solid #4c94f6;
    border-radius: 20px;
    width: 300px;
    height: 550px;
    margin: 10px;
    position: relative;
    text-align: center;
    display: flex;
    justify-content: center;
    background-color: white;
    margin-left: 5%;
}

.about{
  border: 3px solid #4c94f6;
    border-radius: 20px;
    width: 300px;
    height: 550px;
    margin: 10px;
    position: relative;
    text-align: center;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    background-color: white;
    margin-left: 5%;
}

.left-home{
  display: flex;
  flex-direction: column;
  margin-bottom: 10%;
}

.home{
  display: flex;
  justify-content: center;
  padding: 3%;
  font-family:monospace;
}

.searchBtn{
  background-color: #4c94f6;
  color: white;
  border: none;
  border-radius: 5px;
  padding: 10px;
  margin-top: 10px;
}
 .lotsComicPic{
    width: 300px;
    height: 300px;
 }
 .manageCollImg{
    width: 300px;
    height: 300px;
 }

 .aboutUsText{
  text-align: left; 
  line-height: 2.5;
  padding-left: 20px;
  padding-right: 20px;
 }
 

</style>
