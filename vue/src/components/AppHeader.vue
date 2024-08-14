<template>

  <div id="main">

    <header>
      <router-link id="header-home-router" :to="{ name: 'home' }">
        <h1>MARVELus</h1>
      </router-link>
      <div id="nav">
        <div class="hamburger-container" @click="toggleMenu">
        <button class="hamburger">
          <div class="line" :class="{ 'line1': menuOpen }"></div>
          <div class="line" :class="{ 'line2': menuOpen }"></div>
          <div class="line" :class="{ 'line3': menuOpen }"></div>
        </button>
        </div>

        <nav v-if="menuOpen" class="menu">
          <ul>
            <li>
              <div @click="toggleMenu"><router-link to="/">Home</router-link></div>
            </li>
            <li v-show="isLoggedIn">
              <div @click="toggleMenu"><router-link to="/my-comics">My Comics</router-link></div>
            </li>
            <li v-show="isLoggedIn">
              <div @click="toggleMenu"><router-link to="/my-collections">My Collections</router-link></div>
            </li>
            <!-- <li v-show="isLoggedIn">
              <div @click="toggleMenu"><router-link to="/profile">Profile</router-link></div>
            </li> -->
            <li v-show="!isLoggedIn">
              <div @click="toggleMenu"><router-link to="/login">Login/Sign Up</router-link></div>
            </li>
            <li v-show="isLoggedIn">
              <div @click="toggleMenu"><router-link to="/logout">Logout</router-link></div>
            </li>

          </ul>
        </nav>

        <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
                <router-link v-bind:to="{ name: 'my-comics' }">My Comics</router-link>&nbsp;|&nbsp;
                <router-link v-bind:to="{ name: 'my-collections' }">My Collections</router-link>&nbsp;|&nbsp;
                TODO: Add a router link to a Profile view -->
      </div>
    </header>

    <body>
    </body>

  </div>

</template>

<script>
export default {

  data() {
    return {
      menuOpen: false,
    };
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.token != '';
    }
  },
  methods: {
    toggleMenu() {
      this.menuOpen = !this.menuOpen;
    },
    
  }

}
</script>

<style scoped>
header {
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  font-size: 2rem;
  color: red;
  text-align: center;
  padding: .5rem;
  background-color: white;
  position: relative;

}

.hamburger {
  background: none;
  border: none;
  cursor: pointer;
  z-index: 10;
  padding: 10px;
  position: absolute;
  left: 10px;
  top: 20%;
  width: 4rem;
  height: 60px;

}

.line {
  width: 2rem;
  height: 4px;
  background-color: #ee5454;
  margin: 7px;
  transition: all .5s ease;
}

#nav {
  font-size: 1rem;
}

h1 {
  margin-top: 0px;
  margin-bottom: 0px;
}

a {
  text-decoration: none;
  color: #ee5454;
}


.line1 {
  transform: rotate(45deg) translate(13px, 12px);
  top: 0px;
}

.line2 {
  opacity: 0;
}

.line3 {
  transform: rotate(-45deg) translate(4px, -2px);
}

.menu {
  position: absolute;
  top: 30px;
  left: 5px;
  background-color: rgb(228, 223, 223, .95);
  height: 30vh;
  width: 30vw;
  border: 1px solid #ee5454;
  z-index: 1;
  border-radius: 5%;
}

.menu li {
  margin-bottom: 5%;
  font-size: 1.5rem;
  font-family: monospace;
}

.menu a {
  color: #ee5454;
  display: block;
  padding: 5%;
  width: 65%;
}

.menu a:hover {
  background-color: #4c94f6;
  color: white;
  border-radius: 1rem;
  width: 65%;
}

.menu ul {
  list-style-type: none;
}

.main{
  position: relative;
}



</style>