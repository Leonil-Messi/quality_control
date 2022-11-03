package cn.stylefeng.guns.modular.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (New5finishedproductManufacturingdata)表实体类
 *
 * @author makejava
 * @since 2021-11-26 15:56:47
 */
@SuppressWarnings("serial")
@TableName("new_5finishedproduct_manufacturingdata")
public class New5finishedproductManufacturingdata extends Model<New5finishedproductManufacturingdata> {
    //序号
    private int faultyId;
    //故障件名称
    private String faultypartsTitle;
    //故障件型号
    private String faultpartsModel;
    //故障件制造单位
    private String faultpartsUnit;
    //故障件制造批次
    private String faultpartsBatch;
    //故障件制造人员
    private String faultpartsPerson;
    //故障件加工设备
    private String faultpartsEquipment;
    //故障件原材料来源
    private String faultpartsMaterialsSource;


    public int getFaultyId() {
        return faultyId;
    }

    public void setFaultyId(int faultyId) {
        this.faultyId = faultyId;
    }

    public String getFaultypartsTitle() {
        return faultypartsTitle;
    }

    public void setFaultypartsTitle(String faultypartsTitle) {
        this.faultypartsTitle = faultypartsTitle;
    }

    public String getFaultpartsModel() {
        return faultpartsModel;
    }

    public void setFaultpartsModel(String faultpartsModel) {
        this.faultpartsModel = faultpartsModel;
    }

    public String getFaultpartsUnit() {
        return faultpartsUnit;
    }

    public void setFaultpartsUnit(String faultpartsUnit) {
        this.faultpartsUnit = faultpartsUnit;
    }

    public String getFaultpartsBatch() {
        return faultpartsBatch;
    }

    public void setFaultpartsBatch(String faultpartsBatch) {
        this.faultpartsBatch = faultpartsBatch;
    }

    public String getFaultpartsPerson() {
        return faultpartsPerson;
    }

    public void setFaultpartsPerson(String faultpartsPerson) {
        this.faultpartsPerson = faultpartsPerson;
    }

    public String getFaultpartsEquipment() {
        return faultpartsEquipment;
    }

    public void setFaultpartsEquipment(String faultpartsEquipment) {
        this.faultpartsEquipment = faultpartsEquipment;
    }

    public String getFaultpartsMaterialsSource() {
        return faultpartsMaterialsSource;
    }

    public void setFaultpartsMaterialsSource(String faultpartsMaterialsSource) {
        this.faultpartsMaterialsSource = faultpartsMaterialsSource;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.faultyId;
    }
}
