package cn.stylefeng.guns.modular.demo.controller;


import cn.stylefeng.guns.modular.demo.entity.New7experimentalDataOfFaultyParts;
import cn.stylefeng.guns.modular.demo.entity.New9zbUseData;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.stylefeng.guns.modular.demo.entity.New8equipmentDeploymentData;
import cn.stylefeng.guns.modular.demo.service.New8equipmentDeploymentDataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (New8equipmentDeploymentData)表控制层
 *
 * @author makejava
 * @since 2021-11-26 15:56:49
 */
@RestController
@RequestMapping("new8equipmentDeploymentData")
public class New8equipmentDeploymentDataController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private New8equipmentDeploymentDataService new8equipmentDeploymentDataService;

    @RequestMapping("/listall")
    public Map<String, Object> list(int limit, int page) {
        List<New8equipmentDeploymentData> new8equipmentDeploymentData = this.new8equipmentDeploymentDataService.list();
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", MmyUtil.page(limit, page,new8equipmentDeploymentData));
        mapTable.put("code", 0);
        mapTable.put("count", new8equipmentDeploymentData.size());
        return mapTable;
    }
    /**
     * 分页查询所有数据
     *
     * @param page                        分页对象
     * @param new8equipmentDeploymentData 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<New8equipmentDeploymentData> page, New8equipmentDeploymentData new8equipmentDeploymentData) {
        return success(this.new8equipmentDeploymentDataService.page(page, new QueryWrapper<>(new8equipmentDeploymentData)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.new8equipmentDeploymentDataService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param new8equipmentDeploymentData 实体对象
     * @return 新增结果
     */
    @PostMapping("addData")
    public R insert(@RequestBody List<New8equipmentDeploymentData> new8equipmentDeploymentData) {
        return success(this.new8equipmentDeploymentDataService.saveBatch(new8equipmentDeploymentData));
    }
    @RequestMapping(path = "getId")
    public R getId() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("Equipment_deployment_data_id");
        return success(this.new8equipmentDeploymentDataService.listMaps(wrapper));
    }

    /**
     * 修改数据
     *
     * @param new8equipmentDeploymentData 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody New8equipmentDeploymentData new8equipmentDeploymentData) {
        return success(this.new8equipmentDeploymentDataService.updateById(new8equipmentDeploymentData));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.new8equipmentDeploymentDataService.removeByIds(idList));
    }
    @RequestMapping(path = "problem5")
    public R problem5() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("deploment_time,jx,deploment_number");
        wrapper.ne("deploment_time","1949-01-01");
        return success(this.new8equipmentDeploymentDataService.listMaps(wrapper));
    }
}
