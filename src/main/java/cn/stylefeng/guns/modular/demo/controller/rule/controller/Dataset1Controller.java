package cn.stylefeng.guns.modular.demo.controller.rule.controller;


import cn.hutool.core.util.StrUtil;
import cn.stylefeng.guns.modular.demo.dao.New3finishedProductDesignDataDao;
import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import cn.stylefeng.guns.modular.demo.entity.New7experimentalDataOfFaultyParts;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;
import cn.stylefeng.guns.modular.demo.service.New3finishedProductDesignDataService;
import cn.stylefeng.guns.modular.demo.service.New7experimentalDataOfFaultyPartsService;
import cn.stylefeng.guns.modular.demo.vo.Predict1VO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.ibatis.annotations.Select;
import org.junit.Test;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (New1qualityProblemData)表控制层
 *
 * @author makejava
 * @since 2021-12-01 09:26:28
 */
@RestController
@RequestMapping("rule")
public class Dataset1Controller extends ApiController {
    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;

    @Resource
    private New3finishedProductDesignDataService new3finishedProductDesignDataService;

    @Resource
    New3finishedProductDesignDataDao new3finishedProductDesignDataDao;


    @Resource
    private New7experimentalDataOfFaultyPartsService new7experimentalDataOfFaultyPartsService;

    ////predict19
    //@RequestMapping("predict19")
    //public R predict19() {
    //    QueryWrapper wrapper = new QueryWrapper();
    //    wrapper.select("count(*),DATE_FORMAT(time,'%Y-%m') as ctime");
    //    wrapper.groupBy("ctime");
    //
    //    List<Map<String, String>> listMaps = this.new1qualityProblemDataService.listMaps(wrapper);
    //    return success(listMaps);
    //}

    ////predict8
    //@RequestMapping("predict8")
    //public R predict8() {
    //    //先获取高爆发模式
    //    List highModeList = anaysis11();
    //
    //    //返回结果
    //    List result = new ArrayList();
    //
    //    QueryWrapper wrapper = new QueryWrapper();
    //    wrapper.groupBy("jx");
    //    wrapper.groupBy("failure_mode");
    //
    //    List<New1qualityProblemData> itemList = this.new1qualityProblemDataService.list(wrapper);
    //
    //    //依次遍历，获得不在高爆发数组内的
    //    for (int i = 0; i < itemList.size(); i++) {
    //        String failureMode = itemList.get(i).getFailureMode();
    //        if ( highModeList.contains(failureMode)) {
    //            result.add(itemList.get(i));
    //        }
    //    }
    //    System.out.println(this.new1qualityProblemDataService.list(wrapper).size());
    //    return success(result);
    //}
    //


    //@RequestMapping("predict1")
    //public R predict1(){
    //    List<Predict1VO> vos = this.new3finishedProductDesignDataDao.orderUserList();
    //
    //
    //    List result = new ArrayList();
    //    for (int i = 0; i < vos.size(); i++) {
    //        boolean reasonable = predict1Reasonable(vos.get(i));
    //
    //        //不满足条件就加入
    //        if (!reasonable){
    //            result.add(vos.get(i));
    //        }
    //    }
    //    return success(result);
    //}
    //
    //
    ////predict1 预测是否合理
    //public boolean predict1Reasonable(Predict1VO predict1VO) {
    //    String experInput = StrUtil.removeSuffix(predict1VO.getExperimentInput(), "]");
    //    experInput = StrUtil.removePrefix(experInput, "[");
    //    List<String> experInputList = StrUtil.split(experInput, ", ");
    //
    //    //    测试数据
    //    String testInput = StrUtil.removeSuffix(predict1VO.getTestInput(), "]");
    //    testInput = StrUtil.removePrefix(testInput, "[");
    //    List<String> testInputList = StrUtil.split(testInput, ", ");
    //
    //    //设计指标数据
    //    ArrayList<String> target = new ArrayList();
    //    if (predict1VO.getAntivibration().equals("不涉及")) {target.add("0"); }
    //    else {target.add(predict1VO.getAntivibration()); }
    //
    //    if (predict1VO.getHumidityLimit().equals("不涉及")) {target.add("0"); }
    //    else {target.add(predict1VO.getHumidityLimit()); }
    //
    //    if (predict1VO.getTemperatureLimit().equals("不涉及")) {target.add("0"); }
    //    else {target.add(predict1VO.getTemperatureLimit()); }
    //
    //    if (predict1VO.getDesignStrength().equals("不涉及")) {target.add("0"); }
    //    else {target.add(predict1VO.getDesignStrength()); }
    //
    //
    //    System.out.println(target.toString());
    //    for (int i = 0; i < target.size(); i++) {
    //        double a = Double.parseDouble(experInputList.get(i));
    //        double b = Double.parseDouble(testInputList.get(i));
    //        double c = Double.parseDouble(target.get(i));
    //        if ( a > b && b > c) {
    //            //满足推断条件
    //            return true;
    //        }
    //
    //    }
    //
    //    //不满足
    //    return false;
    //
    //}


