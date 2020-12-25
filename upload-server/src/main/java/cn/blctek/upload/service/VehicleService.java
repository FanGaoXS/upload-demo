package cn.blctek.upload.service;

import cn.blctek.upload.pojo.Car;
import cn.blctek.upload.pojo.Driver;
import cn.blctek.upload.pojo.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/12/25/17:25
 * @Description:
 */
@Service
public interface VehicleService {

    /**
     *  查询所有车辆信息
     * @return 车辆信息的集合
     */
    List<Vehicle> findAllVehicle();

    /**
     *  新增车辆
     * @param car
     * @param driver
     * @param vehicle
     * @return 新增成功后的车辆信息对象
     */
    Vehicle addVehicle(Car car,Driver driver,Vehicle vehicle);
}
