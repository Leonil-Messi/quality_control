package cn.stylefeng.guns.modular.demo.controller.view.scy;

import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import cn.stylefeng.guns.modular.demo.entity.NewTableFlag;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;
import cn.stylefeng.guns.modular.demo.service.NewTableFlagService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/data")
public class Question2Controller extends ApiController {
    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;
    @Resource
    private NewTableFlagService newTableFlagService;

    @GetMapping("/question2")
    public R question2() {
//        if(rate<=0) rate=1.5;
        //总事故数
        int count;
        //平均事故率
        float totalAccidentRate;
        //机型数
        int type;
        //符合条件机型列表
        List<String> nameList = new ArrayList<>();
        //符合条件比值列表
        List<Integer> rateList = new ArrayList<>();
        //求质量问题机型 平均发生数  事故总数/机型数
        count = new1qualityProblemDataService.count();
        List<New1qualityProblemData> list = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .groupBy("jx")
                .select("jx")
        );
        type = list.size();
        //总事故数:机型数
        totalAccidentRate = count / (float) type;
        //求每个机型质量问题发生数 在全部质量问题的比例
        for (New1qualityProblemData data : list) {
            //获得同机型事故列表
            List<New1qualityProblemData> dataList = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                    .select("jx")
                    .eq("jx", data.getJx())
            );
            //获得同一机型的事故数
            int num = dataList.size();
            //如果大于平均发生率 rate 则作为数据 汇入图表显示
//            if (num >= totalAccidentRate * rate) {
                nameList.add(dataList.get(0).getJx());
                rateList.add(num);
//            }
        }
        Map<String, List> map = new HashMap();
        //排序
        String str;
        int tmp;
        for (int i = 0; i < rateList.size(); i++) {
            for (int j = i + 1; j < rateList.size(); j++) {
                if (rateList.get(i).compareTo(rateList.get(j)) < 0) {
                    tmp = rateList.get(i);
                    rateList.set(i, rateList.get(j));
                    rateList.set(j, tmp);

                    str = nameList.get(i);
                    nameList.set(i, nameList.get(j));
                    nameList.set(j, str);
                }
            }
        }
        map.put("nameList", nameList);
        map.put("rateList", rateList);
//        System.out.println(map);
        return success(map);
    }

    @RequestMapping("/question2/table")
    public Map<String, Object> question2Table(double rate,int limit,int page) {
        if(rate<=0) rate=1.5;
//        rate = 0.8;
        //总事故数
        int count;
        //平均事故率
        float totalAccidentRate;
        //机型数
        int type;
        //符合条件机型列表
        List<New1qualityProblemData> resultList = new ArrayList<>();
        //符合条件比值列表
        //求质量问题机型 平均发生数  事故总数/机型数
        count = new1qualityProblemDataService.count();
        List<New1qualityProblemData> list = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .groupBy("jx")
                .select("jx")
        );
        type = list.size();
        //总事故数:机型数
        totalAccidentRate = count / (float) type;
        //求每个机型质量问题发生数 在全部质量问题的比例
        for (New1qualityProblemData data : list) {
            //获得同机型事故列表
            List<New1qualityProblemData> dataList = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                    .eq("jx", data.getJx())
            );
            //获得同一机型的事故数
            int num = dataList.size();
            //如果大于平均发生率 rate 则作为数据 汇入图表显示
            if (num >= totalAccidentRate * rate) {
                resultList.addAll(dataList);
            }
        }
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", Util.page(limit, page, resultList));
        mapTable.put("code", 0);
        mapTable.put("count", resultList.size());

        if(resultList.size()!=0){
            NewTableFlag newTableFlag = new NewTableFlag();
            newTableFlag.setTableId(2);
            newTableFlag.setFlag("1");
            newTableFlagService.update(newTableFlag, new QueryWrapper<NewTableFlag>()
                    .eq("table_id", 2));
        }


        return mapTable;
    }
}
