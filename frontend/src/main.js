// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'
import Vuetify from 'vuetify'

// 라우터 객체에 등록할 컴포넌트 불러오기
import Main from './components/Main.vue'
import Login from './components/Login.vue'
import Join from './components/Join.vue'
import Write from './components/Write.vue'

// axios import
import axios from 'axios'
Vue.prototype.$axios = axios

// Vuetify
Vue.use(Vuetify)
import 'vuetify/dist/vuetify.min.css'
// import 'material-design-icons-iconfont/dist/material-design-icons.css'
// import 'babel-polyfill'

Vue.use(VueRouter)

Vue.config.productionTip = false

Vue.prototype.$eventBus = new Vue()

// 사용할 라우터 객체등록
const routes = [
    {name:'main', path:'/', component:Main},
    {name:'login', path:'/user/login', component:Login},
    {name:'join', path:'/user/join', component:Join},
    {name:'write', path:'/user/write', component:Write},
  ]

// 라우터 객체 생성
// 히스토리 모드
const router = new VueRouter({
    // base url, mode 설정
    // mode:'history',
    // base:'/',
    routes
})

/* eslint-disable no-new */
new Vue({
    el:'#app',
    router,
    template:'<App/>',
    components: {
      App
    }
})
