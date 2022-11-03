package cn.stylefeng.guns.modular.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * (New1qualityProblemData)表实体类
 *
 * @author makejava
 * @since 2021-11-26 15:56:44
 */
@SuppressWarnings("serial")
@TableName("new_1quality_problem_data")
public class New1qualityProblemData extends Model<New1qualityProblemData> {
    //序号
    private int qualityId;
    //质量问题标题
    private String title;
    //JX
    private String jx;
    //ZB制造单位
    private String zbUnit;
    //ZB制造批次
    private String zbBatch;
    //ZB出厂时间
    private Date zbDeliverytime;
    //发生时间
    private Date time;
    //ZB使用部队
    private String zbTroop;
    //故障件种类
    private String faultypartsType;
    //故障件名称
    private String faultypartsTitle;
    //故障件型号
    private String faultpartsModel;
    //故障件制造单位
    private String faultpartsUnit;
    //故障件制造批次
    private String faultpartsBatch;
    //故障件出厂时间
    private Date faultpartsDeliverytime;
    //故障件使用时长
    private String faultpartsUsagetime;
    //故障现象
    private String faultPhenomenon;
    //故障模式
    private String failureMode;
    //发生地理环境
    private String environment;
    //ZB是否进行过大修
    private String zbFixed;
    //大修时间
    private Date fixedTime;
    //大修厂
    private String fixedFactory;
    //大修人员
    private String fixedPerson;
    //关键件名称
    private String keyName;
    //关键件制造单位
    private String keyFactory;
    //关键件制造批次
    private String keyBatch;
    //关键件出厂时间
    private Date keyDeliverytime;


    public int getQualityId() {
        return qualityId;
    }

    public void setQualityId(int qualityId) {
        this.qualityId = qualityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getZbUnit() {
        return zbUnit;
    }

    public void setZbUnit(String zbUnit) {
        this.zbUnit = zbUnit;
    }

    public String getZbBatch() {
        return zbBatch;
    }

    public void setZbBatch(String zbBatch) {
        this.zbBatch = zbBatch;
    }

    public Date getZbDeliverytime() {
        return zbDeliverytime;
    }

    public void setZbDeliverytime(Date zbDeliverytime) {
        this.zbDeliverytime = zbDeliverytime;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getZbTroop() {
        return zbTroop;
    }

    public void setZbTroop(String zbTroop) {
        this.zbTroop = zbTroop;
    }

    public String getFaultypartsType() {
        return faultypartsType;
    }

    public void setFaultypartsType(String faultypartsType) {
        this.faultypartsType = faultypartsType;
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

    public Date getFaultpartsDeliverytime() {
        return faultpartsDeliverytime;
    }

    public void setFaultpartsDeliverytime(Date faultpartsDeliverytime) {
        this.faultpartsDeliverytime = faultpartsDeliverytime;
    }

    public String getFaultpartsUsagetime() {
        return faultpartsUsagetime;
    }

    public void setFaultpartsUsagetime(String faultpartsUsagetime) {
        this.faultpartsUsagetime = faultpartsUsagetime;
    }

    public String getFaultPhenomenon() {
        return faultPhenomenon;
    }

    public void setFaultPhenomenon(String faultPhenomenon) {
        this.faultPhenomenon = faultPhenomenon;
    }

    public String getFailureMode() {
        return failureMode;
    }

    public void setFailureMode(String failureMode) {
        this.failureMode = failureMode;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getZbFixed() {
        return zbFixed;
    }

    public void setZbFixed(String zbFixed) {
        this.zbFixed = zbFixed;
    }

    public Date getFixedTime() {
        return fixedTime;
    }

    public void setFixedTime(Date fixedTime) {
        this.fixedTime = fixedTime;
    }

    public String getFixedFactory() {
        return fixedFactory;
    }

    public void setFixedFactory(String fixedFactory) {
        this.fixedFactory = fixedFactory;
    }

    public String getFixedPerson() {
        return fixedPerson;
    }

    public void setFixedPerson(String fixedPerson) {
        this.fixedPerson = fixedPerson;
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

    public Date getKeyDeliverytime() {
        return keyDeliverytime;
    }

    public void setKeyDeliverytime(Date keyDeliverytime) {
        this.keyDeliverytime = keyDeliverytime;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.qualityId;
    }



}
