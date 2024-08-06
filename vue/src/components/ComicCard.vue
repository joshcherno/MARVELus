<template>
    <div class = "card">
        <h2 class = "title">{{comic.title}}</h2>
        <img class="img" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + comic.isbn + '-M.jpg'" alt="cover-image">
        <h3 class = "publisher">{{ comic.publisher }} </h3>
        <button class="add" v-on:click.prevent>Add Comic To Collection</button>
    </div>
</template>

<script>
export default {
    props: ['comic'],

}
</script>

<style>

.card{
    border: 3px solid #4c94f6;
    border-radius: 10px;
    width: 250px;
    height: 500px;
    margin: 10px;
    position: relative;
}

.img{
    width: 80%;
}



</style>