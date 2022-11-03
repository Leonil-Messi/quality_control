package cn.stylefeng.guns.modular.demo.controller.view.scy;

import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

@RestController
@RequestMapping("/data")
public class Question22Controller extends ApiController {

    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;

    @RequestMapping("/question22")
    public Map<String, Object> question22() {
        //故障最早发生日期
        Date earlyTime = new Date();
        //故障最晚发生日期
        Date lateTime = new Date(0,1,1);
        //月份区间列表
        String[] monthList;
        //故障件类型列表
        String[] typeList;
        //结果数据集合
        Map<String, Object> resultMap = new HashMap();
        //获取故障件类型
        List<New1qualityProblemData> types = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .select("faultyparts_type")
                .groupBy("faultyparts_type")
                .orderByDesc("faultyparts_type")
        );
        typeList = new String[types.size()];
        //获取所有数据项
        List<New1qualityProblemData> dataList = new1qualityProblemDataService.list();
        //获得最早故障日期  和最晚故障日期
        for (New1qualityProblemData new1qualityProblemData : dataList) {
            Date time = new1qualityProblemData.getTime();
//            System.out.println(earlyTime.before(time));
//            System.out.println(time);
            if (time.after(new Date(49,1,1))){
                if(earlyTime.after(time)){
                    earlyTime = time;
                }
                if(lateTime.before(time)) {
                    lateTime = time;
                }
            }
        }
        int earlyYear = earlyTime.getYear();
        int earlyMonth = earlyTime.getMonth();
        int lateYear = lateTime.getYear();
        int lateMonth = lateTime.getMonth();
        int range = (lateYear-earlyYear)*12+lateMonth-earlyMonth+1;
        //使用for循环生成中间的月份区间
        monthList = new String[range];
        for (int i = 0; i < range; i++) {
            int addY = (i+earlyMonth)/12;
            int resultM = (i+earlyMonth)%12+1;
            int resultY = earlyYear + addY +1900;
            monthList[i]=(resultY+"年"+resultM+"月");
        }
        //遍历故障类型次
        List<Question22ChartData> series = new ArrayList<>();
        for (int i = 0; i < types.size(); i++) {
            //创建类型数量个数组 数组长度为
            //创建区间数组
            int[] strs = new int[range];
            String typeName = types.get(i).getFaultypartsType();
            //遍历全部数据记录
            for (New1qualityProblemData new1qualityProblemData : dataList) {
                //使用地址映射记录 同一时间同一种类的故障件的个数
                Date time = new1qualityProblemData.getTime();
                if (time.after(new Date(49,1,1))) {
                    int year = time.getYear() - earlyYear;
                    int month = time.getMonth() - earlyMonth;
                    if (new1qualityProblemData.getFaultypartsType().equals(typeName)) {
                        strs[year * 12 + month]++;
                    }
                }
            }
            series.add(new Question22ChartData("bar", strs,typeName));
            typeList[i] = typeName;
        }
        resultMap.put("series",series);
        resultMap.put("monthList", monthList);
        resultMap.put("typeList", typeList);

        return resultMap;
    }


    @RequestMapping("/question22/year")
    public Map<String, Object> question22Year() {
        //故障最早发生日期
        Date earlyTime = new Date();
        //故障最晚发生日期
        Date lateTime = new Date(0,1,1);
        //月份区间列表
        String[] monthList;
        //故障件类型列表
        String[] typeList;
        //结果数据集合
        Map<String, Object> resultMap = new HashMap();
        //获取故障件类型
        List<New1qualityProblemData> types = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .select("faultyparts_type")
                .groupBy("faultyparts_type")
                .orderByDesc("faultyparts_type")
        );
        typeList = new String[types.size()];
        //获取所有数据项
        List<New1qualityProblemData> dataList = new1qualityProblemDataService.list();
        //获得最早故障日期  和最晚故障日期
        for (New1qualityProblemData new1qualityProblemData : dataList) {
            Date time = new1qualityProblemData.getTime();
            if(time.getYear()!=49){
                if(earlyTime.after(time)){
                    earlyTime = time;
                }
                if(lateTime.before(time)) {
                    lateTime = time;
                }
            }
        }
        int earlyYear = earlyTime.getYear();
        int lateYear = lateTime.getYear();
        int range = lateYear - earlyYear+1;
        //使用for循环生成中间的月份区间
        monthList = new String[range];
        for (int i = 0; i < range; i++) {
            int resultY = earlyYear + 1900;
            monthList[i]=(resultY+i+"年");
        }
        //遍历故障类型次
        List<Question22ChartData> series = new ArrayList<>();
        for (int i = 0; i < types.size(); i++) {
            //创建类型数量个数组 数组长度为
            //创建区间数组
            int[] strs = new int[range];
            String typeName = types.get(i).getFaultypartsType();
            //遍历全部数据记录
            for (New1qualityProblemData new1qualityProblemData : dataList) {
                //使用地址映射记录 同一时间同一种类的故障件的个数
                Date time = new1qualityProblemData.getTime();
                if(time.getYear()!=49) {
                    int year = time.getYear() - earlyYear;
                    if (new1qualityProblemData.getFaultypartsType().equals(typeName)) {
                        strs[year]++;
                    }
                }
            }
            series.add(new Question22ChartData("bar", strs,typeName));
            typeList[i] = typeName;
        }
        resultMap.put("series",series);
        resultMap.put("monthList", monthList);
        resultMap.put("typeList", typeList);

        return resultMap;
    }

}





class Question22ChartData implements Serializable {
    public String type;
    public int[] data;
    public String name;

    public Question22ChartData(String type, int[] data, String name) {
        this.type = type;
        this.data = data;
        this.name = name;
    }

    public Question22ChartData() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Question22ChartData{" +
                "type='" + type + '\'' +
                ", data=" + Arrays.toString(data) +
                ", name='" + name + '\'' +
                '}';
    }
}