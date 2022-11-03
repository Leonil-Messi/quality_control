package cn.stylefeng.guns.modular.demo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (NewTest)表实体类
 *
 * @author makejava
 * @since 2021-11-24 19:42:42
 */
@SuppressWarnings("serial")
public class NewTest extends Model<NewTest> {

    private String id;

    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
