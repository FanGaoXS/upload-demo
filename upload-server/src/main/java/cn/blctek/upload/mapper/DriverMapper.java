package cn.blctek.upload.mapper;

import cn.blctek.upload.pojo.Driver;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/12/25/16:08
 * @Description: 对driver表的crud
 */
@Mapper
@Repository
public interface DriverMapper {

    /**
     *  查询所有驾驶员
     * @return 驾驶员集合
     */
    List<Driver> selectAllDriver();

    /**
     *  新增驾驶员
     * @param driver 驾驶员对象
     * @return 增加的驾驶员数量
     */
    int insertDriver(Driver driver);
}
