<template>
    <router-link id="view-collection-router" :to="{ name: 'view-collection', params: { id: collection.id } }"> 
        <div class = "card">
            <h2 class = "collection-card-header">{{collection.title}}</h2>
            <img class="collection-img" v-bind:src="'src/assets/createdcollectionimage.jpg'" alt="created-collection-cover-image">
         <!-- Change method for addToCollection in here to viewCollection which will be a routerpush that will get the user's comics in collection, probably from CollectionService -->
         <!-- <button class="view-collection-button" @click="viewCollectionDetails">View Collection</button>  -->
        </div>
    </router-link>
</template>

<script>
export default {
    props: ['collection'],
    methods: {
        //TODO: create viewCollection method that pushes to a viewCollection route of some sort... maybe a CollectionService method that gets the comics in a collection?
        viewCollectionDetails() {
            this.$router.push({ name: 'view-collection' });
        }
    }

}
</script>

<style>

.card{
    border: 3px solid #4c69f6;
    border-radius: 10px;
    width: 250px;
    height: 500px;
    margin: 10px;
    position: relative;
}

.collection-img{
    width: 100%;
    height: 80%;

}

#view-collection-router {
  text-decoration: none;
  color: #4c69f6;
}

</style>