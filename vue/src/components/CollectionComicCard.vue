<template>
    <div class = "card">
        <h2 class = "title">{{comic.title}}</h2>
        <img class="img" v-bind:src="comic.coverArt">
        <h3 class = "publisher">{{ comic.publisher }} </h3>
        <button class="remove-from-collection-button" @click="removeFromCollection">Remove Comic</button>
    </div>
</template>

<script>
export default {
    props: ['comic'],
    methods: {
       
        
    },

}
</script>

<style scoped>

.card{
    border: 3px solid #4c94f6;
    border-radius: 10px;
    width: 250px;
    height: 500px;
    
}

img, button, h2, h3{
    
    margin-left: 20px;
}


img {
    width: 210px;
    height: 260px;
}

.add-to-collection-button{
    background-color: #4c94f6;
    color: white;
    border: none;
    padding: 12px;
    transition: background-color 0.3s ease, transform 0.3s ease;
    border-radius: 5px;
}

.add-to-collection-button:hover{
    background-color: #2c6aa0;
    transform: scale(1.04);
    box-shadow: 0px 5px 10px rgb(30, 255, 0, 1);
}



</style>