    //分析维度 1
    @RequestMapping("test")
    public R test(){
        List<Predict1VO> vos = this.new3finishedProductDesignDataDao.orderUserList();
return success(vos);
        //QueryWrapper wrapper = new QueryWrapper();
        //wrapper.groupBy("atime");
        //wrapper.select("count(*), DATE_FORMAT(time, '%Y-%m') as atime");
        //wrapper.orderByAsc("atime");
        //
        //List<HashMap<Object,String>> listObjs = this.new1qualityProblemDataService.listMaps(wrapper);
        //System.out.println(String.valueOf(listObjs.get(0).get("count(*)")));
        //return success(listObjs.get(0).get("count(*)"));
    }



    @RequestMapping("anaysis1")
    public R anaysis1(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.groupBy("atime");
        wrapper.select("count(*), DATE_FORMAT(time, '%Y-%m') as atime");
        wrapper.orderByAsc("atime");

        List<HashMap<Object,String>> listObjs = this.new1qualityProblemDataService.listMaps(wrapper);

        List ruleTime1 = new ArrayList();
        List ruleTime2 = new ArrayList();
        List ruleTime3 = new ArrayList();

        // 获取第一个质量问题数
        // j为后指针
        int j = 0;
        int firstNum1 = Integer.parseInt(String.valueOf(listObjs.get(j).get("count(*)")));

        // 连续两个时间段变化
        String instantTime2 =  (listObjs.get(j).get("atime"));
        int idx2 = 0;
        int firstNum2 = Integer.parseInt(String.valueOf(listObjs.get(j).get("count(*)")));

        // 连续三个时间段呈单调形式
        String instantTime3 =  (listObjs.get(j).get("atime"));
        int idx3 = 0;
        boolean LastDifferFlag = false;
        int firstNum3 = Integer.parseInt(String.valueOf(listObjs.get(j).get("count(*)")));

        for (int i = 1; i < listObjs.size(); i++) {
            // 获取当前质量问题数
            int currentNum = Integer.parseInt(String.valueOf(listObjs.get(i).get("count(*)")));

            // 根据分析方式 1：
            float ox1 = (currentNum - firstNum1) / firstNum1;
            float abs1 = Math.abs(ox1);
            if (abs1 > 0.5) {
                // 该时间为直连发生时间
                ruleTime1.add(listObjs.get(i).get("atime"));
            }
            firstNum1 = currentNum;

            // 分析方式 2
            float ox2 = (currentNum - firstNum2) / firstNum2;
            float abs2 = Math.abs(ox2);

            if (abs2 > 0.2) {
                idx2++;

                ruleTime2.add(listObjs.get(i).get("atime"));
            }else {
                //连续两个时间段满足条件，获取开始变化的时候
                if (idx2 >= 2){
                    ruleTime2.add(instantTime2);
                }

                // 不满足，赋空
                idx2 = 0;
                instantTime2 =  (listObjs.get(i).get("atime"));
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
                instantTime3 =  (listObjs.get(i).get("atime"));

                LastDifferFlag = differFlag;
            }
            firstNum3 = currentNum;


        }
        System.out.println(ruleTime1.toString());
        System.out.println(ruleTime2.toString());
        System.out.println(ruleTime3.toString());

        List result = new ArrayList();
        result.add(ruleTime1);
        result.add(ruleTime2);
        result.add(ruleTime3);
        return success(result);
    }

