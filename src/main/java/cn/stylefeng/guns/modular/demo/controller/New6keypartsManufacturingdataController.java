package cn.stylefeng.guns.modular.demo.controller;


import cn.stylefeng.guns.modular.demo.dao.New6keypartsManufacturingdataDao;
import cn.stylefeng.guns.modular.demo.entity.New5finishedproductManufacturingdata;
import cn.stylefeng.guns.modular.demo.entity.problem46;
import cn.stylefeng.guns.modular.demo.entity.problem48;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.stylefeng.guns.modular.demo.entity.New6keypartsManufacturingdata;
import cn.stylefeng.guns.modular.demo.service.New6keypartsManufacturingdataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (New6keypartsManufacturingdata)表控制层
 *
 * @author makejava
 * @since 2021-11-26 15:56:48
 */
@RestController
@RequestMapping("new6keypartsManufacturingdata")
public class New6keypartsManufacturingdataController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private New6keypartsManufacturingdataService new6keypartsManufacturingdataService;


    @Resource
    private cn.stylefeng.guns.modular.demo.dao.New7experimentalDataOfFaultyPartsDao New7experimentalDataOfFaultyPartsDao;

    @Resource
    private New6keypartsManufacturingdataDao new6keypartsManufacturingdataDao;

    @RequestMapping("/listall")
    public Map<String, Object> list(int limit, int page) {
        List<New6keypartsManufacturingdata> new6keypartsManufacturingdata = this.new6keypartsManufacturingdataService.list();
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", MmyUtil.page(limit, page,new6keypartsManufacturingdata));
        mapTable.put("code", 0);
        mapTable.put("count", new6keypartsManufacturingdata.size());
        return mapTable;
    }
    /**
     * 分页查询所有数据
     *
     * @param page                          分页对象
     * @param new6keypartsManufacturingdata 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<New6keypartsManufacturingdata> page, New6keypartsManufacturingdata new6keypartsManufacturingdata) {
        return success(this.new6keypartsManufacturingdataService.page(page, new QueryWrapper<>(new6keypartsManufacturingdata)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.new6keypartsManufacturingdataService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param new6keypartsManufacturingdata 实体对象
     * @return 新增结果
     */
    @PostMapping("addData")
    public R insert(@RequestBody List<New6keypartsManufacturingdata> new6keypartsManufacturingdata) {
        return success(this.new6keypartsManufacturingdataService.saveBatch(new6keypartsManufacturingdata));
    }
    @RequestMapping(path = "getId")
    public R getId() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("key_id");
        return success(this.new6keypartsManufacturingdataService.listMaps(wrapper));
    }

    /**
     * 修改数据
     *
     * @param new6keypartsManufacturingdata 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody New6keypartsManufacturingdata new6keypartsManufacturingdata) {
        return success(this.new6keypartsManufacturingdataService.updateById(new6keypartsManufacturingdata));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.new6keypartsManufacturingdataService.removeByIds(idList));
    }

    @RequestMapping(path="problem46")

    public Map<String, Object> problem46(Integer limit,Integer page) {
        List<problem46> list=this.New7experimentalDataOfFaultyPartsDao.problem46back();
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", page(limit, page, list));
        mapTable.put("code", 0);
        mapTable.put("count", list.size());
        return mapTable;

    }

    @RequestMapping(path="problem48")

    public Map<String, Object> problem48(Integer limit,Integer page) {
        List<problem48> list=this.New7experimentalDataOfFaultyPartsDao.problem48back();
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", page(limit, page, list));
        mapTable.put("code", 0);
        mapTable.put("count", list.size());
        return mapTable;

    }

    //前端表格分页
    public List page(Integer limit,Integer page,List list){
        if (limit == null || page == null||limit<0||page<0) {
            return list;
        }
        int start = (page - 1) * limit;
        int end = page * limit;
        if(start>list.size()){
            return new ArrayList<Object>();
        }else if(end>list.size()){
            return list.subList(start, list.size());
        }
        return list.subList(start, end);
    }
    @RequestMapping(path="problem43")
    public R problem43() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("count(*) as value,EXTRACT(YEAR FROM key_testlasttime) AS Year,EXTRACT(MONTH FROM key_testlasttime) AS Month");
        wrapper.groupBy("Year,Month");
        wrapper.orderByDesc("Year,Month");


        return success(this.new6keypartsManufacturingdataService.listMaps(wrapper));
    }
    @RequestMapping(path="problem42")
    public Map<String, Object> problem42(Integer limit, Integer page) {
        List<New6keypartsManufacturingdata> list=this.new6keypartsManufacturingdataService.list();
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", page(limit, page, list));
        mapTable.put("code", 0);
        mapTable.put("count", list.size());
        return mapTable;

    }
    @RequestMapping(path="problem44")
    public R problem44() {

        return success(this.new6keypartsManufacturingdataDao.problem44back());

    }
    @RequestMapping(path="problem45")
    public R problem45() {
        return success(this.new6keypartsManufacturingdataDao.problem45back());
    }


}
