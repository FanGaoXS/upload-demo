package cn.blctek.upload.controller;

import cn.blctek.upload.pojo.Car;
import cn.blctek.upload.pojo.Driver;
import cn.blctek.upload.pojo.Vehicle;
import cn.blctek.upload.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/12/28/11:36
 * @Description:
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("vehicle")
@Slf4j
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    /**
     *  上传车辆信息
     * @param chipId 芯片编号
     * @param plateType 车牌类型（新能源、汽油车）
     * @param vehicleModel 车辆类型（皮卡车、罐车...）
     * @param plateNumber   车牌号
     * @param driverName    驾驶员姓名
     * @param driverPhone   驾驶员电话号码
     * @param file          上传的图片
     * @return              responseMap（状态码、数据、提示信息）
     */
    @PostMapping("/uploadVehicle")
    public Map<String,Object> uploadVehicle(@RequestParam("chipId") String chipId,
                                            @RequestParam("plateType") String plateType,
                                            @RequestParam("vehicleModel") String vehicleModel,
                                            @RequestParam("plateNumber") String plateNumber,
                                            @RequestParam("driverName") String driverName,
                                            @RequestParam("driverPhone") String driverPhone,
                                            @RequestParam("file") MultipartFile file){
        log.info("---上传车辆信息 start---");
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
        vehicle.setPlateType(plateType);
        vehicle.setVehicleModel(vehicleModel);

        Vehicle vehicleDB = vehicleService.addVehicle(car, driver, vehicle);

        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("status",true);
        resMap.put("msg","上传车辆信息成功！");
        resMap.put("data",vehicleDB);
        log.info("---uploadVehicle end---");
        return resMap;
    }

    /**
     *  查询所有车辆集合
     * @return  responseMap（状态码、数据、提示信息）
     */
    @GetMapping("/allVehicle")
    public Map<String,Object> allVehicle(){
        List<Vehicle> vehicleList = vehicleService.findAllVehicle();
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("status",true);
        resMap.put("msg","查询所有车辆信息");
        resMap.put("data",vehicleList);
        return resMap;
    }
}
