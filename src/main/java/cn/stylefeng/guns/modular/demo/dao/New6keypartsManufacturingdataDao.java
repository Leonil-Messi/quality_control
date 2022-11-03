package cn.stylefeng.guns.modular.demo.dao;

import cn.stylefeng.guns.modular.demo.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (New6keypartsManufacturingdata)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-26 15:56:48
 */
@Mapper
public interface New6keypartsManufacturingdataDao extends BaseMapper<New6keypartsManufacturingdata> {
    @Select("SELECT count(*) as value, a.key_name as source,SUBSTRING_INDEX(SUBSTRING_INDEX(a.key_testperson,';',b.help_topic_id+1),';',-1) AS target FROM new_6keyparts_manufacturingdata a join mysql.help_topic b on b.help_topic_id < LENGTH(a.key_testperson)-LENGTH(REPLACE(a.key_testperson,';',''))+1 GROUP BY  source,target")
    List<problem44> problem44back();

    @Select("SELECT count(*) as value,a.key_name as source,SUBSTRING_INDEX(SUBSTRING_INDEX(a.key_testequiment,';',b.help_topic_id+1),';',-1) AS target FROM new_6keyparts_manufacturingdata a join mysql.help_topic b on b.help_topic_id < LENGTH(a.key_testequiment)-LENGTH(REPLACE(a.key_testequiment,';',''))+1 GROUP BY source,target")
    List<problem44> problem45back();


}
