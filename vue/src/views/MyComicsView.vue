<template>
  <h1 class = "header-text">My Comics</h1>

  <div id="my-comics">
    <div class="addComicCard"><add-comic-card/></div>
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

<style scoped>
#my-comics {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2C3E50;
  margin-top: 3%;
  display: flex;
  /* flex-wrap: wrap; */
  justify-content: space-around;
}

.card{
  background-color: white;
  /* flex-grow: 1;
  flex-shrink: 1; */
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

/* @media (max-width: 768px) {
  .card{
    flex: 1 1 calc(100% - 40px);
  }
}  */

/* @media (min-width: 769px) and (max-width: 1024px) {
  .card{
    flex: 1 1 calc(50% - 40px);
  }
} */

.addComicCard{
  transition: background-color 0.3s ease, transform 0.3s ease;
  padding: 0px;
  border-radius: 8px;
}
.addComicCard:hover{
  background-color: #4c94f6; 
  height: 10%;
  transform: scale(1.04); 
  box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.2);
}

</style>