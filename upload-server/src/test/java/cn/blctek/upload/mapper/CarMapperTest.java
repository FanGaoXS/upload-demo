package cn.blctek.upload.mapper;

import cn.blctek.upload.pojo.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/12/25/16:21
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CarMapperTest {
    @Autowired
    private CarMapper carMapper;
    @Test
    public void selectAllCarAndDriver() {
        List<Car> carList = carMapper.selectAllCarAndDriver();
        carList.forEach(car -> {
            System.out.println(car);
        });
    }

    @Test
    public void insertCar() {
        Car car = new Car();
        car.setType("车辆");
        int i = carMapper.insertCar(car);
        System.out.println(car.getCarId());
    }
}