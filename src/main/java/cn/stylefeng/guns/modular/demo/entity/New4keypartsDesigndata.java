package cn.stylefeng.guns.modular.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (New4keypartsDesigndata)表实体类
 *
 * @author makejava
 * @since 2021-11-26 15:56:46
 */
@SuppressWarnings("serial")
@TableName("new_4keyparts_designdata")
public class New4keypartsDesigndata extends Model<New4keypartsDesigndata> {
    //序号
    private int keydesignId;
    //JX
    private String jx;
    //故障件名称
    private String faultypartsTitle;
    //故障件型号
    private String faultpartsModel;
    //关键件名称
    private String keyName;


    public int getKeydesignId() {
        return keydesignId;
    }

    public void setKeydesignId(int keydesignId) {
        this.keydesignId = keydesignId;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
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

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.keydesignId;
    }
}