    //分析维度 3
    @RequestMapping("anaysis3")
    public R anaysis3() {
        //查询有多少机型
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.groupBy("jx");
        wrapper.select("jx");
        List<Map<String, String>> jxList = this.new1qualityProblemDataService.listMaps(wrapper);


        List result = new ArrayList();

        for (int m = 0; m < jxList.size(); m++) {

            wrapper = new QueryWrapper();
            wrapper.groupBy("atime");
            wrapper.select("count(*), DATE_FORMAT(time, '%Y-%m') as atime");
            wrapper.eq("jx",jxList.get(m).get("jx"));
            wrapper.orderByAsc("atime");

            List<HashMap<Object,String>> listObjs = this.new1qualityProblemDataService.listMaps(wrapper);

            List ruleTime1 = new ArrayList();
            List ruleTime2 = new ArrayList();
            List ruleTime3 = new ArrayList();

            // 获取第一个质量问题数
            // j为后指针
            int j = 0;
            int firstNum1 = Integer.parseInt(String.valueOf(listObjs.get(j).get("count(*)")));

            // 连续两个时间段变化
            String instantTime2 =  (listObjs.get(j).get("atime"));
            int idx2 = 0;
            int firstNum2 = Integer.parseInt(String.valueOf(listObjs.get(j).get("count(*)")));

            // 连续三个时间段呈单调形式
            String instantTime3 =  (listObjs.get(j).get("atime"));
            int idx3 = 0;
            boolean LastDifferFlag = false;
            int firstNum3 = Integer.parseInt(String.valueOf(listObjs.get(j).get("count(*)")));

            for (int i = 1; i < listObjs.size(); i++) {
                // 获取当前质量问题数
                int currentNum = Integer.parseInt(String.valueOf(listObjs.get(i).get("count(*)")));

                // 根据分析方式 1：
                float ox1 = (currentNum - firstNum1) / firstNum1;
                float abs1 = Math.abs(ox1);
                if (abs1 > 0.5) {
                    // 该时间为直连发生时间
                    ruleTime1.add(listObjs.get(i).get("atime"));
                }
                firstNum1 = currentNum;

                // 分析方式 2
                float ox2 = (currentNum - firstNum2) / firstNum2;
                float abs2 = Math.abs(ox2);

                if (abs2 > 0.2) {
                    idx2++;

                    ruleTime2.add(listObjs.get(i).get("atime"));
                }else {
                    //连续两个时间段满足条件，获取开始变化的时候
                    if (idx2 >= 2){
                        ruleTime2.add(instantTime2);
                    }

                    // 不满足，赋空
                    idx2 = 0;
                    instantTime2 =  (listObjs.get(i).get("atime"));
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
                    instantTime3 =  (listObjs.get(i).get("atime"));

                    LastDifferFlag = differFlag;
                }
                firstNum3 = currentNum;


            }
            System.out.println(ruleTime1.toString());
            System.out.println(ruleTime2.toString());
            System.out.println(ruleTime3.toString());

            List r = new ArrayList();

            //r.add(jxList.get(m).get("jx"));
            r.add(ruleTime1);
            r.add(ruleTime2);
            r.add(ruleTime3);

            result.add(r);

        }


        return success(result);
    }


    //分析维度11
    //返回： 高爆发故障模式
//    @RequestMapping("anaysis11")
//    public List anaysis11() {
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.select("count(*) as nums,failure_mode");
//        wrapper.groupBy("failure_mode");
//        List<Map<String,Object>> listMaps = this.new1qualityProblemDataService.listMaps(wrapper);
////return success(listMaps);
//        List highMode = new ArrayList();
//        int num = 0;
//
//        /*获得所有的模式数量*/
//        for (int i = 0; i < listMaps.size(); i++) {
//            System.out.println(listMaps.get(i).get("nums"));
//            Number num1 = (Number) listMaps.get(i).get("nums");
//            num +=num1.intValue();
//        }
//        //看每个模式是否超过平均发生数
//        float avgOccur = num/listMaps.size();
//        float standAvg = (float) 1.1;
//        for (int i = 0; i < listMaps.size(); i++) {
//            Number num2 = (Number) listMaps.get(i).get("nums");
//            float currentNum = Float.valueOf(num2.intValue());
//            //超标
//            if (currentNum/avgOccur > standAvg) {
//                highMode.add(listMaps.get(i).get("failure_mode"));
//            }
//        }
//        return highMode;
//
//    }

//    //分析维度13
//    //也是 predict17
//    //返回： 高发 地理环境
//    @RequestMapping("anaysis13")
//    public R anaysis13() {
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.select("count(*) as nums,environment");
//        wrapper.groupBy("environment");
//        List<Map<String,Object>> listMaps = this.new1qualityProblemDataService.listMaps(wrapper);
////return success(listMaps);
//        List highMode = new ArrayList();
//        int num = 0;
//
//        /*获得所有的模式数量*/
//        for (int i = 0; i < listMaps.size(); i++) {
//            System.out.println(listMaps.get(i).get("nums"));
//            Number num1 = (Number) listMaps.get(i).get("nums");
//            num +=num1.intValue();
//        }
//        //看每个environment是否超过平均发生数
//        float avgOccur = num/listMaps.size();
//        float standAvg = (float) 1.1;
//        for (int i = 0; i < listMaps.size(); i++) {
//            Number num2 = (Number) listMaps.get(i).get("nums");
//            float currentNum = Float.valueOf(num2.intValue());
//            //超标
//            if (currentNum/avgOccur > standAvg) {
//                HashMap hashMap=  new HashMap();
//                hashMap.put("envir",listMaps.get(i).get("environment"));
//                highMode.add(hashMap);
//            }
//        }
//        return success(highMode);
//    }

