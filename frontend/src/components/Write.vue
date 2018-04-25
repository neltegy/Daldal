<template>
  <div id="write" style="width:450px; display:inline-block;">
    
      <h1>작성란</h1>
    
      <v-form v-model="valid" ref="form">
        <v-text-field label="구분" v-model="division" :rules="divisionRules"></v-text-field>
        <v-text-field label="월" v-model="month" :rules="monthRules"></v-text-field>
        <v-text-field label="일" v-model="day" :rules="dayRules"></v-text-field>
        <v-text-field label="시작시간" v-model="starttime" :rules="starttimeRules"></v-text-field>
        <v-text-field label="종료시간" v-model="endtime" :rules="endtimeRules"></v-text-field>
        <v-text-field label="인원수" v-model="peopleno" :rules="peoplenoRules"></v-text-field>
        <v-text-field label="비용" v-model="cost" :rules="costRules"></v-text-field>
        <v-text-field label="봉사/헌혈" v-model="volunteer" :rules="volunteerRules"></v-text-field>
        <v-text-field label="시" v-model="city" :rules="cityRules"></v-text-field>
        <v-text-field label="구" v-model="borough" :rules="boroughRules"></v-text-field>
        <v-text-field label="동" v-model="dong" :rules="dongRules"></v-text-field>
        <v-text-field label="반경" v-model="radius" :rules="radiusRules"></v-text-field>
        <v-btn @click="submit" :disabled="!valid">확인</v-btn>
      </v-form>
    <pre>{{$data}}</pre>
  </div>
</template>

<script>
  export default {
    // name:'Write',
    // created () {
    //   this.$eventBus.$emit('Main');
    // },
    data: () => ({
      valid:false,
      division:'연인',
      divisionRules: [

      ],
      month:'12',
      monthRules: [

      ],
      day:'31',
      dayRules: [

      ],
      starttime:'1',
      starttimeRules: [

      ],
      endtime:'13',
      endtimeRules: [

      ],
      peopleno:'20',
      peoplenoRules: [

      ],
      cost:'60000',
      costRules: [

      ],
      volunteer:'volunteer',
      volunteerRules: [

      ],
      city:'서울',
      cityRules: [

      ],
      borough:'은평',
      boroughRules: [

      ],
      dong:'불광',
      dongRules: [

      ],
      radius:'2',
      radiusRules: [

      ]
    }),
    methods: {
      submit () { // 클릭 : 작성 완료
        if(this.$refs.form.validate()) {
          this.$axios.post('/api/user/write', {
            id:'testId',
            division:this.division,
            month:this.month,
            date:this.date,
            day:this.day,
            starttime:this.starttime,
            endtime:this.endtime,
            peopleno:this.peopleno,
            cost:this.cost,
            volunteer:this.volunteer,
            city:this.city,
            borough:this.borough,
            dong:this.dong,
            radius:this.radius
          }).then((response) => {
              console.log('ok')
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
