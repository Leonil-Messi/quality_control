package cn.stylefeng.guns.modular.demo.controller;


import cn.stylefeng.guns.modular.demo.entity.New2equipmentDesignData;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.stylefeng.guns.modular.demo.entity.New3finishedProductDesignData;
import cn.stylefeng.guns.modular.demo.service.New3finishedProductDesignDataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (New3finishedProductDesignData)表控制层
 *
 * @author makejava
 * @since 2021-11-26 15:56:46
 */
@RestController
@RequestMapping("new3finishedProductDesignData")
public class New3finishedProductDesignDataController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private New3finishedProductDesignDataService new3finishedProductDesignDataService;

    /**
     * 分页查询所有数据
     *
     * @param page                          分页对象
     * @param new3finishedProductDesignData 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<New3finishedProductDesignData> page, New3finishedProductDesignData new3finishedProductDesignData) {
        return success(this.new3finishedProductDesignDataService.page(page, new QueryWrapper<>(new3finishedProductDesignData)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.new3finishedProductDesignDataService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param new3finishedProductDesignData 实体对象
     * @return 新增结果
     */
    @PostMapping("addData")
    public R insert(@RequestBody List<New3finishedProductDesignData> new3finishedProductDesignData) {
        return success(this.new3finishedProductDesignDataService.saveBatch(new3finishedProductDesignData));
    }
    @RequestMapping(path = "getId")
    public R getId() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("fin_design_id");
        return success(this.new3finishedProductDesignDataService.listMaps(wrapper));
    }

    /**
     * 修改数据
     *
     * @param new3finishedProductDesignData 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody New3finishedProductDesignData new3finishedProductDesignData) {
        return success(this.new3finishedProductDesignDataService.updateById(new3finishedProductDesignData));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.new3finishedProductDesignDataService.removeByIds(idList));
    }

    @RequestMapping(path = "problem8")
    public R problem8() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("modify_time,modify_measures");
        return success(this.new3finishedProductDesignDataService.listMaps(wrapper));
    }
    @RequestMapping("/listall")
    public Map<String, Object> list(int limit, int page) {
        List<New3finishedProductDesignData> new3finishedProductDesignData = this.new3finishedProductDesignDataService.list();
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", MmyUtil.page(limit, page,new3finishedProductDesignData));
        mapTable.put("code", 0);
        mapTable.put("count", new3finishedProductDesignData.size());
        return mapTable;
    }
}
