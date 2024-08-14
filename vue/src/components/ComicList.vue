<template>
  
<div class = "comic-container">
    <collection-comic-card v-for="comic in comics" :comic="comic" v-bind:key="comic.UPC" :collectionId="activeCollectionId"/>
</div>

</template>

<script>

import CollectionComicCard from './CollectionComicCard.vue';

export default {
    components: {
        CollectionComicCard,
    }, 
    props: {
        comics: {
            type: Array,
            required: true
        }
    },
    data(){
        return {
            activeCollectionId: 0,
        }
    },
    mounted(){
        this.activeCollectionId = parseInt(this.$route.params.id);
    }

    

}
</script>

<style scoped>


</style>