<template>

    <form class="new-collection-form" v-on:submit.prevent="">
    
        <h2 class="form-title">Enter collection name here:</h2>
        <input name="name-input" class="name-input" type="text" placeholder="Collection Name" v-model="collection.collectionName" />
        <button class= "submit" type="submit" @click="createCollection(collection)">CREATE</button>
    
    </form>
    
    </template>
    
    <script>
    import collectionService from '../services/CollectionService'
    export default {
        data() {
            return {
                collection: {

                    // collectionId : '',
                    // comics: [],
                    collectionName: '',
                    description: '',
                    userId: ''
                }
            }
        },
        computed:{
            user_id(){
                return this.$store.state.user.id;
            }
        },
        methods: {
            createCollection(collection){
                console.log('Collection being sent:', this.collection);
                collectionService.addCollection(this.collection).then(() => {
                    this.$router.push({ name: 'my-collections' });
                });
            },
            
        }
    
    }
    </script>
    
    <style scoped>
    .new-collection-form {
        display: flex;
        justify-content: center;
        align-content: center;
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        color: #2C3E50;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        margin: 30px;
    }
    
    .form-title{
        
        color: white;
        background-color: #2C3E50;
        padding: 1rem;
        font-size: 1rem;

    }

    .name-input{
        margin: 1rem;
        padding: 1rem;
        width: 33%;
    }
    
    .submit{
        padding-right: 4%;
        padding-left: 4%;
        border-radius: 10%;
        margin: auto;
        background-color: #4c94f6;
        color: white;
        font-family: monospace;
        border: none;
        width: 10;
        height: 40px;
        transition: background-color 0.3s ease, transform 0.3s ease;
        border-radius: 5px;
        cursor: pointer;
    }
    
    
    
    </style>