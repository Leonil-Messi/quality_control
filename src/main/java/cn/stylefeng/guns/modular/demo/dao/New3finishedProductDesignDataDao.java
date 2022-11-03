package cn.stylefeng.guns.modular.demo.dao;

//import cn.stylefeng.guns.modular.demo.vo.Predict1VO;
import cn.stylefeng.guns.modular.demo.vo.Predict1VO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.stylefeng.guns.modular.demo.entity.New3finishedProductDesignData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (New3finishedProductDesignData)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-26 15:56:46
 */
@Mapper
public interface New3finishedProductDesignDataDao extends BaseMapper<New3finishedProductDesignData> {
    //多表联合查询 按条件orderID
    @Select("SELECT e1.*, e2.* FROM new_3finished_product_design_data e1, new_7experimental_data_of_faulty_parts  e2 WHERE e1.product_name = e2.equipment_name")
    List<Predict1VO> orderUserList();

    @Select("select distinct c.* from new_1quality_problem_data a,new_3finished_product_design_data c where a.faultyparts_title=c.product_name")
    List<Predict1VO> select1FaultypartsTitleEqual3productName();

    @Select("select distinct c.* from new_1quality_problem_data a,new_3finished_product_design_data c where a.faultparts_model=c.product_model")
    List<Predict1VO> select1FaultypartsModelEqual3productModel();
}
