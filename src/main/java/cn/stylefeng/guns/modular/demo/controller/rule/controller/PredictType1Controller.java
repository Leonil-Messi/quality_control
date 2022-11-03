package cn.stylefeng.guns.modular.demo.controller.rule.controller;

import cn.hutool.core.util.StrUtil;
import cn.stylefeng.guns.modular.demo.dao.New3finishedProductDesignDataDao;
import cn.stylefeng.guns.modular.demo.service.New3finishedProductDesignDataService;
import cn.stylefeng.guns.modular.demo.vo.Predict1VO;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.api.ApiController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yyk.
 * @date 2021/12/6 9:25
 */
@RestController
@RequestMapping("rule")
public class PredictType1Controller {
    @Resource
    private New3finishedProductDesignDataService new3finishedProductDesignDataService;


    @Resource
    New3finishedProductDesignDataDao new3finishedProductDesignDataDao;


    @RequestMapping("predict1")
    public R predict1(){
        List<Predict1VO> vos = this.new3finishedProductDesignDataDao.orderUserList();


        List result = new ArrayList();
        for (int i = 0; i < vos.size(); i++) {
            boolean reasonable = predict1Reasonable(vos.get(i));

            //不满足条件就加入
            if (!reasonable){
                result.add(vos.get(i));
            }
        }
        return R.ok(result);
    }


    //predict1 预测是否合理
    public boolean predict1Reasonable(Predict1VO predict1VO) {
        String experInput = StrUtil.removeSuffix(predict1VO.getExperimentInput(), "]");
        experInput = StrUtil.removePrefix(experInput, "[");
        List<String> experInputList = StrUtil.split(experInput, ", ");

        //    测试数据
        String testInput = StrUtil.removeSuffix(predict1VO.getTestInput(), "]");
        testInput = StrUtil.removePrefix(testInput, "[");
        List<String> testInputList = StrUtil.split(testInput, ", ");

        //设计指标数据
        ArrayList<String> target = new ArrayList();
        if (predict1VO.getAntivibration().equals("不涉及")) {target.add("0"); }
        else {target.add(predict1VO.getAntivibration()); }

        if (predict1VO.getHumidityLimit().equals("不涉及")) {target.add("0"); }
        else {target.add(predict1VO.getHumidityLimit()); }

        if (predict1VO.getTemperatureLimit().equals("不涉及")) {target.add("0"); }
        else {target.add(predict1VO.getTemperatureLimit()); }

        if (predict1VO.getDesignStrength().equals("不涉及")) {target.add("0"); }
        else {target.add(predict1VO.getDesignStrength()); }


        System.out.println(target.toString());
        for (int i = 0; i < target.size(); i++) {
            double a = Double.parseDouble(experInputList.get(i));
            double b = Double.parseDouble(testInputList.get(i));
            double c = Double.parseDouble(target.get(i));
            if ( a > b && b > c) {
                //满足推断条件
                return true;
            }

        }

        //不满足
        return false;

    }

}
