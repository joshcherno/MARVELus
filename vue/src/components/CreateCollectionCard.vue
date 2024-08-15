<template>
<router-link id="create-collection-router" :to="{ name: 'create-collection' }">
   <div class = "create-collection-card">
        <img class="create-collection-img" v-bind:src="'src/assets/createcollec.jpg'" alt="cover-image">
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
    width: 250px;
    height: 400px;
    margin: 10px;
    position: relatve;
    background-color: white;
} 

 .create-collection-card:hover{
    transform: scale(1.08) ;
    box-shadow: 0px 10px 20px rgb(30, 255, 0, 1);
} 

.create-collection-img{
    width: 100%;
    height: 100%;
}

#create-collection-router {
  text-decoration: none;
  color: #ee5454;
}

</style>