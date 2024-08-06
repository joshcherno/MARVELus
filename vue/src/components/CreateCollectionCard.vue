<template>

   <div class = "create-collection-card">
        <h2 class = "title">Create a collection</h2>
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
    border: 3px solid #4c94f6;
    border-radius: 10px;
    width: 250px;
    height: 500px;
    margin: 10px;
    position: relative;
    background-color: white;
} 

.create-collection-img{
    width: 90%;
    height: 50%;
   
}

</style>