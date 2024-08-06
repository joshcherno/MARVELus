<template>

<form class="new-comic-form" v-on:submit.prevent="">

    <h2 class="form-title">Add a New Comic</h2>
    <input name="title-input" class="title-input" type="text" placeholder="Title" v-model="comic.title" />
    <input name="issue-input" class="issue-input" type="text" placeholder="Issue" v-model="comic.issue"/>
    <input name="publisher-input" class="publisher-input" type="text" placeholder="Publisher" v-model="comic.publisher" />
    <input name="release-date-input" class="release-date-input" type="text" placeholder="Release Date" v-model="comic.date" />
    <input name="isbn-input" class="isbn-input" type="text" placeholder="ISBN" v-model="comic.isbn" />
    <button class= "submit" type="submit">Add Comic</button>

</form>

</template>

<script>
export default {
    data() {
        return {
            comic: {
                title: '',
                issue: '',
                publisher: '',
                date: '',
                isbn: ''
            }
        }
    }

}
</script>

<style>
.new-comic-form {
    display: flex;
    justify-content: center;
    align-content: center ;
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