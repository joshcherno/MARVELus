<template>

  <div class="form-container" id="capstone-app">

    <header>
      <AppHeader />
    </header>

    <router-view />

    <footer>
      <AppFooter />
    </footer>
    
  </div>
</template>


<script>
import AppHeader from './components/AppHeader.vue'
import AppFooter from './components/AppFooter.vue'

export default {
  components: { AppHeader, AppFooter },
  name: 'App',

}

</script>


<style scoped>
.form-container {
  background-image: url('@/assets/backgroundImage.jpg');
  background-size: cover;
  background-attachment: fixed;
  background-position: center center;
  background-repeat: no-repeat;
  height: 100vh;
}

/* @media (max-width: 768px) {
  .form-container {
   background-size: cover;
  }
} */
</style>
