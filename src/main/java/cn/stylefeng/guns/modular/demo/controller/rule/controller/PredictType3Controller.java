package cn.stylefeng.guns.modular.demo.controller.rule.controller;

import cn.hutool.core.util.StrUtil;
import cn.stylefeng.guns.modular.demo.dao.New3finishedProductDesignDataDao;
import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;
import cn.stylefeng.guns.modular.demo.service.New3finishedProductDesignDataService;
import cn.stylefeng.guns.modular.demo.vo.Predict1VO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Yyk.
 * @date 2021/12/6 9:25
 */
@RestController
@RequestMapping("rule")
public class PredictType3Controller {
    @Resource
    private New3finishedProductDesignDataService new3finishedProductDesignDataService;
    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;


    @Resource
    New3finishedProductDesignDataDao new3finishedProductDesignDataDao;

    //predict8
    @RequestMapping("predict8")
    public R predict8() {
        //先获取高爆发模式
        List highModeList = anaysis11();

        //返回结果
        List result = new ArrayList();

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.groupBy("jx");
        wrapper.groupBy("failure_mode");

        List<New1qualityProblemData> itemList = this.new1qualityProblemDataService.list(wrapper);

        //依次遍历，获得不在高爆发数组内的
        for (int i = 0; i < itemList.size(); i++) {
            String failureMode = itemList.get(i).getFailureMode();
            if ( highModeList.contains(failureMode)) {
                result.add(itemList.get(i));
            }
        }
        System.out.println(this.new1qualityProblemDataService.list(wrapper).size());
        return R.ok(result);
    }

    //分析维度11
    //返回： 高爆发故障模式
    @RequestMapping("anaysis11")
    public List anaysis11() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("count(*) as nums,failure_mode");
        wrapper.groupBy("failure_mode");
        List<Map<String,Object>> listMaps = this.new1qualityProblemDataService.listMaps(wrapper);
//return success(listMaps);
        List highMode = new ArrayList();
        int num = 0;

        /*获得所有的模式数量*/
        for (int i = 0; i < listMaps.size(); i++) {
            System.out.println(listMaps.get(i).get("nums"));
            Number num1 = (Number) listMaps.get(i).get("nums");
            num +=num1.intValue();
        }
        //看每个模式是否超过平均发生数
        float avgOccur = num/listMaps.size();
        float standAvg = (float) 1.1;
        for (int i = 0; i < listMaps.size(); i++) {
            Number num2 = (Number) listMaps.get(i).get("nums");
            float currentNum = Float.valueOf(num2.intValue());
            //超标
            if (currentNum/avgOccur > standAvg) {
                highMode.add(listMaps.get(i).get("failure_mode"));
            }
        }
        return highMode;

    }

}
