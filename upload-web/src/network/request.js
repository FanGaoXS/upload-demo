// 引入axios
import Axios from "axios";

function testRequest(config) {
  // 创建axios实例，配置baseURL
  let axiosInstance = Axios.create({
    baseURL: 'http://123.207.32.32:8000',
    timeout: 5000
  });
  // response拦截器，过滤data
  axiosInstance.interceptors.response.use(res => {
    return res.data;
  },error => {
    console.log(error)
  })
  return axiosInstance(config);
}

// 本地request测试
function localRequest(config) {
  // 创建axios实例，配置baseURL
  let axiosInstance = Axios.create({
    baseURL: 'http://127.0.0.1:8089',
    timeout: 5000
  });
  // response拦截器，过滤data
  axiosInstance.interceptors.response.use(res => {
    console.log('interceptors.response.onFulfilled->',res);
    return res.data;
  },error => {
    console.log('interceptors.response.onRejected->',error);
    throw error;
  });
  return axiosInstance(config);
}
export {
  testRequest,
  localRequest
}