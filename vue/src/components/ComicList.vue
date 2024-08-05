<template>
  
<div class = "comic-container">
    <comic-card v-for="comic in $store.state.comics" v-bind:comic="comic" v-bind:key="comic.isbn"/>
</div>

</template>

<script>

import ComicCard from './ComicCard.vue';

export default {
    components: {
        ComicCard,
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