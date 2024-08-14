<template>
    <div class = "card">
        <h2 class = "title">{{comic.title}}</h2>
        <img class="img" v-bind:src="comic.coverArt">
        <h3 class = "publisher">{{ comic.publisher }} </h3>
        <button class="remove-from-collection-button" @click="removeComic">Remove Comic</button>
    </div>
</template>

import ComicService from '../services/ComicService';

<script>
import ComicService from '../services/ComicService'
export default {
    props: {
    comic: {
      type: Object,
      required: true
    },
    collectionId: {
      type: [Number],
      required: true
    }
  },
  
    
    methods: {
        removeComic(){
            ComicService.deleteComicFromCollection(this.collectionId, this.comic.comicId).then(response => {
                window.location.reload();
            });
        }    
    },
}
</script>

<style scoped>

.card{
    border: 3px solid #4c94f6;
    border-radius: 10px;
    width: 250px;
    height: 450px;
    background-color: white;
    margin: 1%;
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
    transform: scale(1.10);
    box-shadow: 0px 10px 20px rgb(30, 255, 0, 1);
}

.remove-from-collection-button{
    background-color: #4c94f6;
    color: white;
    border: none;
    padding: 12px;
    transition: background-color 0.3s ease, transform 0.3s ease;
    border-radius: 5px;
    font-family: monospace;
    position: relative;
    margin-left: 25%;
}

.remove-from-collection-button:hover{
    transform: scale(1.10);
    box-shadow: 0px 10px 20px #ee5454;
}



</style>