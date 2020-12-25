package cn.blctek.upload.service.impl;

import cn.blctek.upload.mapper.CarMapper;
import cn.blctek.upload.mapper.DriverMapper;
import cn.blctek.upload.mapper.MachineMapper;
import cn.blctek.upload.pojo.Car;
import cn.blctek.upload.pojo.Driver;
import cn.blctek.upload.pojo.Machine;
import cn.blctek.upload.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/12/25/18:10
 * @Description:
 */
@Service
@Transactional
public class MachineServiceImpl implements MachineService {
    @Autowired
    private MachineMapper machineMapper;
    @Autowired
    private DriverMapper driverMapper;
    @Autowired
    private CarMapper carMapper;
    @Override
    public List<Machine> findAllMachine() {
        return machineMapper.selectAllMachine();
    }

    @Override
    public Machine addMachine(Car car, Driver driver, Machine machine) {
        /**
         *  因为新增machine信息需要同时插入三张表
         *  所以先插入driver表，然后获得driverId
         *  再将driverId和car对象组合起来插入car表
         *  就能够得到carId，最后再将carId和machine的
         *  信息一起插入machine表，同时利用Spring的事务
         *  如果其中一个插入失败，那么三个插入都回滚
         */
        try {

            driverMapper.insertDriver(driver); //尝试向driver表中插入driver对象
            Integer driverId = driver.getDriverId(); //若插入成功则能够获取到driverId

            car.setDriverId(driverId); // 将driver表中的driverId赋给car
            carMapper.insertCar(car); //尝试向car表中插入car对象
            Integer carId = car.getCarId(); //若插入成功则能够获取到carId

            machine.setCarId(carId); // 将car表中的carId赋给machine
            machineMapper.insertMachine(machine); //尝试向machine表中插入machine对象

            return machine;
        } catch (DataAccessException e) {
            // 只要任何一张表中插入失败就回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println(e);
            return null;
        }
    }
}
