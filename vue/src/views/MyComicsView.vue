<template>
  <h1 class = "header-text">My Comics</h1>

  <div id="my-comics">
    <add-comic-card/> 
    <comic-list/>
  </div>
</template>

<script>
import ComicList from '../components/ComicList.vue';
import AddComicCard from '../components/AddComicCard.vue';
export default {
    components: {
        ComicList,
        AddComicCard
    }

}
</script>

<style>
#my-comics {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2C3E50;
  margin: 30px;
  display: flex;
  flex-wrap: nowrap;
}

.card{
  background-color: white;
}

.header-text{
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

.new-comic-form {
    padding: 1%;
}



</style>