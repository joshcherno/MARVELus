<template>

    <form class="new-collection-form" v-on:submit.prevent="">
    
        <h2 class="form-title">Give your collection a name!</h2>
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
    
    <style>
    .new-collection-form {
        display: flex;
        justify-content: center;
        align-content: center;
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        text-align: center;
        color: #2C3E50;
        margin: 10px;
        width: 75%;
        background-color: rgba(0,0,0,.75);
    }
    
    .form-title{
        
        color: white;
        padding: 1rem;
        font-size: 1rem;

    }

    .name-input{
        margin: 1rem;
        padding: 1rem;
        width: 33%;
    }
    
    .submit{
        padding: 1%;
        margin: 2%;
        cursor: pointer;
    }
    
    
    
    </style>