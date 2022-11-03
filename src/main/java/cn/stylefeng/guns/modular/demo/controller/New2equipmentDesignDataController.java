package cn.stylefeng.guns.modular.demo.controller;


import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import cn.stylefeng.guns.modular.demo.entity.New3finishedProductDesignData;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.stylefeng.guns.modular.demo.entity.New2equipmentDesignData;
import cn.stylefeng.guns.modular.demo.service.New2equipmentDesignDataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (New2equipmentDesignData)表控制层
 *
 * @author makejava
 * @since 2021-11-26 15:56:45
 */
@RestController
@RequestMapping("new2equipmentDesignData")
public class New2equipmentDesignDataController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private New2equipmentDesignDataService new2equipmentDesignDataService;




    @RequestMapping(path = "lzytest")
    public R lzytest() {
        return success(this.new2equipmentDesignDataService.list());

    }

    @RequestMapping(path = "problem7")
    public R problem7() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("zb_modification_time,zb_modification_measures");
        return success(this.new2equipmentDesignDataService.listMaps(wrapper));
    }
    @PostMapping("addData")
    public R insert(@RequestBody List<New2equipmentDesignData> new2equipmentDesignData) {
        return success(this.new2equipmentDesignDataService.saveBatch(new2equipmentDesignData));
    }
    @RequestMapping(path = "getId")
    public R getId() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("design_id");
        return success(this.new2equipmentDesignDataService.listMaps(wrapper));
    }
    @RequestMapping("/listall")
    public Map<String, Object> list(int limit, int page) {
        List<New2equipmentDesignData> new2equipmentDesignDataa = this.new2equipmentDesignDataService.list();
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", MmyUtil.page(limit, page,new2equipmentDesignDataa));
        mapTable.put("code", 0);
        mapTable.put("count", new2equipmentDesignDataa.size());
        return mapTable;
    }
}
