<template>
  
<div class = "comic-container">
    <comic-card v-for="comic in $store.state.comics" :comic="comic" v-bind:key="comic.UPC"/>
</div>

</template>

<script>

import ComicCard from './ComicCard.vue';
import { mapState } from 'vuex';

export default {
    components: {
        ComicCard,
    }, 
    computed: {
        ...mapState({
            comics(state){
                const collection = state.collections.find(c => c.id === parseInt(this.$route.params.id));
                return collection ? collection.comics :[];
            }
        })
    }

}
</script>

<style>
.comic-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
}
</style>