package cn.stylefeng.guns.modular.demo.vo;

import cn.stylefeng.guns.modular.demo.entity.New3finishedProductDesignData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Yyk.
 * @date 2021/12/1 14:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Predict1VO {
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


    private String equipmentName;

    public String getEquipmentName() {
        return equipmentName;
    }

    @Override
    public String toString() {
        return "Predict1VO{" +
                "finDesignId=" + finDesignId +
                ", jx='" + jx + '\'' +
                ", productType='" + productType + '\'' +
                ", productName='" + productName + '\'' +
                ", productModel='" + productModel + '\'' +
                ", productFactory='" + productFactory + '\'' +
                ", frame='" + frame + '\'' +
                ", topMidBtm='" + topMidBtm + '\'' +
                ", leftCenterRight='" + leftCenterRight + '\'' +
                ", installMethod='" + installMethod + '\'' +
                ", antivibration='" + antivibration + '\'' +
                ", humidityLimit='" + humidityLimit + '\'' +
                ", temperatureLimit='" + temperatureLimit + '\'' +
                ", designStrength='" + designStrength + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                ", modifyMeasures='" + modifyMeasures + '\'' +
                ", similarOtherRelation='" + similarOtherRelation + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", experimentInput='" + experimentInput + '\'' +
                ", testInput='" + testInput + '\'' +
                '}';
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getExperimentInput() {
        return experimentInput;
    }

    public void setExperimentInput(String experimentInput) {
        this.experimentInput = experimentInput;
    }

    public String getTestInput() {
        return testInput;
    }

    public void setTestInput(String testInput) {
        this.testInput = testInput;
    }

    private String experimentInput;
    private String testInput;


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
}
