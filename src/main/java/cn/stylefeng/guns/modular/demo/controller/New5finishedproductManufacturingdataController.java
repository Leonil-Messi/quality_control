package cn.stylefeng.guns.modular.demo.controller;


import cn.stylefeng.guns.modular.demo.dao.New5finishedproductManufacturingdataDao;
import cn.stylefeng.guns.modular.demo.entity.New4keypartsDesigndata;
import cn.stylefeng.guns.modular.demo.entity.problem44;
import cn.stylefeng.guns.modular.demo.entity.problem48;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.stylefeng.guns.modular.demo.entity.New5finishedproductManufacturingdata;
import cn.stylefeng.guns.modular.demo.service.New5finishedproductManufacturingdataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (New5finishedproductManufacturingdata)表控制层
 *
 * @author makejava
 * @since 2021-11-26 15:56:47
 */
@RestController
@RequestMapping("new5finishedproductManufacturingdata")
public class New5finishedproductManufacturingdataController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private New5finishedproductManufacturingdataService new5finishedproductManufacturingdataService;


    @Resource
    private New5finishedproductManufacturingdataDao new5finishedproductManufacturingdataDao;

    /**
     * 分页查询所有数据
     *
     * @param page                                 分页对象
     * @param new5finishedproductManufacturingdata 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<New5finishedproductManufacturingdata> page, New5finishedproductManufacturingdata new5finishedproductManufacturingdata) {
        return success(this.new5finishedproductManufacturingdataService.page(page, new QueryWrapper<>(new5finishedproductManufacturingdata)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.new5finishedproductManufacturingdataService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param new5finishedproductManufacturingdata 实体对象
     * @return 新增结果
     */
    @PostMapping("addData")
    public R insert(@RequestBody List<New5finishedproductManufacturingdata> new5finishedproductManufacturingdata) {
        return success(this.new5finishedproductManufacturingdataService.saveBatch(new5finishedproductManufacturingdata));
    }
    @RequestMapping(path = "getId")
    public R getId() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("faulty_id");
        return success(this.new5finishedproductManufacturingdataService.listMaps(wrapper));
    }

    /**
     * 修改数据
     *
     * @param new5finishedproductManufacturingdata 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody New5finishedproductManufacturingdata new5finishedproductManufacturingdata) {
        return success(this.new5finishedproductManufacturingdataService.updateById(new5finishedproductManufacturingdata));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.new5finishedproductManufacturingdataService.removeByIds(idList));
    }
    @RequestMapping("/listall")
    public Map<String, Object> list(int limit, int page) {
        List<New5finishedproductManufacturingdata> new5finishedproductManufacturingdata = this.new5finishedproductManufacturingdataService.list();
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", MmyUtil.page(limit, page,new5finishedproductManufacturingdata));
        mapTable.put("code", 0);
        mapTable.put("count", new5finishedproductManufacturingdata.size());
        return mapTable;
    }

    @RequestMapping(path="problem36")
    public R problem36() {

        return success(this.new5finishedproductManufacturingdataDao.problem36back());

    }




    @RequestMapping(path="problem36tab")

    public Map<String, Object>  problem36tab(Integer limit,Integer page) {
        int sum=0;int avg;
        List<problem44> list=this.new5finishedproductManufacturingdataDao.problem36back();
        int wrona[]= new int[list.size()];
        List<problem44> wrongobj = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++){
            sum=Integer.parseInt(list.get(i).getValue())+sum;
        }
        avg=sum/5;
        for (int i = 0, j=0; i < list.size(); i++){
            int a=Integer.parseInt(list.get(i).getValue());
            if(a>=avg) {
                wrona[j]=1;
                j++;

            }
            else{wrona[j]=0;j++;}
        }

        for (int i = 0; i < wrona.length; i++){
            if(wrona[i]==1){
                wrongobj.add(list.get(i));

            }
        }
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", page(limit, page, wrongobj));
        mapTable.put("code", 0);
        mapTable.put("count", wrongobj.size());
        return mapTable;

    }


    @RequestMapping(path="problem37")
    public R problem37() {
        return success(this.new5finishedproductManufacturingdataDao.problem37back());

    }




    @RequestMapping(path="problem37tab")

    public Map<String, Object>  problem37tab(Integer limit,Integer page) {
        int sum2=0;int avg2;
        List<problem44> list=this.new5finishedproductManufacturingdataDao.problem37back();
        int wrona[]= new int[list.size()];
        List<problem44> wrongobj = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++){
            sum2=Integer.parseInt(list.get(i).getValue())+sum2;
        }
        avg2=sum2/5;
        for (int i = 0, j=0; i < list.size(); i++){
            int a=Integer.parseInt(list.get(i).getValue());
            if(a>=avg2) {
                wrona[j]=1;
                j++;

            }
            else{wrona[j]=0;j++;}
        }

        for (int i = 0; i < wrona.length; i++){
            if(wrona[i]==1){
                wrongobj.add(list.get(i));

            }
        }
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", page(limit, page, wrongobj));
        mapTable.put("code", 0);
        mapTable.put("count", wrongobj.size());
        return mapTable;

    }

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
