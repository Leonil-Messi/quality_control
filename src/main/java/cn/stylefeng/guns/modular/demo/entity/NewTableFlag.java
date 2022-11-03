package cn.stylefeng.guns.modular.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@SuppressWarnings("serial")
@TableName("new_tableflag")
public class NewTableFlag {
    @TableId(value = "table_id")
    private int tableId;
    private String flag;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
