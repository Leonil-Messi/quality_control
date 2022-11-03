package cn.stylefeng.guns.modular.demo.dao;

import cn.stylefeng.guns.modular.demo.entity.problem44;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.stylefeng.guns.modular.demo.entity.New5finishedproductManufacturingdata;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (New5finishedproductManufacturingdata)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-26 15:56:47
 */
@Mapper
public interface New5finishedproductManufacturingdataDao extends BaseMapper<New5finishedproductManufacturingdata> {

    @Select("SELECT count(*) as value, a.faultyparts_title as source,SUBSTRING_INDEX(SUBSTRING_INDEX(a.faultparts_equipment,';',b.help_topic_id+1),';',-1) AS target FROM new_1quality_problem_data,new_5finishedproduct_manufacturingdata a join mysql.help_topic b on b.help_topic_id < LENGTH(a.faultparts_equipment)-LENGTH(REPLACE(a.faultparts_equipment,';',''))+1 where a.faultyparts_title=new_1quality_problem_data.faultyparts_title GROUP BY  source,target")
    List<problem44> problem36back();

    @Select("SELECT count(*) as value, a.faultyparts_title as source,SUBSTRING_INDEX(SUBSTRING_INDEX(a.faultparts_materials_source,';',b.help_topic_id+1),';',-1) AS target FROM new_1quality_problem_data,new_5finishedproduct_manufacturingdata a join mysql.help_topic b on b.help_topic_id < LENGTH(a.faultparts_materials_source)-LENGTH(REPLACE(a.faultparts_materials_source,';',''))+1 where a.faultyparts_title=new_1quality_problem_data.faultyparts_title GROUP BY  source,target")
    List<problem44> problem37back();

}
