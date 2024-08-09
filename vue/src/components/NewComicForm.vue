<template>
  <div id="main">
    <div id="loading" v-show="loading">PLEASE WAIT</div>
    <form class="new-comic-form" v-on:submit.prevent="">
      <h2 class="form-title">Search Comics to Add to your Library</h2>
      <input
        name="title-input"
        class="title-input"
        type="text"
        placeholder="Search by comic title"
        v-model="searchString"
      />

      <input type="radio" name="rdoType" id="opt1" value="name" v-model="searchType"/>
      <label for="opt1">Name</label>

      <input type="radio" name="rdoType" id="opt2" value="title" v-model="searchType" checked />
      <label for="opt2">Title</label>

      <input type="radio" name="rdoType" id="opt3" value="upc" v-model="searchType"/>
      <label for="opt3">UPC</label>

      <!-- <input name="issue-input" class="issue-input" type="text" placeholder="Issue" v-model="comic.issue"/>
    <input name="publisher-input" class="publisher-input" type="text" placeholder="Publisher" v-model="comic.publisher" />
    <input name="release-date-input" class="release-date-input" type="text" placeholder="Release Date" v-model="comic.date" />
    <input name="isbn-input" class="isbn-input" type="text" placeholder="ISBN" v-model="comic.isbn" /> -->
      <!-- added method and @click to route back to my-comics -->
      <button class="submit" @click="getComicByTitle">Search</button>
    </form>

    <div id="resultsList">
      <div id="srchResults" v-for="result in searchResults" :key="result.id">
        <h3 id="cTitle">{{ result.title }}</h3>
        <img
          id="srchImage"
          :src="result.thumbnail.path + '.' + result.thumbnail.extension"
          alt="cover"
        />
        <button id="btnResultAdd">Add To Collection/My Comics</button>
      </div>
    </div>
  </div>
</template>

<script>
import comicService from "../services/ComicService";

export default {
  data() {
    return {
      comic: {},
      searchResults: [],
      searchString: "",
      loading: false,
      searchType: 'title',
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
  flex-direction: row;
  flex-wrap: wrap;
  align-content: center;
  justify-content: center;
  display: inline-block;
  margin: auto;
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
  flex-wrap: unset;
  align-content: center;
  justify-content: center;
  display: inline-block;
  margin: auto;
  width: 200px;
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
  width: 33%;
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
  width: 78px;
  height: 100px;
}
</style>