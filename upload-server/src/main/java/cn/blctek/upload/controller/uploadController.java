package cn.blctek.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping("test")
    public String test(){
        return "测试通过";
    }

    @GetMapping("/upload")
    public String upload(/*HttpServletRequest request,*/
                         @RequestParam("chipId")String chipId,
                         @RequestParam("plateNumber")String plateNumber,
                         @RequestParam("driverName")String driverName){
        System.out.println("chipId->"+chipId);
        System.out.println("plateNumber->"+plateNumber);
        System.out.println("driverName->"+driverName);
        ;
        return "上传成功";
    }

    @PostMapping("/uploadImg")
    public String uploadImg(@RequestParam("chipId") int chipId,
                            @RequestParam("plateNumber") String plateNumber,
                            @RequestParam("driverName") String driverName,
                            @RequestParam("file") MultipartFile file){
        System.out.println("芯片编号->"+chipId);
        System.out.println("车牌号->"+plateNumber);
        System.out.println("驾驶员性名->"+driverName);
        System.out.println("文件是否为空->"+file.isEmpty());
        return "上传图片成功";
    }

}
