<template>
  <div id="my-collections">
    <h1 class="collections-title">My Collections</h1>
  </div>
  <create-collection-card/>
</template>

<script>
import CreateCollectionCard from '../components/CreateCollectionCard.vue';
export default {
    components: {
        CreateCollectionCard
    }

}
</script>

<style>

#my-collections {
  margin: 30px;
}

.collections-title {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  background-color: rgba(0,0,0,.5);
  width: 33%;
  color: white;
  margin: auto;
  padding: 0%;
}

.create-collection-card{
    border: 3px solid #4c94f6;
    border-radius: 10px;
    width: 75%;
    height: 8%;
    margin: 10px;
    position: relative;
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    background-color: white;
    margin-left: 10%;
}

.create-collection-img{
    width: 1em;
    margin-left: 1%;
    height: 2em;
}

.edit-collection-button{
    
}


</style>