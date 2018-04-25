import Vue from 'vue'
import Router from 'vue-router'
import Vuetify from 'vuetify'

import Main from '@/components/Main'
import Login from '@/components/Login'
import Join from '@/components/Join'
import Write from '@/components/Write'

// axios import
import axios from 'axios'
Vue.prototype.$axios = axios

// Vuetify
Vue.use(Vuetify)
import 'vuetify/dist/vuetify.min.css'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/',
      name:'Main',
      component:Main
    },
    {
      path:'/user/login',
      name:'Login',
      component:Login
    },
    {
      path:'/user/join',
      name:'Join',
      component:Join
    },
    {
      path:'/user/write',
      name:'Write',
      component:Join
    }
  ]
})
