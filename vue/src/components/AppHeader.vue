
<template>

    <header>
    <h1 id="app_name">MARVELus</h1>
    <div id="nav">
      
      </div>
      <nav>
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'my-comics' }">My Comics</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> 
      </nav>
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
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    font-size: 50px;
    color: red;
    text-align: center;
    padding: 1rem;
    margin-bottom: 1rem;
    background-color: white;
}

#nav {
    font-size: 30px;
}




</style>