package cn.stylefeng.guns.modular.demo.dao;

import cn.stylefeng.guns.modular.demo.entity.problem46;
import cn.stylefeng.guns.modular.demo.entity.problem48;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.stylefeng.guns.modular.demo.entity.New7experimentalDataOfFaultyParts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (New7experimentalDataOfFaultyParts)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-26 15:56:48
 */
@Mapper
public interface New7experimentalDataOfFaultyPartsDao extends BaseMapper<New7experimentalDataOfFaultyParts> {

    @Select("SELECT equipment_name,experiment_type from new_7experimental_data_of_faulty_parts,new_1quality_problem_data where  equipment_name=faultyparts_title GROUP BY equipment_name,experiment_type;")
    List<problem46> problem46back();

    @Select("SELECT equipment_name,tset_type from new_7experimental_data_of_faulty_parts,new_1quality_problem_data where  equipment_name=faultyparts_title GROUP BY equipment_name,tset_type;")
    List<problem48> problem48back();

}
