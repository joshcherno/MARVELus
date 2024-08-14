<template>
<router-link id="add-comic-router" :to="{ name: 'add-comic' }">
  <div class = "add-comic-card">
    <!-- <h2 class = "add-comic-text">Add Comic</h2> -->
        <img class="add-comic-img" v-bind:src="'src/assets/AddComic.jpg'" alt="add-comic">
        <!-- <h3>Search comics to add to your library</h3> -->
        <!-- <button class="add-comic-button" @click="goToAddComic">Add Comic</button> -->
    </div>
</router-link>
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

<style scoped>

.add-comic-card{
    border: 3px solid #ee5454;
    border-radius: 10px;
    width: 250px;
    height: 300px;
    margin: 10px;
    position: relative;
    background-color: white;
    text-align: center;
} 

.add-comic-img{
    width: 250px;
    height: 300px;
   
}

#add-comic-router {
  text-decoration: none;
  color: #ee5454;
}
</style>