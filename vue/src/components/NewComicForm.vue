<template>
  <div id="main">
    <div id="loading" v-show="loading">
      <img src="../assets/spiderman-loading.gif" alt="loading" class="spidey"/>
      <!-- <img src="../assets/avengersTower.png" alt="" class="tower"> -->
    </div>
    <form class="new-comic-form" v-on:submit.prevent="">
      <h2 class="form-title">Search Comics</h2>
      <input
        name="title-input"
        class="title-input"
        type="text"
        placeholder="Enter search terms"
        v-model="searchString"
      />

      <div id="radio-buttons">
          <div id="radio-name">
              <input type="radio" name="rdoType" id="opt1" value="name" v-model="searchTypes" checked />
             <label for="opt1"> Character </label>
          </div>

          <div id="radio-title">
             <input type="radio" name="rdoType" id="opt2" value="title" v-model="searchTypes"/>
             <label for="opt2"> Title </label>
          </div>

          <div id = "radio-upc">
              <input type="radio" name="rdoType" id="opt3" value="upc" v-model="searchTypes"/>
             <label for="opt3"> UPC</label>
         </div>
        </div>
      <button class="submit" @click="getComicBySearchQuery">Search</button>
    </form>

    <div id="resultsList">
      <div id="srchResults" v-for="result in searchResults" :key="result.id">
        <h3 id="cTitle">{{ result.title }}</h3>
        <h3 id="cName">{{ result.name }}</h3>
        <img
          id="srchImage"
          :src="result.thumbnail.path + '.' + result.thumbnail.extension"
          alt="cover"
        />
        <div class = "buttons">
          <button id="btn" class="searchResultActionBtn" @click="addComicToLibrary(collectionId, result)">Add To Collection</button>
        </div>
      </div>

    </div>

  </div>
</template>

<script>
import comicService from "../services/ComicService";
import collectionService from "../services/CollectionService";

export default {

  data() {
    return {
      comic: {},
      searchResults: [],
      searchString: "",
      loading: false,
      searchTypes: ['name', 'title', 'upc']
    };
  },

  props: {
    collectionId: {
      type: Number,
      required: false,
    },
  },

  methods: {
    goToMyComics() {
      this.$router.push("/my-comics");
    },

    getComicByTitle() {
      this.loading = true;

      comicService.getComicByTitle(this.searchString).then((response) => {
        this.searchResults = response.data;
        this.loading = false;
      });
    },

    getComicByUPC() {
      this.loading = true;

      comicService.getComicByUPC(this.searchString).then((response) => {
        this.searchResults = response.data;
        this.loading = false;
      });
    },

    getComicByCharacter() {
      this.loading = true;

      comicService.getComicByCharacter(this.searchString).then((response) => {
        this.searchResults = response.data;
        this.loading = false;
      });
    },

    getComicBySearchQuery(){
      this.loading = true;

      if(this.searchTypes === 'name'){
        this.getComicByCharacter();
      } else if(this.searchTypes === 'title'){
        this.getComicByTitle();
      } else if(this.searchTypes === 'upc'){
        this.getComicByUPC();
      }

    },

    addComicToLibrary(collectionId, comic) {
      comicService.addComicToLibrary(collectionId, comic)
        .then((response) => {
          console.log("Comic added successfully:", response.data)
          this.$router.push({ name: 'view-collection', params: { id: collectionId } });
      });
    },

    addComicToCollection(comic, collectionId) {
      collectionService.addComicToCollection(comic, collectionId).then((response) => {
        this.$router.push("/my-collections");
      });
    },

    toggleLoad() {
      this.loading = !this.loading;
    },
  },
};
</script>

<style scoped>
#main {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  align-content: center;
  background-color: transparent;
}



#resultsList {
  display: flex;
  flex-wrap: wrap;
  gap: 1.8rem;
  justify-content: center;
  padding: 8%;
}

input[type="text"] {
  padding: 12px 40px;
  display: flex;
}

input[type="radio"] {
  padding: 12px 20px;
  margin: auto;
}

#srchResults {
  border: 3px solid #4c94f6;
  border-radius: 10px;
  width: 250px;
  height: 450px;
  background-color: white;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between; 
  padding: 12px;    
  overflow: hidden;
  position: relative;
}

#srchResults:hover #srchImage{
  opacity: .6;
}

#srchResults:hover .buttons{
  opacity: 1;
}

#srchResults h3 {
  text-align: center;
}

#srchResults button {
  margin:auto;
  margin-bottom: 10px;
}

.new-comic-form {
  /* display: flex; */
  justify-content: center;
  align-content: center;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 30px;
  z-index: 1;
}

.form-title {
  font-family: monospace;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  border-radius: 5px;
  padding: 15px;
  margin: 10px;
  width: 100%;
  background-color: #4c94f6;
  color: white;
  text-align: center;
  margin-left: 0%;
  margin-top: 2%;
}

.submit {
  
  border-radius: 10%;
  margin: auto;
  background-color: #4c94f6;
  font-family: monospace;
  padding: 1%;
}

#srchImage {
  width: 100%;
  height: 70%;
  transition: opacity 0.3s ease-in-out;
}


input[name="title-input"] {
  width: 100%;
}

#radio-buttons {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  padding-top: 1%;
  padding-bottom: 1%;
}

#btn {
  background-color: #4c94f6;
  color: white;
  font-family: monospace;
  border: none;
  padding: 12px;
  transition: background-color 0.3s ease, transform 0.3s ease;
  border-radius: 5px;
  opacity: 1;
  z-index: 1;
  cursor: pointer;
} 

#cUPC{
  font-size: 0.8rem;
}
#cTitle{
  padding: 0%;
}

.buttons{
  display: flex;
  flex-direction: column;
  opacity: 0;
  position: absolute;
  top: 50%;
  cursor: pointer;
}







</style>