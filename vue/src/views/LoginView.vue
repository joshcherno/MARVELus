<template>
  <div id="login">
    <form v-on:submit.prevent="login">
      <h1 >Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password </label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit" @click="login">Sign in</button> 
      <p>
      <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import AppHeaderVue from "../components/AppHeader.vue";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>


.form-input-group {
  margin-bottom: 1rem;
}

label {
  margin-right: 0.5rem;
}

button {
  margin: auto;
  background-color: lightblue;
  margin-bottom: 50px;
  display: flex;
  justify-content: center;
  align-content: center;
}

#login {
  display: flex;
  align-content: center;
  justify-content: center;
  background-color: rgba(0,0,0,.5);       /* added a faded background to help the login standout */
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;      /* set font style for whole page */
  color: white;
  margin: 15%;
}

h1 {
  color: white;
  text-align: center;
  font-size: 50px;
  margin-bottom: 50px;
}

p {
  color: white;
  text-align: center;
}


</style>