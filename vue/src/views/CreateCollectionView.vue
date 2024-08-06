<template>

<div> 

<h1 class="create-collection-headline">Create Collection</h1>

</div>

<new-collection-form/>

</template>

<script>
import NewCollectionForm from '../components/NewCollectionForm.vue'
export default {
  components: { NewCollectionForm },

}
</script>

<style>
.create-collection-headline{
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    background-color: rgba(0,0,0,.5);
    width: 33%;
    color: white;
    margin: auto;
    margin-top: 30px;
    padding: 0%;
}


</style>