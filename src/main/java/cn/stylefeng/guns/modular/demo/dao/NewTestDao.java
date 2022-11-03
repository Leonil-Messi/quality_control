package cn.stylefeng.guns.modular.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.stylefeng.guns.modular.demo.entity.NewTest;
import org.apache.ibatis.annotations.Mapper;

/**
 * (NewTest)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-24 19:42:42
 */
@Mapper
public interface NewTestDao extends BaseMapper<NewTest> {

}
