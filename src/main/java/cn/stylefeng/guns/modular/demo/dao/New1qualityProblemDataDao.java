package cn.stylefeng.guns.modular.demo.dao;

import cn.stylefeng.guns.modular.demo.entity.problem19;
import cn.stylefeng.guns.modular.demo.entity.problem44;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (New1qualityProblemData)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-26 15:56:44
 */
@Mapper
public interface New1qualityProblemDataDao extends BaseMapper<New1qualityProblemData> {

    @Select("SELECT quality_id as id,DATEDIFF(fixed_time,time) as timediff,fixed_factory as factorname FROM new_1quality_problem_data;")
    List<problem19> problem19back();

    @Select("SELECT count(*) as value,a.jx as source,SUBSTRING_INDEX(SUBSTRING_INDEX(a.fixed_person,';',b.help_topic_id+1),';',-1) AS target FROM new_1quality_problem_data a join mysql.help_topic b on b.help_topic_id < LENGTH(a.fixed_person)-LENGTH(REPLACE(a.fixed_person,';',''))+1 GROUP BY source,target;")
    List<problem44> problem20back1();

    @Select("SELECT count(*) as value,a.zb_unit as source,SUBSTRING_INDEX(SUBSTRING_INDEX(a.fixed_person,';',b.help_topic_id+1),';',-1) AS target FROM new_1quality_problem_data a join mysql.help_topic b on b.help_topic_id < LENGTH(a.fixed_person)-LENGTH(REPLACE(a.fixed_person,';',''))+1 GROUP BY source,target;")
    List<problem44> problem20back2();

}
