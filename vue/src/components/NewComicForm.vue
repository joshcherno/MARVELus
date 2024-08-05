<template>

<form class="new-comic-form" v-on:submit.prevent="">

    <h2>Add a New Comic</h2>
    <input name="title-input" class="title-input" type="text" placeholder="Title" v-model="comic.title" />
    <input name="issue-input" class="issue-input" type="text" placeholder="Issue" v-model="comic.issue"/>
    <input name="publisher-input" class="publisher-input" type="text" placeholder="Publisher" v-model="comic.publisher" />
    <input name="release-date-input" class="release-date-input" type="text" placeholder="Release Date" v-model="comic.date" />
    <input name="isbn-input" class="isbn-input" type="text" placeholder="ISBN" v-model="comic.isbn" />
    <button type="submit">Add Comic</button>

</form>

</template>

<script>
export default {

}
</script>

<style>
.new-comic-form {
    display: flex;
    justify-content: center;
    align-content: center ;
}

</style>