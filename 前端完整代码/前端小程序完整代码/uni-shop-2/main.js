import store from '@/store/store.js'
import wxp from '@/store/wxp.js'; // 修改为实际的路径

// 绑定到 wx 对象，确保 wxp 可用
wx.wxp = wxp;


// 导入网络请求的包
import { $http } from '@escook/request-miniprogram'
uni.$http = $http

// 请求的根路径
$http.baseUrl = 'https://api-hmugo-web.itheima.net'

// 请求拦截器
$http.beforeRequest = function(options){
  uni.showLoading({
    title: '数据加载中...',
  })
  //判断当前是否是有权限的接口
  if(options.url.indexOf('/my') !== -1){
    options.header = {
      Authorization : store.state.m_user.token
    }
  }
}

// 相应拦截器
$http.afterRequest = function(){
  uni.hideLoading()
}

//封装请求失败弹框的方法
uni.$showMsg = function(title = '数据请求失败！', duration = 1500){
  uni.showToast({
    title,
    duration,
    icon: 'none'
  });
};

// #ifdef VUE3
import { createSSRApp } from 'vue'
import App from './App.vue'

export function createApp() {
  const app = createSSRApp(App)
  
  // 设置全局变量 $httpsctl
  app.config.globalProperties.$httpsctl = 'http://yqiwhh.natappfree.cc'

  app.use(store)
  
  return {
    app
  }
}
// #endif

