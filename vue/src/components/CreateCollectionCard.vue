<template>
<router-link id="create-collection-router" :to="{ name: 'create-collection' }">
   <div class = "create-collection-card">
        <!-- <h2 class = "create-collection-card-header">Create a New Collection</h2> -->
        <img class="create-collection-img" v-bind:src="'src/assets/createcollectionimage2.jpg'" alt="cover-image">
        <!-- <h3>Turn your comics into something MARVELus</h3> -->
        <!-- <button class="create-collection-button" @click="goToCreateCollection">Create Collection</button> -->
    </div>
</router-link>
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

<style scoped>

.create-collection-card{
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    border: 3px solid #ee5454;
    border-radius: 10px;
    width: 20rem;
    height: 20rem;
    margin: 10px;
    position: relative;
    background-color: white;
    text-align: center;
} 

/* .create-collection-card:hover{
    background-color: white;
    color: white;
} */

.create-collection-img{
    width: 100%;
    height: 100%;
    /* margin-top: 2px; */
}

#create-collection-router {
  text-decoration: none;
  color: #ee5454;
}

</style>