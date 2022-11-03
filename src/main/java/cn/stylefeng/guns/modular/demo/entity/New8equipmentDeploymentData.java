package cn.stylefeng.guns.modular.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (New8equipmentDeploymentData)表实体类
 *
 * @author makejava
 * @since 2021-11-26 15:56:49
 */
@SuppressWarnings("serial")
@TableName("new_8equipment_deployment_data")
public class New8equipmentDeploymentData extends Model<New8equipmentDeploymentData> {
    //装备部署数据序号
    private int equipmentDeploymentDataId;
    //机型
    private String jx;
    //部队
    private String troop;
    //部署时间
    private String deplomentTime;
    //部署数量
    private String deplomentNumber;


    public int getEquipmentDeploymentDataId() {
        return equipmentDeploymentDataId;
    }

    public void setEquipmentDeploymentDataId(int equipmentDeploymentDataId) {
        this.equipmentDeploymentDataId = equipmentDeploymentDataId;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getTroop() {
        return troop;
    }

    public void setTroop(String troop) {
        this.troop = troop;
    }

    public String getDeplomentTime() {
        return deplomentTime;
    }

    public void setDeplomentTime(String deplomentTime) {
        this.deplomentTime = deplomentTime;
    }

    public String getDeplomentNumber() {
        return deplomentNumber;
    }

    public void setDeplomentNumber(String deplomentNumber) {
        this.deplomentNumber = deplomentNumber;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.equipmentDeploymentDataId;
    }
}
