<template>

    <form class="new-collection-form" v-on:submit.prevent="">
    
        <h2 class="form-title">Create a Collection</h2>
        <input name="name-input" class="name-input" type="text" placeholder="Collection Name" v-model="collection.name" />
        <button class= "submit" type="submit">Create My Collection</button>
    
    </form>
    
    </template>
    
    <script>
    export default {
        data() {
            return {
                collection: {
                    name: '',
                }
            }
        }
    
    }
    </script>
    
    <style>
    .new-collection-form {
        display: flex;
        justify-content: center;
        align-content: center ;
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2C3E50;
        margin: 30px;
    }
    
    .form-title{
        background-color: rgba(0,0,0,.5);
        width: 33%;
        color: white;
        margin: auto;
        padding: 2%;
        font-size: 1rem;
    }
    
    .submit{
        margin-left: 1%;
        padding: 2%;
    }
    
    
    
    </style>