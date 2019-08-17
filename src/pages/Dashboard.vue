<template>
  <v-container fluid grid-list-md>
    <v-layout row wrap>

      <v-flex xs10 md6>
        <v-card >
          <v-card-text class="px2">
            <div class="content-title" align="center"><font color="#5f9ea0 ">学院历年招生</font></div>
            <div ref="sale2" style="width: 100%;height:350px"></div>
          </v-card-text>
        </v-card>
      </v-flex>
      <v-flex xs10 md6>
        <v-card >
          <v-card-text class="px2">
            <div class="content-title" align="center"><font color="#5f9ea0 ">学院学生分布对比</font></div>
            <div ref="pie" style="width: 100%;height:350px"></div>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
    <v-layout row wrap>
      <v-flex xs10 md6>
        <v-card>
          <v-card-text class="px2">
            <div class="content-title" align="center"><font color="#5f9ea0 ">学院各科成绩对比</font></div>
            <div ref="sale1" style="width: 100%;height:350px"></div>
          </v-card-text>
        </v-card>
      </v-flex>
      <v-flex xs10 md6>
        <v-card>
          <v-card-text class="px2">
            <div class="content-title" align="center"><font color="#5f9ea0 ">学院学分平均值对比</font></div>
            <div ref="sale" style="width: 100%;height:350px"></div>
          </v-card-text>
        </v-card>
      </v-flex>

    </v-layout>

  </v-container>
</template>

<script>
  // 引入 ECharts 主模块

  var echarts = require('echarts/lib/echarts');
  require('echarts/lib/chart/bar');
  require('echarts/lib/chart/pie');
  require('echarts/lib/chart/line')



  export default {
    name: "dashboard",

    data(){
      return {
        collegeList: ["电信学院", "商贸学院", "会计学院"],
        sourceList: [30.0, 17.5, 17.0],
        collegeAndStudent: [{
          "name": "会计学院",
          "value": 7
        }, {
          "name": "商贸学院",
          "value": 5
        }, {
          "name": "电信学院",
          "value": 4
        }],
        timeList: [],
        studentList: []


      }
    },

    mounted(){

      this.$nextTick(() => {
        var sale  = echarts.init(this.$refs.sale);

        // 指定图表的配置项和数据
        var option = {
          title: {
            text: '学院学分平均值对比'
          },
          tooltip: {},
          legend: {
            data:['成绩']
          },
          xAxis: {
            data: this.collegeList
          },
          yAxis: {},
          series: [{
            name: '学分',
            type: 'bar',
            data: this.sourceList
          }]
        };

        // 使用刚指定的配置项和数据显示图表。
        sale.setOption(option);

        const pie = echarts.init(this.$refs.pie);

        pie.setOption({
          roseType: 'angle',
          title: {
            text: '学院学生分布对比'
          },
          series : [
            {
              name: '访问来源',
              type: 'pie',
              radius: '55%',
              data:this.collegeAndStudent
            }
          ],
          itemStyle: {
            emphasis: {
              // 阴影的大小
              shadowBlur: 200,
              // 阴影水平方向上的偏移
              shadowOffsetX: 0,
              // 阴影垂直方向上的偏移
              shadowOffsetY: 0,
              // 阴影颜色
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          }
        })

        var option1 = {
          title : {
            text: '各学院各科成绩对比',
            subtext: ''
          },
          tooltip : {
            trigger: 'axis'
          },
          legend: {
            data:['电信学院','会计学院',"商贸学院"]
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
              data : ['大英','高数','政治','电子商务','体育']
            }
          ],
          yAxis : [
            {
              type : 'value'
            }
          ],
          series : [
            {
              name:'电信学院',
              type:'bar',
              data:[2.0, 4.9, 7.0, 23.2, 25.6],

            },
            {
              name:'会计学院',
              type:'bar',
              data:[2.6, 5.9, 9.0, 26.4, 28.7],

            }
            ,
        {
              name:'商贸学院',
              type:'bar',
              data:[2.6, 5.9, 9.0, 26.4, 28.7],


            }
          ]
        };

        var sale1  = echarts.init(this.$refs.sale1);
        sale1.setOption(option1);

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
    methods:{
      getDataFromServer() { // 从服务的加载数的方法。
        // 发起请求
        var that = this;
        this.$http.post("/college/info").then(resp => { // 这里使用箭头函数
          this.collegeList = resp.data.college;
          this.sourceList = resp.data.list;
          this.collegeAndStudent = resp.data.studentAndCollege;
          this.$nextTick(() => {
            var sale  = echarts.init(this.$refs.sale);

            // 指定图表的配置项和数据
            var option = {
              title: {
                text: '学院学分平均值对比'
              },
              tooltip: {},
              legend: {
                data:['成绩']
              },
              xAxis: {
                data: this.collegeList
              },
              yAxis: {},
              series: [{
                name: '学分',
                type: 'bar',
                data: this.sourceList
              }]
            };

            // 使用刚指定的配置项和数据显示图表。
            sale.setOption(option);

            const pie = echarts.init(this.$refs.pie);

            pie.setOption({
              roseType: 'angle',
              title: {
                text: '学院学生分布对比'
              },
              series : [
                {
                  name: '访问来源',
                  type: 'pie',
                  radius: '55%',
                  data:this.collegeAndStudent
                }
              ],
              itemStyle: {
                emphasis: {
                  // 阴影的大小
                  shadowBlur: 200,
                  // 阴影水平方向上的偏移
                  shadowOffsetX: 0,
                  // 阴影垂直方向上的偏移
                  shadowOffsetY: 0,
                  // 阴影颜色
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              }
            })
          })

        })
        this.$http.post("/college/stu").then(resp =>{
          this.timeList = resp.data.times;
          this.studentList = resp.data.students;
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
                  data : this.timeList
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
                  data:this.studentList,
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
        })
      }

    }
  }
</script>

<style scoped>

</style>
