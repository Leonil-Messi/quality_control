package cn.stylefeng.guns.modular.demo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (NewKeyComponentDesign)表实体类
 *
 * @author makejava
 * @since 2021-11-24 15:45:00
 */
@SuppressWarnings("serial")
public class NewKeyComponentDesign extends Model<NewKeyComponentDesign> {

    private Integer id;

    private String jx;

    private String faultname;

    private String faulttype;

    private String keyword;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getFaultname() {
        return faultname;
    }

    public void setFaultname(String faultname) {
        this.faultname = faultname;
    }

    public String getFaulttype() {
        return faulttype;
    }

    public void setFaulttype(String faulttype) {
        this.faulttype = faulttype;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
