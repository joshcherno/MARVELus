<template>

   <div class = "create-collection-card">
        <h2 class = "title">Create a collection</h2>
        <img class="create-collection-img" v-bind:src="'src/assets/createcollectionimage2.jpg'" alt="cover-image">
        <button class="edit-collection-button" v-on:click.prevent>Edit New Collection</button>
    </div>

</template>

<script>
export default {
    props: ['collection'],

}
</script>

<style>

</style>