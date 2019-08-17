var menus = [
  {
    action: "home",
    title: "首页",
    path:"/index",
    items: [{ title: "学院统计", path: "/dashboard" }]
  },
  {
    action: "apps",
    title: "电信学院",
    path:"/it",
    items: [
      { title: "计算机科学与技术", path: "/telecom" },
      { title: "计算机网络", path: "/network" },
      { title: "电气", path: "/massage" }
    ]
  },
  {
    action: "people",
    title: "会计学院",
    path:"/accountant",
    items: [
      { title: "会计", path: "/accountant" },

    ]
  },
  {
    action: "attach_money",
    title: "商贸学院",
    path:"/consult",
    items: [
      { title: "服装", path: "/consult" }
    ]
  },
  {
    action: "apps",
    title: "四六级",
    path:"/cet",
    items: [
     
      { title: "四级成绩", path: "/cet4" },
      { title: "六级成绩", path: "/cet6" }
    ]
  },
  {
    action: "people",
    title: "学生信息管理",
    path:"/student",
    items: [

      { title: "学生信息", path: "/student" },

    ]
  }
]

export default menus;
