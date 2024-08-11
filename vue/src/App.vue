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
  background-size: cover;
  background-attachment: fixed;
  background-position: center center;
  background-repeat: no-repeat;
}


</style>
