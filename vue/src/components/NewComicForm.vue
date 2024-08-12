<template>
  <div id="main">
    <div id="loading" v-show="loading">
      <img src="../assets/spiderman-loading.gif" alt="loading" />
    </div>
    <form class="new-comic-form" v-on:submit.prevent="">
      <h2 class="form-title">Search Comics to Add to your Library</h2>
      <input
        name="title-input"
        class="title-input"
        type="text"
        placeholder="Enter search terms"
        v-model="searchString"
      />

      <div id="radio-buttons">
          <div id="radio-name">
              <input type="radio" name="rdoType" id="opt1" value="name" v-model="searchTypes"/>
             <label for="opt1"> Character </label>
          </div>

          <div id="radio-title">
             <input type="radio" name="rdoType" id="opt2" value="title" v-model="searchTypes" checked />
             <label for="opt2"> Title </label>
          </div>

          <div id = "radio-upc">
              <input type="radio" name="rdoType" id="opt3" value="upc" v-model="searchTypes"/>
             <label for="opt3"> UPC</label>
         </div>
        </div>

      <!-- <input name="issue-input" class="issue-input" type="text" placeholder="Issue" v-model="comic.issue"/>
    <input name="publisher-input" class="publisher-input" type="text" placeholder="Publisher" v-model="comic.publisher" />
    <input name="release-date-input" class="release-date-input" type="text" placeholder="Release Date" v-model="comic.date" />
    <input name="isbn-input" class="isbn-input" type="text" placeholder="ISBN" v-model="comic.isbn" /> -->
      <!-- added method and @click to route back to my-comics -->
      <button class="submit" @click="getComicBySearchQuery">Search</button>
    </form>

    <div id="resultsList">
      <div id="srchResults" v-for="result in searchResults" :key="result.id">
        <h3 id="cTitle">{{ result.title }}</h3>
        <h3 id="cName">{{ result.name }}</h3>
        <h3 id="cUPC">{{ result.upc }}</h3>
        <img
          id="srchImage"
          :src="result.thumbnail.path + '.' + result.thumbnail.extension"
          alt="cover"
        />
        <button id="btnResultAdd" class = "searchResultActionBtn">Add To Collection</button>
        <button id="btnAddToComics" class = "searchResultActionBtn" @click="addComicToLibrary(comic)">Add To My Comics</button>
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
      // searchType: 'title',
      searchTypes: ['name', 'title', 'upc']
    };
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

    addComicToLibrary(comic) {
      comicService.addComicToLibrary(comic).then((response) => {
        this.$router.push("/my-comics");
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
  flex-direction: column;
  flex-wrap: wrap;
  align-content: center;
  justify-content: center;
  display: inline-block;
  margin: auto;
  margin-top: 10%;
  margin-left: 10%;

}

input[type="text"] {
  width: 50%;
  padding: 12px 20px;
  margin: auto;
  display: block;
}

input[type="radio"] {
  padding: 12px 20px;
  margin: auto;
}

#srchResults {
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-content: center;
  display: inline-block;
  margin: auto;
    border: 3px solid #4c94f6;
    border-radius: 10px;
    width: 250px;
    height: 500px;
    background-color: white;
  
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
}

.form-title {
  background-color: rgba(0, 0, 0, 0.5);
  width: 100%;
  color: white;
  margin: auto;
  padding: 2%;
  font-size: 1rem;
}

.submit {
  margin-left: 1%;
  padding: 2%;
}

#srchImage {
  width: 250px;
  height: 300px;
}

input[name="title-input"] {
  width: 100%;
}

#radio-buttons {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  padding: 2%;
}

#btnAddToComics{
  background-color: #2c3e50;
  color: white;
  padding: 2%;
  margin-top: 2%;
}

#btnResultAdd {
  background-color: #2c3e50;
  color: white;
  padding: 2%;
  margin-top: 2%;
} 

.searchResultActionBtn {
  display: flex;
  flex-direction: column;
  
}




</style>