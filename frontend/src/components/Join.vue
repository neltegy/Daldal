<template>
  <div id="join" style="width:450px; display:inline-block;" data-app>
    <br></br>
      <h1>회원가입</h1>
    <br></br>
      <v-form v-model="valid" ref="form">
        <v-text-field label="이메일 (example@gmail.com)" v-model="email" :rules="emailRules"></v-text-field>
        <v-text-field label="아이디 (8~14자리(영문,숫자))" ref= "id" v-model="id" :rules="idRules" :counter="14"></v-text-field>
        <v-btn outline @click="checkid">중복체크</v-btn>
        <v-text-field label="닉네임 (2~8자리(영문 OR 한글))" v-model="nickname" :rules="nicknameRules" :counter="8"></v-text-field>
        <v-text-field label="비밀번호 (8~14자리(영문,숫자,특수문자))" type="password" v-model="pw" :rules="pwRules" :counter="14"></v-text-field>
        <v-text-field label="비밀번호 확인" v-model="validpw" :rules="pwConfirmRule"></v-text-field>
        <v-slider label="몇 년생 선택 (나이)" min="1930" max="2018" track-color="black" thumb-label thumb-color="black" v-model="age" :value="age" :rules="ageRules"></v-slider>
        <v-btn @click="join" :disabled="!valid">확인</v-btn>
      </v-form>
    <pre>{{$data}}</pre>
  </div>
</template>


<script>
  export default {
    data: () => ({
         valid:false,
         email:'',
         emailRules: [
           v => !!v || '이메일을 작성해주세요.',
           v => /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/.test(v) || '이메일형식에 맞게 입력해주세요.'
         ],
         id:'',
         idRules: [
            v => !!v || '아이디를 작성해주세요.',
            v => v.length <= 14 || '8~14자리를 입력해주세요.'
         ],
         nickname:'',
         nicknameRules: [
           v => !!v || '닉네임을 작성해주세요.',
           v => v.length >= 3 || '닉네임이 너무 짧습니다.',
           v => v.length <= 8 || '2~8자리를 입력해주세요.',
           v => /^[a-zA-Z_가-힣ㄱ-ㅎㅏ-ㅣ]{2,8}$/.test(v) || '특수문자는 사용할 수 없습니다.'
         ],
         pw:'',
         pwRules: [
           v => !!v || '비밀번호를 작성해주세요.',
           v => v.length <= 14 || '8~14자리를 입력해주세요.',
           v => /\W/.test(v) || '특수문자가 하나이상 포함되어야합니다.',
           v => /[a-zA-Z]/.test(v) || '문자가 하나이상 포함되어야합니다.'
         ],
         validpw:'',
         pwConfirmRule: [
           v => !!v || '비밀번호를 확인해주세요.',
           v => v == document.forms[0][5]._value || '비밀번호가 다릅니다.'
         ],
         age:0,
         ageRules: [

         ]
       }),
      methods: {
        join () { // 클릭 : 회원가입 완료
          if (this.$refs.form.validate()) {
            this.$axios.post('/api/user/join', {
              email:this.email,
              id:this.id,
              nickname:this.nickname,
              pw:this.pw,
              age:this.age
            })
          }
        },
        checkid () { // 아이디 중복체크
          console.log(this.joinidcheck)
          if(this.$refs.id.validate()) {
            this.$axios.post('/api/user/overlap', {
              joinidcheck:this.id
            }).then((response) => {
                console.log('join')
                this.result = response.data
                console.log(this.result)
            })
          }
        }
      }
    }
</script>

<style lang="css">

</style>