    //分析维度 24
    @RequestMapping("anaysis24")
    public R anaysis24() {
        //查询有多少机型
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.groupBy("faultyparts_title");
        wrapper.select("faultyparts_title");
        List<Map<String, String>> jxList = this.new1qualityProblemDataService.listMaps(wrapper);


        List result = new ArrayList();

        for (int m = 0; m < jxList.size(); m++) {

            wrapper = new QueryWrapper();
            wrapper.groupBy("atime");
            wrapper.select("count(*), DATE_FORMAT(time, '%Y-%m') as atime");
            wrapper.eq("faultyparts_title",jxList.get(m).get("faultyparts_title"));
            wrapper.orderByAsc("atime");

            List<HashMap<Object,String>> listObjs = this.new1qualityProblemDataService.listMaps(wrapper);

            List ruleTime1 = new ArrayList();
            List ruleTime2 = new ArrayList();
            List ruleTime3 = new ArrayList();

            // 获取第一个质量问题数
            // j为后指针
            int j = 0;
            int firstNum1 = Integer.parseInt(String.valueOf(listObjs.get(j).get("count(*)")));

            // 连续两个时间段变化
            String instantTime2 =  (listObjs.get(j).get("atime"));
            int idx2 = 0;
            int firstNum2 = Integer.parseInt(String.valueOf(listObjs.get(j).get("count(*)")));

            // 连续三个时间段呈单调形式
            String instantTime3 =  (listObjs.get(j).get("atime"));
            int idx3 = 0;
            boolean LastDifferFlag = false;
            int firstNum3 = Integer.parseInt(String.valueOf(listObjs.get(j).get("count(*)")));

            for (int i = 1; i < listObjs.size(); i++) {
                // 获取当前质量问题数
                int currentNum = Integer.parseInt(String.valueOf(listObjs.get(i).get("count(*)")));

                // 根据分析方式 1：
                float ox1 = (currentNum - firstNum1) / firstNum1;
                float abs1 = Math.abs(ox1);
                if (abs1 > 0.5) {
                    // 该时间为直连发生时间
                    ruleTime1.add(listObjs.get(i).get("atime"));
                }
                firstNum1 = currentNum;

                // 分析方式 2
                float ox2 = (currentNum - firstNum2) / firstNum2;
                float abs2 = Math.abs(ox2);

                if (abs2 > 0.2) {
                    idx2++;

                    ruleTime2.add(listObjs.get(i).get("atime"));
                }else {
                    //连续两个时间段满足条件，获取开始变化的时候
                    if (idx2 >= 2){
                        ruleTime2.add(instantTime2);
                    }

                    // 不满足，赋空
                    idx2 = 0;
                    instantTime2 =  (listObjs.get(i).get("atime"));
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
                    instantTime3 =  (listObjs.get(i).get("atime"));

                    LastDifferFlag = differFlag;
                }
                firstNum3 = currentNum;


            }
            System.out.println(ruleTime1.toString());
            System.out.println(ruleTime2.toString());
            System.out.println(ruleTime3.toString());

            List r = new ArrayList();

            r.add(jxList.get(m).get("faultyparts_title"));
            r.add(ruleTime1);
            r.add(ruleTime2);
            r.add(ruleTime3);

            result.add(r);

        }


        return success(result);
    }

}
