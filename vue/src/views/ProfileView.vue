<template>
    <h1 class = "header-text">Profile</h1>
    <div id="profile">
        <form class="profile-form" v-on:submit.prevent="">
    
            <input name="first-name-input" class="first-name-input" type="text" placeholder="First Name" />
            <input name="last-name-input" class="last-name-input" type="text" placeholder="Last Name" />
            <input name="email-input" class="email-input" type="text" placeholder="Email" />
            <input name="bio-input" class="bio-input" type="text" placeholder="Biography" />

            <button class= "submit" type="save" >Save</button>

        </form>
    </div>
</template>

<script>
export default {

}
</script>


<style scoped>
.header-text{
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    background-color: rgba(0,0,0,.75);
    width: 33%;
    color: white;
    margin: auto;
    margin-top: 30px;
    padding: 0%;
}

.profile-form{
    padding: 0%;
    margin-left: 35%;
    margin-right: 10%;
    display: flex;
    justify-content: center;
    background-color: rgb(0, 0, 0, .75);
}
.submit{
    margin-right: 30%;
}


</style>