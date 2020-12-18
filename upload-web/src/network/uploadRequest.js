import {
  testRequest,
  localRequest,
  wqkRequest,
  blctekRequest
} from "./request";

// 向后端上传图片
export function uploadImg() {
  let config={
    url: '/home/multidata'
  }
  return testRequest(config);
}

// 上传车辆信息
export function uploadVehicle(formData) {
/*  // 创建form表单对象用于向后端传递数据（POST提交）
  let uploadData = new FormData();
  // 将图片文件添加到form对象里
  uploadData.append('file', param.file);
  // 将chipId（芯片编号）添加到form对象里
  uploadData.append('chipId', formItem.chipId);
  // 将plateTypeStr（车牌类型的字符串）添加到form对象里
  let plateTypeStr='';
  if (formItem.plateType){ // 新能源
    plateTypeStr='新能源';
  } else { // 汽油车
    plateTypeStr='汽油车';
  }
  uploadData.append('plateType', plateTypeStr);
  // 将vehicleModel（车型）添加到form对象里
  uploadData.append('vehicleModel', formItem.vehicleModel);
  // 将plateNumber（车牌号）添加到form对象里
  uploadData.append('plateNumber', formItem.plateNumber);
  // 将driverName（驾驶员性名）添加到form对象里
  uploadData.append('driverName', formItem.driverName);
  // 将driverPhone（驾驶员手机号码）添加到form对象里*/
  console.log('准备上传的文件->',formData.get('file'));
  console.log('准备上传的芯片编号->',formData.get('chipId'));
  console.log('准备上传的车牌类型->',formData.get('plateType'));
  console.log('准备上传的车牌号->',formData.get('plateNumber'));
  console.log('准备上传的车辆类型->',formData.get('vehicleModel'));
  console.log('准备上传的驾驶员姓名->',formData.get('driverName'));
  console.log('准备上传的驾驶员手机号码->',formData.get('driverPhone'));
  let config={
    url: '/car/uploadVehicle',
    method: 'POST',
    headers: {
      'Content-Type': 'multipart/form-data'
    },
    data:formData
  }
  return blctekRequest(config);
}

// 上传机械
export function uploadMachine(formData) {
  console.log('准备上传的文件->',formData.get('file'));
  console.log('准备上传的芯片编号->',formData.get('chipId'));
  console.log('准备上传的机械类型->',formData.get('machineModel'));
  console.log('准备上传的机械型号->',formData.get('machineNumber'));
  console.log('准备上传的机械的发动机编号->',formData.get('engineNumber'));
  console.log('准备上传的驾驶员姓名->',formData.get('driverName'));
  console.log('准备上传的驾驶员手机号码->',formData.get('driverPhone'));
  let config={
    url: '/car/uploadMachine',
    method: 'POST',
    headers: {
      'Content-Type': 'multipart/form-data'
    },
    data:formData
  }
  return blctekRequest(config);
}