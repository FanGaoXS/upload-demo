package cn.blctek.upload.controller;

import cn.blctek.upload.pojo.Car;
import cn.blctek.upload.pojo.Driver;
import cn.blctek.upload.pojo.Machine;
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
     *  新增车辆信息（上传）
     * @param chipId 芯片编号
     * @param plateType 车牌类型（新能源、汽油车）
     * @param vehicleModel 车辆类型（皮卡车、罐车...）
     * @param plateNumber   车牌号
     * @param driverName    驾驶员姓名
     * @param driverPhone   驾驶员电话号码
     * @param file          上传的图片
     * @return              responseMap（状态码、数据、提示信息）
     */
    @PostMapping("/addVehicle")
    public Map<String,Object> addVehicle(@RequestParam("chipId") String chipId,
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

    /**
     * 修改车辆信息
     * @param vehicle
     * @param driver
     * @return
     */
    @GetMapping("/modifyVehicle")
    public Map<String,Object> modifyVehicle(Vehicle vehicle,Driver driver){
        Boolean result = vehicleService.modifyVehicleAndDriverInfo(vehicle, driver);
        log.info("Vehicle是否修改成功->[{}]",result?"是":"否");
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("status",result);
        resMap.put("msg","修改车辆信息");
        return resMap;
    }

    /**
     * 删除车辆信息
     * @param vehicleId
     * @param carId
     * @param driverId
     * @return
     */
    @GetMapping("/removeVehicle")
    public Map<String,Object> removeVehicle(Integer vehicleId,
                                            Integer carId,
                                            Integer driverId){
        Boolean result = vehicleService.removeVehicle(vehicleId, carId, driverId);
        log.info("Vehicle是否删除成功->[{}]",result?"是":"否");
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("status",result);
        resMap.put("msg","删除车辆信息");
        return resMap;
    }
}
