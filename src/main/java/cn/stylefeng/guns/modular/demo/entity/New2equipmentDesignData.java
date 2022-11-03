package cn.stylefeng.guns.modular.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (New2equipmentDesignData)表实体类
 *
 * @author makejava
 * @since 2021-11-26 15:56:45
 */
@SuppressWarnings("serial")
@TableName("new_2equipment_design_data")
public class New2equipmentDesignData extends Model<New2equipmentDesignData> {
    //序号
    private int designId;
    //JX
    private String jx;
    //ZB改型时间
    private String zbModificationTime;
    //ZB改型措施
    private String zbModificationMeasures;
    //ZB制造单位
    private String zbUnit;


    public int getDesignId() {
        return designId;
    }

    public void setDesignId(int designId) {
        this.designId = designId;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getZbModificationTime() {
        return zbModificationTime;
    }

    public void setZbModificationTime(String zbModificationTime) {
        this.zbModificationTime = zbModificationTime;
    }

    public String getZbModificationMeasures() {
        return zbModificationMeasures;
    }

    public void setZbModificationMeasures(String zbModificationMeasures) {
        this.zbModificationMeasures = zbModificationMeasures;
    }

    public String getZbUnit() {
        return zbUnit;
    }

    public void setZbUnit(String zbUnit) {
        this.zbUnit = zbUnit;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.designId;
    }
}
