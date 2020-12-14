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
                  action="#"
                  :on-preview="handlePreview"
                  :on-remove="handleRemove"
                  :file-list="fileList"
                  :auto-upload="false"
                  :before-upload="beforeUpload"
                  :limit="1"
                  :accept="'image/*'"
                  :http-request="upload"
                  list-type="picture">
            <el-button size="medium" type="primary">上传车辆照片<i class="el-icon-upload el-icon--right"></i></el-button>
            <div slot="tip" class="el-upload__tip">
              只能上传jpg/png文件
              <br>只能上传一张图片
              <br>且图片大小不能超过15M
            </div>
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
    localUpload,
  } from "../../network/uploadRequest";


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
      /* 上传文件前处理函数
      *  限制文件大小
      * */
      beforeUpload(file){
        // 文件大小（MB）
        let fileSize = file.size / 1024 / 1024 ;
        // 限制上传文件的大小15M
        const limitFileSize = 15;
        if (file.size>0&&file.size<=1024*1024){ //如果文件大小 0<size<=1M
          console.log('准备上传文件大小->',(file.size/1024).toFixed(2)+'Kb'); // 以Kb显示
        } else if (file.size>1024*1024) {
          console.log('准备上传文件大小->',(file.size/1024/1024).toFixed(2)+'M');// 以M显示
        }
        // 如果文件大小大于15M，则提示错误信息
        if (!(fileSize<limitFileSize)){
          this.$message({
            type: 'error',
            message: '请上传小于15M的图片',
            offset: '100'
          });
        }
        // 文件大小是否小于15M
        console.log('是否小于'+limitFileSize+'M->',fileSize<limitFileSize);
        /* 返回文件大小是否小于15M，是返回true，否则返回false。
        *  如果返回true，则能够提交上传，否则无法提交上传
         */
        return fileSize<limitFileSize ;
      },
      /* 上传文件函数
      *  params参数是el-upload里的fileList
      *  */
      upload(param){
        if (this.formItem.chipId!==0&&
            this.formItem.plateNumber!==''&&
            this.formItem.driverName!==''){
          // 发起axios请求并将form表单对象传递
          localUpload(param,this.formItem).then(res => {// 上传成功
            console.log('上传成功->',res);
            this.$notify({
              title: '成功',
              message: '您的车辆信息已经上传成功',
              type: 'success',
              offset: 100
            });
          }).catch(error => {// 上传失败
            console.log('上传失败->',error);
            this.$notify({
              title: '失败',
              message: '您的车辆信息上传失败，请联系管理员',
              type: 'error',
              offset: 100
            });
          });
        } else {
          this.$notify({
            title: '失败',
            message: '请将车辆信息填写完整',
            type: 'error',
            offset: 100
          });
        }
      },
      /* 提交上传（调用上传文件函数） */
      submitForm() {
        // 有文件添加进待上传列表才能调用该方法
        this.$refs.uploadImg.submit();
      },
    }
  }
</script>

<style scoped>

  .el-header, .el-footer {
    background-color: #629efa;
    color: #ffffff;
    text-align: center;
    line-height: 60px;
    border-radius: 20px;
  }

  .el-main {
    /*background-color: #E9EEF3;*/
    color: #333;
    text-align: center;
    line-height: 50px;
    margin-bottom: 50px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

</style>