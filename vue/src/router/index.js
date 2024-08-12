import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import MyComicsView from '../views/MyComicsView.vue';
import MyCollectionsView from '../views/MyCollectionsView.vue';
import AddComicView from '../views/AddComicView.vue';
import CreateCollectionView from '../views/CreateCollectionView.vue';
import ProfileView from '../views/ProfileView.vue';
import ViewCollectionView from '../views/ViewCollectionView.vue';

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: false 
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/my-comics",
    name: "my-comics",
    component: MyComicsView,
    meta: {
    //TODO: eventually we need to make this true and require authentication for access to MyComicsView
      requiresAuth: false
    }
  },
  {
    path:"/my-collections",
    name: "my-collections",
    component: MyCollectionsView,
    meta: {
    //TODO: eventually we need to make this true and require authentication for access to MyComicsView
    requiresAuth: false
    }
  },
  {
    path: "/add-comic",
    name: "add-comic",
    component: AddComicView,
    meta: {
    //TODO: eventually we need to make this true and require authentication for access to MyComicsView
      requiresAuth: false
    }
  
  },
  {
    path: "/create-collection",
    name: "create-collection",
    component: CreateCollectionView,
    meta: {
    //TODO: eventually we need to make this true and require authentication for access to MyComicsView
      requiresAuth: false
    }
  },
  {
    path: "/profile",
    name: "profile",
    component: ProfileView,
    //TODO: eventually we need to make this true and require authentication for access to MyComicsView
    requiresAuth: false
  },
  {
    path: "/collections/:id",
    name: "view-collection",
    component: ViewCollectionView,
  }
];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
