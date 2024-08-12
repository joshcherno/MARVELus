<template>

  <h1 class="header-text">My Collections</h1>

  <div id="my-collections">
  <create-collection-card/>
  <collection-list/> 
  </div>
  
</template>

<script>
import CreateCollectionCard from '../components/CreateCollectionCard.vue';
import CollectionList from '../components/CollectionList.vue';
//TODO: implement collectionService

export default {
    components: {
        CreateCollectionCard,
        CollectionList,
        
    
        
    }

}
</script>

<style>

#my-collections {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2C3E50;
  margin: 50px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}

.header-text {
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

</style>