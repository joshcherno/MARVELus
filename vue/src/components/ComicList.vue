<template>
  
<div class = "comic-container">
    <collection-comic-card v-for="comic in comics" :comic="comic" v-bind:key="comic.UPC"/>
</div>

</template>

<script>

import CollectionComicCard from './CollectionComicCard.vue';
import { mapState } from 'vuex';

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
    computed: {
       /*  ...mapState({
            comics(state){
                const collection = state.collections.find(c => c.id === parseInt(this.$route.params.id));
                return collection ? collection.comics :[];
            }
        }) */
    }

}
</script>

<style scoped>
.comic-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
}
</style>