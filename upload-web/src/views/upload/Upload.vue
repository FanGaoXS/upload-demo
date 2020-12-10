<template>
  <el-container>

    <el-header>上传车辆信息</el-header>

    <el-main>

      <el-form label-position="right" label-wIdth="80px">

        <!--芯片编号-->
        <el-input
                type="hIdden"
                v-model="formItem.chipId"
        ></el-input>

        <!--车牌号-->
        <el-form-item label="车牌号">
          <el-input
                  type="text"
                  placeholder="请输入车牌号"
                  v-model="formItem.plateNumber"
          ></el-input>
        </el-form-item>

        <!--驾驶员-->
        <el-form-item label="驾驶员">
          <el-input
                  type="text"
                  placeholder="请输入驾驶员性名"
                  v-model="formItem.driverName"
          ></el-input>
        </el-form-item>

          <!--图片上传-->
          <el-upload
                  class="upload-demo"
                  ref="uploadImg"
                  action="http://127.0.0.1:8089/car/uploadImg"
                  :on-preview="handlePreview"
                  :on-remove="handleRemove"
                  :file-list="fileList"
                  :auto-upload="false"
                  :limit="1"
                  :accept="'image/*'"
                  :http-request="uploadImg"
                  list-type="picture">
            <el-button size="medium" type="primary">上传车辆照片<i class="el-icon-upload el-icon--right"></i></el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，只能上传一张图片</div>
          </el-upload>


        <!-- 提交和重置按钮 -->

          <el-button type="primary" @click="submitForm()">提交</el-button>

      </el-form>

    </el-main>

    <el-footer>Copyright©blctek.com</el-footer>

  </el-container>
</template>

<script>

  import {
    uploadImg,
    localUploadImg,
    localUploadCar
  } from "../../network/uploadRequest";

  uploadImg().then(res=>{
    console.log(res);
  });

  localUploadImg().then(res=>{
    console.log(res);
  });

  export default {
    name: "Upload",
    data() {
      return {
        formItem: {
          // 芯片编号
          chipId: 11,
          // 车牌号
          plateNumber: '',
          // 驾驶员
          driverName: ''
        },
        fileList: [
          /*{
            name: 'food.jpeg',
            url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
          },
          {
            name: 'food2.jpeg',
            url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
          }*/
        ]
      };
    },
    methods: {
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },
      uploadImg(param){
        console.log(param.file);
        console.log(param.file.name);
        let uploadData = new FormData();
        uploadData.append('file', param.file);
        localUploadImg(uploadData).then(res => {
          console.log(res);
        });
      },
      submitForm() {
        console.log(this.formItem);
        // 如果都不为空则提交
        if (this.formItem.chipId!==0&&this.formItem.plateNumber!==''&&this.formItem.driverName!=='') {
          // 提交车辆信息
          localUploadCar(this.formItem).then(res=>{
            console.log(res);
          });
          // 提交图片
          this.$refs.uploadImg.submit();
          console.log('提交成功');
        } else {
          console.log('请重新输入');
        }
      },
    }
  }
</script>

<style scoped>

  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-main {
    /*background-color: #E9EEF3;*/
    color: #333;
    text-align: center;
    line-height: 100px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

</style>