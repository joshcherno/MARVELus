
<template>

    <header>
      <h1>MARVELus</h1>
        <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'my-comics' }">My Comics</router-link>&nbsp;|&nbsp;
      <!-- TODO: Add a router link to a My Collections view -->
      <router-link v-bind:to="{ name: 'my-comics' }">My Collections</router-link>&nbsp;|&nbsp;
      <!-- TODO: Add a router link to a Profile view -->
      <router-link v-bind:to="{ name: 'my-comics' }">My Profile</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </header>

<body>    
</body>    

</template>

<script>
export default {

}
</script>

<style>

header {
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;        /* set font style for whole page */
    font-size: 2rem;         /* changed from 50px to 2 rem to better accommodate screen sizes?*/
    color: red;
    text-align: center;
    padding: 1rem;
    background-color: white;
}

#nav {
    font-size: 1rem;      /*changed to better fit with the title size */
}

h1 {
  margin-top: 0px;
  margin-bottom: 0px;
}




</style>