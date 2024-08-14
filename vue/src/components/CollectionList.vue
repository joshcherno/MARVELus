<template>
  
    <div class = "collection-container">
        <collection-card v-for="collection in $store.state.collections" v-bind:collection="collection" v-bind:key="collection.title"/>
    </div>
    
    </template>
    
    <script>
    //TODO: FIGURE OUT HOW TO MAKE COLLECTION LIST MIRROR COMIC LIST (CURRENTLY COPY PASTA'D IN THIS FILE, COLLECTIONLIST  )
    
    import CollectionCard from './CollectionCard.vue';
    
    export default {
        components: {
            CollectionCard,
        }
    
    }
    </script>
    
    <style scoped>
    .collection-container {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-evenly;
    }
    </style>