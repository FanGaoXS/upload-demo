package cn.blctek.upload.mapper;

import cn.blctek.upload.pojo.Vehicle;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/12/25/16:09
 * @Description: 对vehicle表的crud
 */
@Mapper
@Repository
public interface VehicleMapper {

    /**
     *  查询所有车辆集合
     * @return 车辆集合
     */
    List<Vehicle> selectAllVehicle();

    /**
     *  新增车辆
     * @param vehicle 车辆对象
     * @return 新增车辆的数量
     */
    int insertVehicle(Vehicle vehicle);
}