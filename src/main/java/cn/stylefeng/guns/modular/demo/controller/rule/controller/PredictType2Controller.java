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
public class PredictType2Controller {
    @Resource
    private New7experimentalDataOfFaultyPartsService new7experimentalDataOfFaultyPartsService;

    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;

    //predict6
    @RequestMapping("predict7")
    public R predict7() {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("DATE_FORMAT(faultparts_deliverytime,'%Y-%m') as ctime,count(*) as cnum");
        wrapper.groupBy("ctime");
        wrapper.orderByAsc("ctime");

        List<Map<String, String>> listMaps = this.new1qualityProblemDataService.listMaps(wrapper);

    //    求平均数
        int all = 0;
        for (int i = 0; i < listMaps.size(); i++) {
            all +=Integer.parseInt(String.valueOf(listMaps.get(i).get("cnum")));
        }
        double avg = all / listMaps.size();
        System.out.println("平均数：" + avg);

        //查询超过平均数的时间
        List<String> dangerTimeList = new ArrayList<>();
        double analysis33INSTANCE = 0.5;
        for (int i = 0; i < listMaps.size(); i++) {
            if ( Integer.parseInt(String.valueOf(listMaps.get(i).get("cnum"))) / avg > 1+analysis33INSTANCE ) {
                dangerTimeList.add(String.valueOf(listMaps.get(i).get("ctime")));
            }
        }
        System.out.println("危险时间数组：" + dangerTimeList.toString());

        //遍历，看是否包含危险时间，包括就返回
        List<New1qualityProblemData> result = new ArrayList<>();
        List<New1qualityProblemData> new1qualityProblemDataList = this.new1qualityProblemDataService.list();
        for (int i = 0; i < new1qualityProblemDataList.size(); i++) {
            if (dangerTimeList.contains(new1qualityProblemDataList.get(i).getFaultpartsDeliverytime())){
                result.add(new1qualityProblemDataList.get(i));
            }
        }

        return R.ok(new1qualityProblemDataList);

    }
    //predict6 用的 分析 33
    @RequestMapping("analysis33")
    public R analysis33() {
return null;
    }

    //predict6
    @RequestMapping("predict6")
    public R predict6(){
        List<New7experimentalDataOfFaultyParts> new7experimentalDataOfFaultyParts = this.new7experimentalDataOfFaultyPartsService.list();

        List result = new ArrayList();
        for (int i = 0; i < new7experimentalDataOfFaultyParts.size(); i++) {
            boolean reasonable = predict6Reasonable(new7experimentalDataOfFaultyParts.get(i));

            //不满足条件就加入
            if (!reasonable){
                result.add(new7experimentalDataOfFaultyParts.get(i));
            }
        }
        return R.ok(result);
    }



    //predict6 预测是否合理
    public boolean predict6Reasonable(New7experimentalDataOfFaultyParts predict6VO) {
        String experInput = StrUtil.removeSuffix(predict6VO.getExperimentInput(), "]");
        experInput = StrUtil.removePrefix(experInput, "[");
        List<String> experInputList = StrUtil.split(experInput, ", ");

        //    测试数据
        String testInput = StrUtil.removeSuffix(predict6VO.getTestInput(), "]");
        testInput = StrUtil.removePrefix(testInput, "[");
        List<String> testInputList = StrUtil.split(testInput, ", ");


        for (int i = 0; i < testInputList.size(); i++) {
            double a = Double.parseDouble(experInputList.get(i));
            double b = Double.parseDouble(testInputList.get(i));
            if ( a > b) {

                //满足推断条件
                return true;
            }

        }

        //不满足
        return false;

    }

}
