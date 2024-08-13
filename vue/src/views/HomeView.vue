<template>
<div class="home">
  <div class="left-home">
  
    <div class = "comicsInDb">
      <h2>Comics in Database</h2>
      <router-link :to="'/collection/:collectionId/add'"><img class= "lotsComicPic" src="src\assets\SearchComics.jpg" alt="60k"></router-link>
      <p>Click above to search the database</p>
    </div>
    
    <div class = "stats"> 
      <h2>Statistics</h2>
      <h4>Total Collections: {{ numCollections }}</h4>
    </div>


  </div>
      <div class="right-home">
         <h2>Upcoming Comics</h2>
      </div>
      <div class = "about">
          <h2></h2>

      </div>

  </div>

</template>

<script>

import StatService from '../services/StatService';

export default {
  data(){
    return {
      numCollections: 0
    }
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
  mounted (){
    this.getNumCollections();
  }


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


.right-home{
  border: 3px solid #4c94f6;
    border-radius: 20px;
    width: 300px;
    height: 528px;
    margin: 10px;
    position: relative;
    text-align: center;
    display: flex;
    justify-content: center;
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

</style>
