package cn.blctek.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
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

    @RequestMapping("test")
    public String test(){
        return "测试通过";
    }

    @GetMapping("upload")
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

    @PostMapping("uploadImg")
    public String uploadImg(MultipartFile file){
        System.out.println(file);
        System.out.println(file.getName());
        return "上传图片成功";
    }

}
