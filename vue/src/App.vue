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

  export default {
  components: { AppHeader },
    name: 'App',
  }



</script>


<style scoped>

.form-container {
  background-image: url('src/assets/backgroundImage.jpg');
  width: 100vw;
  height: 100vh;
  background-size: cover;
}



</style>
