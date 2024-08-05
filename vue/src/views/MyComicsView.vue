<template>
  <div id="my-comics">
    <h1>My Comics</h1>
    <comic-list/>
    <new-comic-form/>

  </div>
</template>

<script>
import ComicList from '../components/ComicList.vue';
import NewComicForm from '../components/NewComicForm.vue';

export default {
    components: {
        ComicList,
        NewComicForm
    }

}
</script>

<style>
#my-comics {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2C3E50;
  margin: 60px;
}

</style>