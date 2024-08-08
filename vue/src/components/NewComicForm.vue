<template>

<form class="new-comic-form" v-on:submit.prevent="">

    <h2 class="form-title">Search Comics to Add to your Library</h2>
    <input name="title-input" class="title-input" type="text" placeholder="Search by comic title" />
    <!-- <input name="issue-input" class="issue-input" type="text" placeholder="Issue" v-model="comic.issue"/>
    <input name="publisher-input" class="publisher-input" type="text" placeholder="Publisher" v-model="comic.publisher" />
    <input name="release-date-input" class="release-date-input" type="text" placeholder="Release Date" v-model="comic.date" />
    <input name="isbn-input" class="isbn-input" type="text" placeholder="ISBN" v-model="comic.isbn" /> -->
    <!-- added method and @click to route back to my-comics -->
    <button class= "submit" @click="getComicByTitle">Search</button> 
    

</form>

</template>

<script>
import comicService from '../services/ComicService';

export default {
    data() {
        return {
            comic: {}
        }
    },
    methods:{
        goToMyComics(){
            this.$router.push('/my-comics')
        },
        getComicByTitle() {
            comicService.getComicByTitle(this.comic.title).then(response => {
                this.comic = response.data;
            });
        }
    }

}
</script>

<style>
.new-comic-form {
    /* display: flex; */
    justify-content: center;
    align-content: center ;
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2C3E50;
    margin: 30px;
}

.form-title{
    background-color: rgba(0,0,0,.5);
    width: 33%;
    color: white;
    margin: auto;
    padding: 2%;
    font-size: 1rem;
}

.submit{
    margin-left: 1%;
    padding: 2%;
}



</style>