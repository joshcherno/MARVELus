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
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2C3E50;
  margin: 30px;
  display: flex;
  justify-content: space-evenly;
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