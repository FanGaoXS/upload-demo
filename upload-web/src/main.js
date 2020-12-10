import Vue from 'vue'
import App from './App.vue'
// 引入elementUI
import ElementUI from 'element-ui';
// 引入elementUI的样式
import 'element-ui/lib/theme-chalk/index.css';
// 利用Vue的use方法全局使用elementUI
Vue.use(ElementUI);

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
