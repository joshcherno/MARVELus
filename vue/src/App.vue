<template>
  
  <div class = "form-container" id="capstone-app">
    <header>
        <AppHeader />
    </header>
  <router-view />
  </div>
</template>


<script>
import AppHeader from './components/AppHeader.vue'
// import AppHeader from './components/AppHeader.vue';

  export default {
  components: { AppHeader },
    name: 'App',
  }



</script>


<style scoped>

.form-container {
  background-image: url('@/assets/testbackgroundmural.jpg');
  width: 100vw;
  height: 100vh;
}



</style>
