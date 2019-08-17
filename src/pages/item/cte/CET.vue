<template>
  <v-container fluid grid-list-md>
    <v-layout row wrap>
    <v-flex xs19 md12>
      <v-card class="div-c" >

        <div class="div-b">
          <div  class="div-a">
            <div class="div-d"><h3><b>四级总人数</b></h3></div>
            <div class="div-d">{{cet4.cte4_count}}</div>
          </div>
          <div  class="div-a">
            <div class="div-d"><h3><b>通过人数</b></h3></div>
            <div class="div-dd"><font color="#228b22">{{cet4.cte4_left}}</font></div>
          </div >
          <div  class="div-a">
            <div class="div-d"><h3><b>未通过人数</b></h3></div>
            <div class="div-d"><font color="red">{{cet4.cte4_right}}</font></div>
          </div>
          <div  class="div-a">
            <div class="div-d"><h3><b>通过占比</b></h3></div>
            <div class="div-d">{{cet4.cte4_rate}}</div>
          </div>
        </div>

      </v-card>
    </v-flex>
  </v-layout>
    <v-layout row wrap>
      <v-flex xs19 md12>
        <v-card>
          <v-card-text class="px2">
            <div class="content-title" align="center"><font color="#5f9ea0 ">四级历年走势图</font></div>
            <div ref="sale2" style="width: 100%;height:350px"></div>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
    <v-layout row wrap>
      <v-flex xs19 md12>
        <v-card class="div-c" >
          <div class="div-b">
            <div  class="div-a">
              <div class="div-d"><h3><b>六级总人数</b></h3></div>
              <div class="div-d">{{cet6.cte4_count}}</div>
            </div>
            <div  class="div-a">
              <div class="div-d"><h3><b>通过人数</b></h3></div>
              <div class="div-dd"><font color="#228b22">{{cet6.cte4_left}}</font></div>
            </div >
            <div  class="div-a">
              <div class="div-d"><h3><b>未通过人数</b></h3></div>
              <div class="div-d"><font color="red">{{cet6.cte4_right}}</font></div>
            </div>
            <div  class="div-a">
              <div class="div-d"><h3><b>通过占比</b></h3></div>
              <div class="div-d">{{cet6.cte4_rate}}</div>
            </div>
          </div>

        </v-card>
      </v-flex>
    </v-layout>
    <v-layout row wrap>
      <v-flex xs19 md12>
        <v-card>
          <v-card-text class="px2">
            <div class="content-title" align="center"><font color="#5f9ea0 ">六级历年走势图</font></div>
            <div ref="sale2" style="width: 100%;height:350px"></div>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>

</template>

<script>
  var echarts = require('echarts/lib/echarts');
  require('echarts/lib/chart/bar');
  require('echarts/lib/chart/pie');
  require('echarts/lib/chart/line')
    export default {
        name: "CET",
      data() {
          return{
          cet4:{
            cte4_rate: '80%',
            cte4_count:1000,
            cte4_left: 800,
            cte4_right: 200
          },
            cet6:{
              cte4_rate: '80%',
              cte4_count:1000,
              cte4_left: 800,
              cte4_right: 200
            }
          }
      },
      mounted(){

        this.$nextTick(() => {

          var option2 = {
            title : {
              text: '',
              subtext: ''
            },
            tooltip : {
              trigger: 'axis'
            },
            legend: {
              data:['招生数量']
            },
            toolbox: {
              show : true,
              feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
              }
            },
            calculable : true,
            xAxis : [
              {
                type : 'category',
                boundaryGap : false,
                data : ['2012','2013','2014','2015','2016','2017','2018']
              }
            ],
            yAxis : [
              {
                type : 'value',
                axisLabel : {
                  formatter: '{value} '
                }
              }
            ],
            series : [
              {
                name:'学生数量',
                type:'line',
                data:[1100, 1500, 1600, 2000, 2100, 1513, 2600],
                markPoint : {
                  data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                  ]
                },
                markLine : {
                  data : [
                    {type : 'average', name: '平均值'}
                  ]
                }
              }
            ]
          };
          var sale2  = echarts.init(this.$refs.sale2);
          sale2.setOption(option2);
        })
        this.getDataFromServer();

      },
      methods: {

      }
    }
</script>

<style scoped>
  .div-a{ float:left;width:25%;height: auto}
  .div-b{width: 100%;height: 50%}
  .div-d{ float:left;width: 50%;height: auto}
  .div-c{width: 100%;height: 100%}
  .fon {color: black;size: B4}
</style>
