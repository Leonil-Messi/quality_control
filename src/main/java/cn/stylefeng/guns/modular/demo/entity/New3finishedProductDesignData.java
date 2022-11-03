package cn.stylefeng.guns.modular.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (New3finishedProductDesignData)表实体类
 *
 * @author makejava
 * @since 2021-11-26 15:56:45
 */
@SuppressWarnings("serial")
@TableName("new_3finished_product_design_data")
public class New3finishedProductDesignData extends Model<New3finishedProductDesignData> {
    //序号
    private int finDesignId;
    //JX
    private String jx;
    //成品件种类
    private String productType;
    //成品件名称
    private String productName;
    //成品件型号
    private String productModel;
    //成品件制造单位
    private String productFactory;
    //框
    private String frame;
    //上中下
    private String topMidBtm;
    //左中右
    private String leftCenterRight;
    //成品件安装方法
    private String installMethod;
    //抗振设计参数
    private String antivibration;
    //工作湿度限制
    private String humidityLimit;
    //工作温度限制
    private String temperatureLimit;
    //强度设计参数
    private String designStrength;
    //成品件改型时间
    private String modifyTime;
    //成品件改型措施
    private String modifyMeasures;
    //与相似成品件关系
    private String similarOtherRelation;


    public int getFinDesignId() {
        return finDesignId;
    }

    public void setFinDesignId(int finDesignId) {
        this.finDesignId = finDesignId;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getProductFactory() {
        return productFactory;
    }

    public void setProductFactory(String productFactory) {
        this.productFactory = productFactory;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getTopMidBtm() {
        return topMidBtm;
    }

    public void setTopMidBtm(String topMidBtm) {
        this.topMidBtm = topMidBtm;
    }

    public String getLeftCenterRight() {
        return leftCenterRight;
    }

    public void setLeftCenterRight(String leftCenterRight) {
        this.leftCenterRight = leftCenterRight;
    }

    public String getInstallMethod() {
        return installMethod;
    }

    public void setInstallMethod(String installMethod) {
        this.installMethod = installMethod;
    }

    public String getAntivibration() {
        return antivibration;
    }

    public void setAntivibration(String antivibration) {
        this.antivibration = antivibration;
    }

    public String getHumidityLimit() {
        return humidityLimit;
    }

    public void setHumidityLimit(String humidityLimit) {
        this.humidityLimit = humidityLimit;
    }

    public String getTemperatureLimit() {
        return temperatureLimit;
    }

    public void setTemperatureLimit(String temperatureLimit) {
        this.temperatureLimit = temperatureLimit;
    }

    public String getDesignStrength() {
        return designStrength;
    }

    public void setDesignStrength(String designStrength) {
        this.designStrength = designStrength;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyMeasures() {
        return modifyMeasures;
    }

    public void setModifyMeasures(String modifyMeasures) {
        this.modifyMeasures = modifyMeasures;
    }

    public String getSimilarOtherRelation() {
        return similarOtherRelation;
    }

    public void setSimilarOtherRelation(String similarOtherRelation) {
        this.similarOtherRelation = similarOtherRelation;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.finDesignId;
    }
}
