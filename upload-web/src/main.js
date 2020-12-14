import Vue from 'vue'
import App from './App.vue'


// 引入elementUI相关并使用
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

// 引入自定义键盘相关
import InputCar from 'input-number-plate'
import 'input-number-plate/lib/inputCar.css'
Vue.use(InputCar);

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
