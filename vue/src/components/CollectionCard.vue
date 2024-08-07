<template>
    <div class = "card">
        <h2 class = "title">{{collection.title}}</h2>
        <img class="img" src='/assets/createdcollectionimage.jpg' alt="created-collection-cover-image">
        <!-- Change method for addToCollection in here to viewCollection which will be a routerpush that will get the user's comics in collection, probably from CollectionService -->
        <button class="view-collection-button" @click="addToCollection">View Collection</button>
    </div>
</template>

<script>
export default {
    props: ['collection'],
    methods: {
        //TODO: create viewCollection method that pushes to a viewCollection route of some sort... maybe a CollectionService method that gets the comics in a collection?
        viewCollection() {
            this.$router.push({ name: 'my-collections' });
        }
    }

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