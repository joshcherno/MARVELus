<template>
  
  <div class = "form-container" id="capstone-app">
    <header>
        <h1>MARVELus</h1>
        <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'my-comics' }">My Comics</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </header>
  
   
    <router-view />
  </div>
</template>

<script>
// import AppHeader from './components/AppHeader.vue';

  export default {
    name: 'App',
  }



</script>


<style scoped>

.form-container {
  background-image: url('@/assets/testbackgroundmural.jpg');
  width: 100vw;
  height: 100vh;
}

#nav {
  background-color: white;
}


</style>
