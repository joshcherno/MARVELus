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

<style scoped>
.create-collection-headline{
  font-family: monospace;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  border-radius: 5px;
  padding: 15px;
  margin: 10px;
  width: 50%;
  background-color: #4c94f6;
  color: white;
  text-align: center;
  margin-left: 22%;
  margin-top: 2%;
}


</style>