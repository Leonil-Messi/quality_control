package cn.stylefeng.guns.modular.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (New9zbUseData)表实体类
 *
 * @author makejava
 * @since 2021-12-03 17:53:11
 */
@SuppressWarnings("serial")
@TableName("new_9zb_use_data")
public class New9zbUseData extends Model<New9zbUseData> {
    //ZB使用数据序号
    private Integer zbUseDataId;
    //年月
    private String yearmonth;
    //机型
    private String jx;
    //部队
    private String troop;
    //飞行小时
    private String flyHours;
    //执行任务种类
    private String taskType;
    //执行任务次数
    private String taskFrequency;


    public Integer getZbUseDataId() {
        return zbUseDataId;
    }

    public void setZbUseDataId(Integer zbUseDataId) {
        this.zbUseDataId = zbUseDataId;
    }

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth;
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

    public String getFlyHours() {
        return flyHours;
    }

    public void setFlyHours(String flyHours) {
        this.flyHours = flyHours;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskFrequency() {
        return taskFrequency;
    }

    public void setTaskFrequency(String taskFrequency) {
        this.taskFrequency = taskFrequency;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.zbUseDataId;
    }
    }

