<template>

   <div class = "create-collection-card">
        <h2 class = "title">Create a New Collection</h2>
        <img class="create-collection-img" v-bind:src="'src/assets/createcollectionimage2.jpg'" alt="cover-image">
        <button class="create-collection-button" @click="goToCreateCollection">Create Collection</button>
    </div>

</template>

<script>
export default {
    props: ['collection'],
    methods: {
        goToCreateCollection() {
            this.$router.push({ name: 'create-collection' });
        }

}
}
</script>

<style>

.create-collection-card{
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    border: 3px solid #ee5454;
    border-radius: 10px;
    width: 250px;
    height: 400px;
    margin: 5%;
    position: relative;
    background-color: white;
    text-align: center;
} 

.create-collection-img{
    width: 100%;
    height: 50%;
   
}

</style>