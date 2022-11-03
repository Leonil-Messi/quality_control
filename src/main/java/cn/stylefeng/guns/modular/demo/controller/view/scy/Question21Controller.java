package cn.stylefeng.guns.modular.demo.controller.view.scy;

import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

@RestController
@RequestMapping("/data")
public class Question21Controller extends ApiController {

    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;




    @GetMapping("/question21")
    public R question21() {
        //数据容器
        List<String> typeList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        //查询故障件种类
        List<New1qualityProblemData> types = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .select("faultyparts_type")
                .groupBy("faultyparts_type")
                .orderByDesc("faultyparts_type")
        );
        //查询每个种类的故障件个数
        for (New1qualityProblemData data : types) {
            int count = new1qualityProblemDataService.count(new QueryWrapper<New1qualityProblemData>()
                    .select("faultyparts_title")
                    .eq("faultyparts_type", data.getFaultypartsType())
            );
            //将故障件种类和个数存入数据容器中
            typeList.add(data.getFaultypartsType());
            numList.add(count);
        }

        Map<String, List> map = new HashMap<>();
        map.put("typeList", typeList);
        map.put("numList", numList);
        return success(map);
    }







}

