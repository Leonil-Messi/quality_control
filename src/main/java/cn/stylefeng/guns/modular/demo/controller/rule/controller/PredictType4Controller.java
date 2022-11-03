package cn.stylefeng.guns.modular.demo.controller.rule.controller;

import cn.hutool.core.util.StrUtil;
import cn.stylefeng.guns.modular.demo.dao.New3finishedProductDesignDataDao;
import cn.stylefeng.guns.modular.demo.entity.New9zbUseData;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;
import cn.stylefeng.guns.modular.demo.service.New3finishedProductDesignDataService;
import cn.stylefeng.guns.modular.demo.service.New9zbUseDataService;
import cn.stylefeng.guns.modular.demo.vo.Predict1VO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yyk.
 * @date 2021/12/6 9:25
 */
@RestController
@RequestMapping("rule")
public class PredictType4Controller {
    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;

    @Resource
    private New9zbUseDataService new9zbUseDataService;

    //分析维度13
    //也是 predict17
    //返回： 高发 地理环境
    @RequestMapping("anaysis13")
    public R anaysis13() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("count(*) as nums,environment, jx, faultyparts_title");
        wrapper.groupBy("environment");
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
        //看每个environment是否超过平均发生数
        float avgOccur = num/listMaps.size();
        float standAvg = (float) 1.1;
        for (int i = 0; i < listMaps.size(); i++) {
            Number num2 = (Number) listMaps.get(i).get("nums");
            float currentNum = Float.valueOf(num2.intValue());
            //超标
            if (currentNum/avgOccur > standAvg) {
                HashMap hashMap=  new HashMap();
                hashMap.put("envir",listMaps.get(i).get("environment"));
                hashMap.put("jx",listMaps.get(i).get("jx"));
                hashMap.put("faultyparts_title",listMaps.get(i).get("faultyparts_title"));
                highMode.add(hashMap);
            }
        }
        return R.ok(highMode);
    }

    @RequestMapping("predict18")
    public R predict18() {
        R r = this.anaysis14();
        return null;
    }

    //分析维度 14
    @RequestMapping("anaysis14")
    public R anaysis14() {

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByAsc("yearmonth");

        List<New9zbUseData> listObjs = this.new9zbUseDataService.list(wrapper);

        List ruleTime1 = new ArrayList();
        List ruleTime2 = new ArrayList();
        List ruleTime3 = new ArrayList();

        // 获取第一个质量问题数
        // j为后指针
        int j = 0;
        int firstNum1 = Integer.parseInt(String.valueOf(listObjs.get(j).getTaskFrequency() ));

        // 连续两个时间段变化
        String instantTime2 =  (listObjs.get(j).getYearmonth());
        int idx2 = 0;
        int firstNum2 = Integer.parseInt(String.valueOf(listObjs.get(j).getTaskFrequency() ));

        // 连续三个时间段呈单调形式
        String instantTime3 =  (listObjs.get(j).getYearmonth());
        int idx3 = 0;
        boolean LastDifferFlag = false;
        int firstNum3 = Integer.parseInt(String.valueOf(listObjs.get(j).getTaskFrequency() ));

        for (int i = 1; i < listObjs.size(); i++) {
            // 获取当前质量问题数
            int currentNum = Integer.parseInt(String.valueOf(listObjs.get(i).getTaskFrequency() ));

            // 根据分析方式 1：
            float ox1 = (currentNum - firstNum1) / firstNum1;
            float abs1 = Math.abs(ox1);
            if (abs1 > 0.5) {
                // 该时间为直连发生时间
                ruleTime1.add(listObjs.get(i).getYearmonth());
            }
            firstNum1 = currentNum;

            // 分析方式 2
            float ox2 = (currentNum - firstNum2) / firstNum2;
            float abs2 = Math.abs(ox2);

            if (abs2 > 0.2) {
                idx2++;

                ruleTime2.add(listObjs.get(i).getYearmonth());
            }else {
                //连续两个时间段满足条件，获取开始变化的时候
                if (idx2 >= 2){
                    ruleTime2.add(instantTime2);
                }

                // 不满足，赋空
                idx2 = 0;
                instantTime2 =  (listObjs.get(i).getYearmonth());
            }
            firstNum2 = currentNum;

            // 分析方式 3
            int differ = currentNum - firstNum3;
            boolean differFlag = differ > 0 ? true :false;

            //本次单调和上次单调相同
            if (LastDifferFlag == differFlag) {
                idx3++;
            }else {
                // 是否满足连续三次，
                if (idx3 >= 3){
                    ruleTime3.add(instantTime3);
                }
                // 不满足，赋空
                idx3 = 0;
                instantTime3 =  (listObjs.get(i).getYearmonth());

                LastDifferFlag = differFlag;
            }
            firstNum3 = currentNum;

        }
        System.out.println(ruleTime1.toString());
        System.out.println(ruleTime2.toString());
        System.out.println(ruleTime3.toString());
        //r.add(jxList.get(m).get("jx"));

        List r = new ArrayList();
        r.add(ruleTime1);
        r.add(ruleTime2);
        r.add(ruleTime3);

        return R.ok(r);
    }

}
