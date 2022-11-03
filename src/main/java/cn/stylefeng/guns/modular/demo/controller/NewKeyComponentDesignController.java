package cn.stylefeng.guns.modular.demo.controller;


import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.stylefeng.guns.modular.demo.entity.NewKeyComponentDesign;
import cn.stylefeng.guns.modular.demo.service.NewKeyComponentDesignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (NewKeyComponentDesign)表控制层
 *
 * @author makejava
 * @since 2021-11-24 15:45:03
 */
@RestController
@RequestMapping("newKeyComponentDesign")
public class NewKeyComponentDesignController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private NewKeyComponentDesignService newKeyComponentDesignService;



    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @RequestMapping(path = "/getAll")
    public R selectAll() {
        return success(this.newKeyComponentDesignService.list());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping
    public R selectOne(@PathVariable Serializable id) {
        return success(this.newKeyComponentDesignService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param newKeyComponentDesign 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody NewKeyComponentDesign newKeyComponentDesign) {

        return success(this.newKeyComponentDesignService.save(newKeyComponentDesign));
    }

    /**
     * 修改数据
     *
     * @param newKeyComponentDesign 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody NewKeyComponentDesign newKeyComponentDesign) {
        return success(this.newKeyComponentDesignService.updateById(newKeyComponentDesign));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.newKeyComponentDesignService.removeByIds(idList));
    }
}
