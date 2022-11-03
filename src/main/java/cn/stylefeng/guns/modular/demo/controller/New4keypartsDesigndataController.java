package cn.stylefeng.guns.modular.demo.controller;


import cn.stylefeng.guns.modular.demo.entity.New3finishedProductDesignData;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.stylefeng.guns.modular.demo.entity.New4keypartsDesigndata;
import cn.stylefeng.guns.modular.demo.service.New4keypartsDesigndataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (New4keypartsDesigndata)表控制层
 *
 * @author makejava
 * @since 2021-11-26 15:56:47
 */
@RestController
@RequestMapping("new4keypartsDesigndata")
public class New4keypartsDesigndataController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private New4keypartsDesigndataService new4keypartsDesigndataService;

    /**
     * 分页查询所有数据
     *
     * @param page                   分页对象
     * @param new4keypartsDesigndata 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<New4keypartsDesigndata> page, New4keypartsDesigndata new4keypartsDesigndata) {
        return success(this.new4keypartsDesigndataService.page(page, new QueryWrapper<>(new4keypartsDesigndata)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.new4keypartsDesigndataService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param new4keypartsDesigndata 实体对象
     * @return 新增结果
     */
    @PostMapping("addData")
    public R insert(@RequestBody List<New4keypartsDesigndata> new4keypartsDesigndata) {
        return success(this.new4keypartsDesigndataService.saveBatch(new4keypartsDesigndata));
    }
    @RequestMapping(path = "getId")
    public R getId() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("keydesign_id");
        return success(this.new4keypartsDesigndataService.listMaps(wrapper));
    }

    /**
     * 修改数据
     *
     * @param new4keypartsDesigndata 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody New4keypartsDesigndata new4keypartsDesigndata) {
        return success(this.new4keypartsDesigndataService.updateById(new4keypartsDesigndata));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.new4keypartsDesigndataService.removeByIds(idList));
    }
    @RequestMapping("/listall")
    public Map<String, Object> list(int limit, int page) {
        List<New4keypartsDesigndata> new4keypartsDesigndata = this.new4keypartsDesigndataService.list();
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", MmyUtil.page(limit, page,new4keypartsDesigndata));
        mapTable.put("code", 0);
        mapTable.put("count", new4keypartsDesigndata.size());
        return mapTable;
    }
}
