import {
  testRequest,
  localRequest
} from "./request";

// 向后端上传图片
function uploadImg() {
  let config={
    url: '/home/multidata'
  }
  return testRequest(config);
}

function localUpload(param,formItem) {
  // 创建form表单对象用于向后端传递数据（POST提交）
  let uploadData = new FormData();
  // 将图片文件添加到form对象里
  uploadData.append('file', param.file);
  // 将chipId（芯片编号）添加到form对象里
  uploadData.append('chipId', formItem.chipId);
  // 将plateNumber（车牌号）添加到form对象里
  uploadData.append('plateNumber', formItem.plateNumber);
  // 将driverName（驾驶员性名）添加到form对象里
  uploadData.append('driverName', formItem.driverName);
  console.log('准备上传的文件->',uploadData.get('file'));
  console.log('准备上传的芯片编号->',uploadData.get('chipId'));
  console.log('准备上传的车牌号->',uploadData.get('plateNumber'));
  console.log('准备上传的驾驶员姓名->',uploadData.get('driverName'));
  let config={
    url: '/car/uploadImg',
    method: 'POST',
    headers: {
      'Content-Type': 'multipart/form-data'
    },
    data:uploadData
  }
  return localRequest(config);
}

// 利用本地服务器提交车辆信息
function localUploadCar(formItem) {
  console.log(formItem);
  let config={
    url: '/car/upload',
    method: 'GET',
    params: {
      chipId: formItem.chipId,
      plateNumber: formItem.plateNumber,
      driverName: formItem.driverName
    }
  }
  return localRequest(config);
}

export {
  uploadImg,
  localUpload,
  localUploadCar
}