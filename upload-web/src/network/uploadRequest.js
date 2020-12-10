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

function localUploadImg(uploadData) {
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
  localUploadImg,
  localUploadCar
}