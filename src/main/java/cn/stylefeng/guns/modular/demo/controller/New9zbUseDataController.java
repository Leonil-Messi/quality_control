package cn.stylefeng.guns.modular.demo.controller;



import cn.stylefeng.guns.modular.demo.controller.view.scy.Util;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.stylefeng.guns.modular.demo.entity.New9zbUseData;
import cn.stylefeng.guns.modular.demo.service.New9zbUseDataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (New9zbUseData)表控制层
 *
 * @author makejava
 * @since 2021-12-03 17:53:09
 */
@RestController
@RequestMapping("new9zbUseData")
public class New9zbUseDataController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private New9zbUseDataService new9zbUseDataService;

    @RequestMapping("/listall")
    public Map<String, Object> list(int limit, int page) {
        List<New9zbUseData> new9zbUseData = this.new9zbUseDataService.list();
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", MmyUtil.page(limit, page,new9zbUseData));
        mapTable.put("code", 0);
        mapTable.put("count", new9zbUseData.size());
        return mapTable;
    }
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param new9zbUseData 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<New9zbUseData> page, New9zbUseData new9zbUseData) {
        return success(this.new9zbUseDataService.page(page, new QueryWrapper<>(new9zbUseData)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.new9zbUseDataService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param new9zbUseData 实体对象
     * @return 新增结果
     */
    @PostMapping("addData")
    public R insert(@RequestBody List<New9zbUseData> new9zbUseData) {
        return success(this.new9zbUseDataService.saveBatch(new9zbUseData));
    }
    @RequestMapping(path = "getId")
    public R getId() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("ZB_use_data_id");
        return success(this.new9zbUseDataService.listMaps(wrapper));
    }

    @RequestMapping(path = "problem6")
    public R problem6() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("jx,yearmonth,fly_hours");
        wrapper.ne("yearmonth","1949-01-01");
        return success(this.new9zbUseDataService.listMaps(wrapper));
    }
    @RequestMapping(path = "problem14")
    public R problem14() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("task_type,yearmonth");
        wrapper.ne("yearmonth","1949-01-01");
        return success(this.new9zbUseDataService.listMaps(wrapper));
    }
    @RequestMapping("/question14/table")
    public Map<String, Object> question14Table(String[] s,String[] t,int limit,int page){
        List<New9zbUseData> resultList = new ArrayList<>();
        for (int i =0;i<s.length;i++) {
            List<New9zbUseData> dataList = new9zbUseDataService.list(new QueryWrapper<New9zbUseData>()
                    .eq("DATE_FORMAT(yearmonth,'%Y%m')", s[i]).eq("task_type",t[i])
            );
                resultList.addAll(dataList);
        }
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", Util.page(limit, page, resultList));
        mapTable.put("code", 0);
        mapTable.put("count", resultList.size());
        return mapTable;
    }
    /**
     * 修改数据
     *
     * @param new9zbUseData 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody New9zbUseData new9zbUseData) {
        return success(this.new9zbUseDataService.updateById(new9zbUseData));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.new9zbUseDataService.removeByIds(idList));
    }
}

