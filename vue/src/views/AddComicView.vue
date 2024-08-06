<template>
  
<div> 

<h1 class="add-comic-headline">Add Comic</h1>

</div>

<new-comic-form/>


</template>

<script>
import NewComicForm from '../components/NewComicForm.vue'
export default {
    components: {
        NewComicForm,
}


}
</script>

<style>
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