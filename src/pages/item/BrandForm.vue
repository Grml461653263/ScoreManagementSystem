<template>
  <v-form v-model="valid" ref="myBrandForm">
    <v-text-field v-model="brand.name" label="请输入学生姓名" required :rules="nameRules"/>
    <v-text-field v-model="brand.letter" label="请输入学生班级" required :rules="letterRules"/>
    <v-text-field v-model="brand.spe" label="请输入学生专业" required :rules="letterRules"/>
    <v-text-field v-model="brand.source" label="请输入学生成绩" required :rules="sourceRules"/>
    <v-text-field v-model="brand.semester "label="请输入学生学期" required :rules="sourceRules"/>

    <v-layout class="my-4" row>
      <v-spacer/>
      <v-btn @click="submit" color="primary">提交</v-btn>
      <v-btn @click="clear">重置</v-btn>
    </v-layout>
  </v-form>
</template>

<script>
  import InputNumber from "iview/src/components/input-number/input-number";
  export default {
    name: "brand-form",
    components: {InputNumber},
    props: {
      oldBrand: {
        type: Object
      },
      isEdit: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        valid: false, // 表单校验结果标记
        brand: {
          name: '', // 学生姓名
          letter: '', // 科目
          source: '',//学生成绩
          semester:'',
          spe:''
        },
        nameRules: [
          v => !!v || "学生名称不能为空",
          v => v.length > 1 || "名称至少2位"
        ],
        letterRules: [
          v => !!v || "科目不能为空"
        ],
        sourceRules: [
          v => !!v || "成绩不能为空"
        ]
      }
    },
    methods: {
      submit() {
        // 表单校验
        if (this.$refs.myBrandForm.validate()) {
          // 定义一个请求参数对象，通过解构表达式来获取brand中的属性
          const {categories, ...params} = this.brand;
          // 将数据提交到后台
          // this.$http.post('/item/brand', this.$qs.stringify(params))
          this.$http({
            method: this.isEdit ? 'put' : 'post',
            url: '/score/insert',
            data: this.$qs.stringify(params)
          }).then(() => {
            // 关闭窗口
            this.$emit("close");
            this.$message.success("保存成功！");
          })
            .catch(() => {
              this.$message.error("保存失败！");
            });
        }
      },
      clear() {
        // 重置表单
        this.$refs.myBrandForm.reset();
        // 需要手动清空商品分类
        this.categories = [];
      }

    },
    watch: {
      oldBrand: {// 监控oldBrand的变化
        handler(val) {
          if (val) {
            // 注意不要直接复制，否则这边的修改会影响到父组件的数据，copy属性即可
            this.brand = Object.deepCopy(val)
          } else {
            // 为空，初始化brand
            this.brand = {
              name: '',
              letter: '',
              categories: [],
            }
          }
        },
        deep: true
      }
    }
  }
</script>

<style scoped>

</style>
