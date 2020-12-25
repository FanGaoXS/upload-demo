package cn.blctek.upload.service;

import cn.blctek.upload.pojo.Car;
import cn.blctek.upload.pojo.Driver;
import cn.blctek.upload.pojo.Machine;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/12/25/18:08
 * @Description:
 */
@Service
public interface MachineService {

    /**
     *  查询所有机械
     * @return 机械的集合
     */
    List<Machine> findAllMachine();

    /**
     *  新增机械
     * @param car
     * @param driver
     * @param machine
     * @return 新增成功后的机械信息对象
     */
    Machine addMachine(Car car, Driver driver, Machine machine);
}
