package cn.stylefeng.guns.modular.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (New7experimentalDataOfFaultyParts)表实体类
 *
 * @author makejava
 * @since 2021-11-26 15:56:48
 */
@SuppressWarnings("serial")
@TableName("new_7experimental_data_of_faulty_parts")
public class New7experimentalDataOfFaultyParts extends Model<New7experimentalDataOfFaultyParts> {
    //故障件实验数据
    private int experimentalDataOfFaultyPartsId;
    //机型
    private String jx;
    //设备名称
    private String equipmentName;
    //试验种类
    private String experimentType;
    //试验输入
    private String experimentInput;
    //实测种类
    private String tsetType;
    //实测输入
    private String testInput;


    public int getExperimentalDataOfFaultyPartsId() {
        return experimentalDataOfFaultyPartsId;
    }

    public void setExperimentalDataOfFaultyPartsId(int experimentalDataOfFaultyPartsId) {
        this.experimentalDataOfFaultyPartsId = experimentalDataOfFaultyPartsId;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getExperimentType() {
        return experimentType;
    }

    public void setExperimentType(String experimentType) {
        this.experimentType = experimentType;
    }

    public String getExperimentInput() {
        return experimentInput;
    }

    public void setExperimentInput(String experimentInput) {
        this.experimentInput = experimentInput;
    }

    public String getTsetType() {
        return tsetType;
    }

    public void setTsetType(String tsetType) {
        this.tsetType = tsetType;
    }

    public String getTestInput() {
        return testInput;
    }

    public void setTestInput(String testInput) {
        this.testInput = testInput;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.experimentalDataOfFaultyPartsId;
    }
}
