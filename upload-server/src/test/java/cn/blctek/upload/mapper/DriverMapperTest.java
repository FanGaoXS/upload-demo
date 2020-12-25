package cn.blctek.upload.mapper;

import cn.blctek.upload.pojo.Driver;
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
 * @Date: 2020/12/25/16:45
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DriverMapperTest {
    @Autowired
    DriverMapper driverMapper;
    @Test
    public void selectAllDriver() {
        List<Driver> driverList = driverMapper.selectAllDriver();
        driverList.forEach(driver -> {
            System.out.println(driver);
        });
    }

    @Test
    public void insertDriver() {
        Driver driver = new Driver();
        driver.setDriverName("吴青珂");
        driverMapper.insertDriver(driver);
        System.out.println(driver.getDriverId());
    }
}