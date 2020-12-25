package cn.blctek.upload.mapper;

import cn.blctek.upload.pojo.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/12/25/16:46
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class VehicleMapperTest {
    @Autowired
    VehicleMapper vehicleMapper;
    @Test
    public void selectAllVehicle() {
        List<Vehicle> vehicleList = vehicleMapper.selectAllVehicle();
        vehicleList.forEach(vehicle -> {
            System.out.println(vehicle);
        });
    }

    @Test
    public void insertVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setCarId(5);
        vehicleMapper.insertVehicle(vehicle);
        System.out.println(vehicle.getVehicleId());
    }
}