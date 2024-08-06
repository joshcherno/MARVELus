<template>
  <div class = "add-comic-card">
    <h2 class = "add-comic-text">Add Comic</h2>
        <img class="add-comic-img" v-bind:src="'src/assets/AddComic.jpg'" alt="add-comic">
        <h3>Search comics and add to your library</h3>
        <button class="add-comic-button" @click="goToAddComic">Add Comic</button>
    </div>
</template>

<script>
export default {
    props: ['comic'],
    methods: {
        goToAddComic() {
            this.$router.push({ name: 'add-comic' });
        }
    }
}
</script>

<style>

.add-comic-card{
    border: 3px solid #4c94f6;
    border-radius: 10px;
    width: 250px;
    height: 500px;
    margin: 10px;
    position: relative;
    background-color: white;
} 

.add-comic-img{
    width: 90%;
    height: 50%;
   
}
</style>