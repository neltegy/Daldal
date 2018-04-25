<template>
  <div class="main">
    <br></br>
    <h1>{{msg}}</h1>
    <br></br>
  </div>
</template>

<script>
  export default {
    name:'main',
    data() {
      return {
        msg:'지역검색'
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1 {
    font-weight:normal;
    color:#d380f0;
  }
</style>
