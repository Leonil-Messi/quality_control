package cn.stylefeng.guns.modular.demo.controller;


import cn.stylefeng.guns.modular.demo.entity.New6keypartsManufacturingdata;
import cn.stylefeng.guns.modular.demo.entity.problem46;
import cn.stylefeng.guns.modular.demo.entity.problem48;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.stylefeng.guns.modular.demo.entity.New7experimentalDataOfFaultyParts;
import cn.stylefeng.guns.modular.demo.service.New7experimentalDataOfFaultyPartsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (New7experimentalDataOfFaultyParts)表控制层
 *
 * @author makejava
 * @since 2021-11-26 15:56:49
 */
@RestController
@RequestMapping("new7experimentalDataOfFaultyParts")
public class New7experimentalDataOfFaultyPartsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private New7experimentalDataOfFaultyPartsService new7experimentalDataOfFaultyPartsService;

    @Resource
    private cn.stylefeng.guns.modular.demo.dao.New7experimentalDataOfFaultyPartsDao New7experimentalDataOfFaultyPartsDao;


    @RequestMapping("/listall")
    public Map<String, Object> list(int limit, int page) {
        List<New7experimentalDataOfFaultyParts> new7experimentalDataOfFaultyParts = this.new7experimentalDataOfFaultyPartsService.list();
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", MmyUtil.page(limit, page,new7experimentalDataOfFaultyParts));
        mapTable.put("code", 0);
        mapTable.put("count", new7experimentalDataOfFaultyParts.size());
        return mapTable;
    }
    /**
     * 分页查询所有数据
     *
     * @param page                              分页对象
     * @param new7experimentalDataOfFaultyParts 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<New7experimentalDataOfFaultyParts> page, New7experimentalDataOfFaultyParts new7experimentalDataOfFaultyParts) {
        return success(this.new7experimentalDataOfFaultyPartsService.page(page, new QueryWrapper<>(new7experimentalDataOfFaultyParts)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.new7experimentalDataOfFaultyPartsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param new7experimentalDataOfFaultyParts 实体对象
     * @return 新增结果
     */
    @PostMapping("addData")
    public R insert(@RequestBody List<New7experimentalDataOfFaultyParts> new7experimentalDataOfFaultyParts) {
        return success(this.new7experimentalDataOfFaultyPartsService.saveBatch(new7experimentalDataOfFaultyParts));
    }
    @RequestMapping(path = "getId")
    public R getId() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("Experimental_data_of_faulty_parts_id");
        return success(this.new7experimentalDataOfFaultyPartsService.listMaps(wrapper));
    }

    /**
     * 修改数据
     *
     * @param new7experimentalDataOfFaultyParts 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody New7experimentalDataOfFaultyParts new7experimentalDataOfFaultyParts) {
        return success(this.new7experimentalDataOfFaultyPartsService.updateById(new7experimentalDataOfFaultyParts));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.new7experimentalDataOfFaultyPartsService.removeByIds(idList));
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

}
