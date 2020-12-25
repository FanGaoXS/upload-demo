package cn.blctek.upload.controller;

import cn.blctek.upload.pojo.Car;
import cn.blctek.upload.pojo.Driver;
import cn.blctek.upload.pojo.Vehicle;
import cn.blctek.upload.service.MachineService;
import cn.blctek.upload.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("car")
@Slf4j
public class uploadController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private MachineService machineService;

    @RequestMapping("/test")
    public String test(){
        System.out.println("---test 测试 start---");
        System.out.println("---test 测试 end---");
        return "测试通过";
    }

    @PostMapping("/uploadVehicle")
    public String uploadVehicle(@RequestParam("chipId") String chipId,
                                @RequestParam("plateType") String plateType,
                                @RequestParam("vehicleModel") String vehicleModel,
                                @RequestParam("plateNumber") String plateNumber,
                                @RequestParam("driverName") String driverName,
                                @RequestParam("driverPhone") String driverPhone,
                                @RequestParam("file") MultipartFile file){
        log.info("---uploadVehicle start---");
        log.info("---uploadVehicle start---");
        log.info("芯片编号->[{}]",chipId);
        log.info("车牌类型->[{}]",plateType);
        log.info("车辆类型->[{}]",vehicleModel);
        log.info("车牌号->[{}]",plateNumber);
        log.info("驾驶员姓名->[{}]",driverName);
        log.info("驾驶员手机号码->[{}]",driverPhone);
        log.info("文件是否为空->[{}]",file.isEmpty());
        String fileSize=new String();
        if (file.getSize()>0&&file.getSize()<=(1024*1024)){ //如果文件大小小于1M
            fileSize=file.getSize()/1024+"Kb"; //以kb显示
        } else if (file.getSize()>(1024*1024)){// 如果文件大小大于1M
            fileSize=file.getSize()/1024/1024+"M"; //以显示M
        }
        log.info("文件大小->[{}]",fileSize);
        Car car = new Car();
        car.setType("车辆");
        car.setChipId(chipId);
        Driver driver = new Driver();
        driver.setDriverName(driverName);
        driver.setDriverPhone(driverPhone);
        Vehicle vehicle = new Vehicle();
        vehicle.setPlateNumber(plateNumber);
        vehicle.setVehicleModel(vehicleModel);
        vehicle.setVehicleModel(plateType);
        Vehicle vehicleDB = vehicleService.addVehicle(car, driver, vehicle);
        log.info("---uploadVehicle end---");
        /*System.out.println("---uploadVehicle start---");
        System.out.println("芯片编号->"+chipId);
        System.out.println("车牌类型->"+plateType);
        System.out.println("车辆类型->"+vehicleModel);
        System.out.println("车牌号->"+plateNumber);
        System.out.println("驾驶员姓名->"+driverName);
        System.out.println("驾驶员手机号码->"+driverPhone);
        System.out.println("文件是否为空->"+file.isEmpty());
        System.out.print("文件大小->");
        if (file.getSize()>0&&file.getSize()<=(1024*1024)){ //如果文件大小小于1M
            System.out.println(file.getSize()/1024+"Kb"); //以kb显示
        } else if (file.getSize()>(1024*1024)){// 如果文件大小大于1M
            System.out.println(file.getSize()/1024/1024+"M"); //以显示M
        }
        System.out.println("---uploadVehicle end---");*/
        return "上传车辆信息成功";
    }

    @PostMapping("/uploadMachine")
    public String uploadMachine(HttpServletRequest request,
                                @RequestParam("chipId") String chipId,
                                @RequestParam("machineModel") String machineModel,
                                @RequestParam("machineNumber") String machineNumber,
                                @RequestParam("engineNumber") String engineNumber,
                                @RequestParam("driverName") String driverName,
                                @RequestParam("driverPhone") String driverPhone,
                                @RequestParam("file") MultipartFile file){
        System.out.println("---uploadMachine start---");
        System.out.println(request.getCharacterEncoding());
        System.out.println("芯片编号->"+chipId);
        System.out.println("机械类型->"+machineModel);
        System.out.println("机械型号->"+machineNumber);
        System.out.println("机械发动机编号->"+engineNumber);
        System.out.println("驾驶员姓名->"+driverName);
        System.out.println("驾驶员手机号码->"+driverPhone);
        System.out.println("文件是否为空->"+file.isEmpty());
        System.out.print("文件大小->");
        if (file.getSize()>0&&file.getSize()<=(1024*1024)){ //如果文件大小小于1M
            System.out.println(file.getSize()/1024+"Kb"); //以kb显示
        } else if (file.getSize()>(1024*1024)){// 如果文件大小大于1M
            System.out.println(file.getSize()/1024/1024+"M"); //以显示M
        }
        System.out.println("---uploadMachine end---");
        return "上传机械信息成功";
    }
}
