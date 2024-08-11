
<template>

    <header>
      <router-link id="header-home-router" :to="{ name: 'home' }">
      <h1>MARVELus</h1>
      </router-link>
        <div id="nav">
            <button class="hamburger" @click="toggleMenu">
               <div class="line" :class="{'line1' : menuOpen}"></div>
                <div class="line" :class="{'line2' : menuOpen}"></div>
                <div class="line" :class="{'line3' : menuOpen}"></div>
            </button>

         <nav v-if="menuOpen" class="menu">
           <ul>
            <li>
             <div @click="toggleMenu"><router-link to="/">Home</router-link></div>
              </li>
            <li>
              <div @click="toggleMenu"><router-link to="/my-comics" >My Comics</router-link></div>
            </li>
            <li>
              <div @click="toggleMenu"><router-link to="/my-collections" >My Collections</router-link></div>
            </li>
            <li>
              <div @click="toggleMenu"><router-link to="/profile">Profile</router-link></div>
            </li>
          
           </ul>
          </nav>

              <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
              <router-link v-bind:to="{ name: 'my-comics' }">My Comics</router-link>&nbsp;|&nbsp;
              <router-link v-bind:to="{ name: 'my-collections' }">My Collections</router-link>&nbsp;|&nbsp;
              TODO: Add a router link to a Profile view 
              <router-link class="profile" v-bind:to="{ name: 'profile' }"><img class="profile-img" v-bind:src="'src/assets/ProfileImage.jpg'" alt="profile"></router-link>   -->
      </div>
    </header>

  <body>    
  </body>    

</template>

<script>
export default {

  data(){
    return{
      menuOpen: false
    };
  },
  methods: {
    toggleMenu() {
      this.menuOpen = !this.menuOpen;
    },
  }

}
</script>

<style>

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
  width: 30px;
  height: 30px;

}

.line{
  width: 2rem;
  height: 4px;
  background-color: #ee5454;
  margin: 8px;
  transition: all 1s ease;
}

#nav {
    font-size: 1rem;    
}

h1 {
  margin-top: 0px;
  margin-bottom: 0px;
}

.profile{
  position: fixed;
  top: 0;
  right: 0;
  padding: 5%;
  width: 1%;
  height: 1%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: white;
  border: none;
}

.profile-img{
  width: 50px;
  height: 50px;
  border-radius: 50%;
}

a {
  text-decoration: none;
  color: #ee5454;
}


.line1 {
  transform: rotate(45deg) translate(12px,12px);
  top: 0px;
}

.line2 {
  opacity: 0;
}

.line3 {
  transform: rotate(-45deg) translate(5px, -5px);
}

.menu {
  position: absolute;
  top: 30px;
  left: 5px;
  background-color: rgb(228, 223, 223, .95);
  height: 50vh;
  width: 25vw;
  border: 1px solid #ee5454;
  z-index: 1;
  border-radius: 5%;
}

.menu li {
  margin-bottom: 15%;
  font-size: 1.8rem;
  font-family: monospace;
}

.menu a {
  color: #ee5454;
  display: block;
  padding: 5%;
  width: 65%;
}

.menu a:hover{
  background-color:#4c94f6;
  color: white;
  border-radius: 100%;
}

.menu ul {
  list-style-type: none;
}


</style>