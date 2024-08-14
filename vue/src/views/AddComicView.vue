<template>
  
<div> 

<h1 class="add-comic-headline">Search Comics</h1>

</div>

<new-comic-form v-bind:collectionId="userCollectionId"/>


</template>

<script>
import NewComicForm from '../components/NewComicForm.vue'
export default {
    data() {
        return {
            userCollectionId: Number.parseInt(this.$route.params.collectionId),
        };
    },
    components: {
        NewComicForm,
},

created() {

},


}
</script>

<style scoped>
.add-comic-headline{
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