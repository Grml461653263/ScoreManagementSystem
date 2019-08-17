import Vue from 'vue'
import Router from 'vue-router'


Vue.use(Router)

function route (path, file, name, children) {
  return {
    exact: true,
    path,
    name,
    children,
    component: () => import('../pages' + file)
}
}

export default new Router({
  routes: [
    route("/login",'/Login',"Login"),// /login路径，路由到登录组件
    {
      path:"/", // 根路径，路由到 Layout组件
      component: () => import('../pages/Layout'),
    redirect:"/login",
  children:[ // 其它所有组件都是 Layout的子组件
  route("/index/dashboard","/Dashboard","Dashboard"),
  route("/item/category",'/item/Category',"Category"),
  route("/it/brand",'/item/Brand',"Brand"),
  route("/it/telecom",'/item/telecom/Telecom',"Telecom"),
  route("/accountant/accountant",'/item/accountant/Accountant',"Accountant"),
  route("/consult/consult",'/item/consult/Consult',"Consult"),
  route("/it/massage",'/item/telecom/Message',"Message"),
  route("/it/network",'/item/telecom/Network',"Network"),
  route("/cet/cet4",'/item/cte/CET4',"CET4"),
  route("/cet/cet6",'/item/cte/CET6',"CET6"),
  route("/cet/cet",'/item/cte/CET',"CET"),
  route("/student/student",'/item/student/Student',"Student")

]
}
]
})
