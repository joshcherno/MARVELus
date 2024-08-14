<template>

  <h1 class="header-text">My Collections</h1>

  <div id="my-collections">
    <create-collection-card/>
    <collection-card v-for="collection in this.$store.state.collections" :key="collection.id" :collection="collection" />
  </div>
  
</template>

<script>
import CreateCollectionCard from '../components/CreateCollectionCard.vue';
import CollectionCard from '../components/CollectionCard.vue';
import CollectionService from '../services/CollectionService';

export default {
  components: {
    CreateCollectionCard,
    CollectionCard
  },
  computed: {
    collections() {
      return this.$store.state.collections;
    }
  },
  mounted() {
    this.getCollectionByUserId();
  },
  methods: {
    getCollectionByUserId(){
      CollectionService.getCollectionByUserId(this.$store.state.user.id).then((response) => {
        console.log('Collections:', response.data);
        this.$store.commit('setCollections', response.data);
      });
    }
  }
}
</script>

<style scoped>

#my-collections {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2C3E50;
  margin: 50px;
  display: flex;
  flex-wrap: wrap;
}

.header-text {
  font-family: monospace;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  border-radius: 5px;
  padding: 15px;
  margin: 10px;
  width: 50%;
  background-color: #4c94f6;
  color: white;
  text-align: center;
  margin-left: 22%;
  margin-top: 2%;
}

</style>