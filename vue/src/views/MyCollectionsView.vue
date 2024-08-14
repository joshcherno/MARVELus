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