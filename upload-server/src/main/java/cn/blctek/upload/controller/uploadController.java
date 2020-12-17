package cn.blctek.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/12/10/16:40
 * @Description:
 */
@Controller
@ResponseBody
@CrossOrigin(origins = "*")
@RequestMapping("car")
public class uploadController {

    @RequestMapping("/test")
    public String test(){
        System.out.println("---test 测试 start---");
        System.out.println("---test 测试 end---");
        return "测试通过";
    }

    @PostMapping("/upload")
    public String upload(HttpServletRequest request,
                         @RequestParam("chipId") int chipId,
                         @RequestParam("plateType") String plateType,
                         @RequestParam("vehicleModel") String vehicleModel,
                         @RequestParam("plateNumber") String plateNumber,
                         @RequestParam("driverName") String driverName,
                         @RequestParam("file") MultipartFile file){
        System.out.println("---upload start---");
        System.out.println(request.getCharacterEncoding());
        System.out.println("芯片编号->"+chipId);
        System.out.println("车牌类型->"+plateType);
        System.out.println("车辆类型->"+vehicleModel);
        System.out.println("车牌号->"+plateNumber);
        System.out.println("驾驶员性名->"+driverName);
        System.out.println("文件是否为空->"+file.isEmpty());
        System.out.print("文件大小->");
        if (file.getSize()>0&&file.getSize()<=(1024*1024)){ //如果文件大小小于1M
            System.out.println(file.getSize()/1024+"Kb"); //以kb显示
        } else if (file.getSize()>(1024*1024)){// 如果文件大小大于1M
            System.out.println(file.getSize()/1024/1024+"M"); //以显示M
        }
        System.out.println("---upload end---");
        return "上传成功";
    }
}
