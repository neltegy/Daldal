<template>
  <div id="app" class="container">
      <ul class="userArea clf">
        <li><router-link :to="{name:'login'}" class="loginBtn">로그인</router-link></li>
        <li><router-link :to="{name:'join'}" class="joinBtn">회원가입</router-link></li>
      </ul>
    <div class="visual">
      <br></br>
      <router-link :to="{name:'main'}" class="logo"><img class="logo" src="./assets/logo.png"></router-link>
      <br></br>
    </div>
    <div class="contents">
      <!-- <ul class="nav nav-tabs">
        <li><router-link :to="{name:''}" exac>코스추천받기</router-link></li>
        <li><router-link :to="{name:''}">추천코스</router-link><li>
        <li><router-link :to="{name:''}">My코스</router-link></li>
      </ul> -->
      <transition name="fade">
        <router-view></router-view>
      </transition>
    </div>
  </div>
</template>

<script>
  export default {
    name:'app',
    components: {

    }
  }
</script>

<style>
/* font */
@import url('https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Poor+Story');

/* reset */
html, body {width:100%; height:100%}
body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,form,fieldset,p,button {margin:0;padding:0}
a {text-decoration:none; cursor:default}
img {vertical-align:top}
i,em,address {font-style:normal}
label,button {cursor:pointer}
button {margin:0;padding:0}
img,fieldset,iframe {border:0 none}
li {list-style:none}
input,select,button {vertical-align:middle}
hr{display:none}
legend{*width:0}
table{border-collapse:collapse;border-spacing:0}
input {outline-style:none}
input::-ms-clear{display:none}
.clf:after {content:""; display:block; clear:both}

/* userArea */
html {font-family:'Poor Story' !important}
body {background:#ffffff; font-family:'Poor Story' !important}
.logo {cursor:pointer}
.userArea {position:absolute; top:50px; right:100px}
.userArea li {float:left; margin-right:50px}
.userArea li > a {padding:10px 30px; border-radius:20px; color:#ffffff !important; text-decoration:none !important; display:block; cursor:pointer; font:20px 'Poor Story', sans-serif}
.userArea li:first-child > a {background:#f19999}
.userArea li:last-child {margin-right:0}
.userArea li:last-child > a {background:#b771d9}

/* contents */
.container {width:100%; margin-top:0 !important; padding:0}
.visual {background:#f0d4eb; width:100% !important}
.contents {background:#ffffff; width:100% !important}

/* registerform size */
.inputForm {width:20%; margin:0 auto}

#app {
  -webkit-font-smoothing:antialiased;
  -moz-osx-font-smoothing:grayscale;
  text-align:center;
  color:#e05d80;
  margin-top:80px;
}
.router-link-active {
  color:#000000
}
.fade-enter {
  opacity:0
}
.fade-enter-active {
  transition:opacity 1s
}
</style>
