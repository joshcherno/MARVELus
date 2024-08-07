<template>

  <h1 class="collections-title">My Collections</h1>

  <div id="my-collections">
  <create-collection-card/>
  <collection-list/> 
  </div>
  
</template>

<script>
import CreateCollectionCard from '../components/CreateCollectionCard.vue';
import CollectionList from '../components/CollectionList.vue';
//TODO: implement collectionService
import collectionService from '../services/CollectionService';

export default {
    components: {
        CreateCollectionCard,
        CollectionList
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
  margin: 30px;
  display: flex;
  flex-wrap: nowrap;
}

.collections-title {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  background-color: rgba(0,0,0,.75);
  width: 33%;
  color: white;
  margin: auto;
  padding: 0%;
}

.create-collection-img{
    width: 100%;
    height: 60%;
}

</style>