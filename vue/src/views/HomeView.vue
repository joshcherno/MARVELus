<template>

<div class="home">
  <div class="left-home">
  
    <div class = "comicsInDb">
      <h2>Comics in Database</h2>
    </div>
    
    <div class = "stats"> 
      <h2>Statistics</h2>
    </div>

    <div class="search">
      <h2>Search our database for comics!</h2>
      <button class="searchBtn" @click="goToAddComicView">GO</button>
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


export default {
  methods: {
    goToAddComicView() {
      this.$router.push({ name: 'add-comic' });
    }
  }


};
</script>

<style scoped>

.comicsInDb{
    border: 3px solid #4c94f6;
    border-radius: 20px;
    width: 450px;
    height: 250px;
    margin: 10px;
    position: relative;
    background-color: white;
    text-align: center;
}

.stats{
    border: 3px solid #4c94f6;
    border-radius: 20px;
    width: 450px;
    height: 250px;
    margin: 10px;
    position: relative;
    background-color: white;
    text-align: center;
}

.search{
  border: 3px solid #4c94f6;
    border-radius: 20px;
    width: 450px;
    height: 250px;
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
    background-color: white;
    text-align: center;
    display: flex;
    justify-content: center;

}

.left-home{
  display: flex;
  flex-direction: column;

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


</style>
