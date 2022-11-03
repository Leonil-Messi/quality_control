package cn.stylefeng.guns.modular.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (New6keypartsManufacturingdata)表实体类
 *
 * @author makejava
 * @since 2021-12-05 16:22:59
 */
@SuppressWarnings("serial")
@TableName("new_6keyparts_manufacturingdata")
public class New6keypartsManufacturingdata extends Model<New6keypartsManufacturingdata> {
    //序号
    private Integer keyId;
    //故障件名称
    private String faultypartsTitle;
    //关键件名称
    private String keyName;
    //关键件制造单位
    private String keyFactory;
    //关键件批次
    private String keyBatch;
    //关键件检测数据
    private String keyTestdata;
    //关键件检测人员
    private String keyTestperson;
    //关键件检测设备
    private String keyTestequiment;
    //关键件检测设备上次检测时间
    private String keyTestlasttime;
    //关键件测试类型
    private String keyTesttype;


    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getFaultypartsTitle() {
        return faultypartsTitle;
    }

    public void setFaultypartsTitle(String faultypartsTitle) {
        this.faultypartsTitle = faultypartsTitle;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyFactory() {
        return keyFactory;
    }

    public void setKeyFactory(String keyFactory) {
        this.keyFactory = keyFactory;
    }

    public String getKeyBatch() {
        return keyBatch;
    }

    public void setKeyBatch(String keyBatch) {
        this.keyBatch = keyBatch;
    }

    public String getKeyTestdata() {
        return keyTestdata;
    }

    public void setKeyTestdata(String keyTestdata) {
        this.keyTestdata = keyTestdata;
    }

    public String getKeyTestperson() {
        return keyTestperson;
    }

    public void setKeyTestperson(String keyTestperson) {
        this.keyTestperson = keyTestperson;
    }

    public String getKeyTestequiment() {
        return keyTestequiment;
    }

    public void setKeyTestequiment(String keyTestequiment) {
        this.keyTestequiment = keyTestequiment;
    }

    public String getKeyTestlasttime() {
        return keyTestlasttime;
    }

    public void setKeyTestlasttime(String keyTestlasttime) {
        this.keyTestlasttime = keyTestlasttime;
    }

    public String getKeyTesttype() {
        return keyTesttype;
    }

    public void setKeyTesttype(String keyTesttype) {
        this.keyTesttype = keyTesttype;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.keyId;
    }
    }

