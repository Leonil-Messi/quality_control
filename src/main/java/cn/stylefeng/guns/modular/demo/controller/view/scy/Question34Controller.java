package cn.stylefeng.guns.modular.demo.controller.view.scy;

import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import cn.stylefeng.guns.modular.demo.entity.NewTableFlag;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;
import cn.stylefeng.guns.modular.demo.service.NewTableFlagService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/data")
public class Question34Controller extends ApiController {
    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;
    @Resource
    private NewTableFlagService newTableFlagService;
    @GetMapping("/question34")
    public Map<String,List<double[]>> question34(String title) {
//        if(rate<=0) rate=0.8;
        //创建最后map包装结构
        Map<String, List<double[]>> resultMap = new HashMap<>();
        //创建单条数据列表
        List<double[]> list = new ArrayList<>();
        //获得所有故障件名称
        List<New1qualityProblemData> data = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .select("faultyparts_title").groupBy("faultyparts_title")
        );
        //如果没有故障件名称记录
        if (data.size()==0) {
            return null;
        }
        //判断前段传入的故障件名称 数据库中是否存在
        boolean sign = false;
        for (New1qualityProblemData datum : data) {
            if (datum.getFaultypartsTitle().equals(title)) {
                sign = true;
            }
        }
        //所传入故障件标题不存在 直接返回
        if(!sign){
            return null;
        }
        //获得该故障件所有数据
        List<New1qualityProblemData> titleList = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .eq("faultyparts_title", title)
        );
        //获取该故障件最短使用时长 和最长使用时长
        double shortTime = 0.0;
        double longTime = Double.MAX_VALUE;

        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.select("MAX(faultparts_usagetime) AS maxUsageTime").eq("faultyparts_title", title);
        Map<String, String> map1 = new1qualityProblemDataService.getMap(queryWrapper);
        longTime = Double.parseDouble(map1.get("maxUsageTime"));

        QueryWrapper queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.select("MIN(faultparts_usagetime) AS minUsageTime").eq("faultyparts_title", title);
        Map<String, String> map2 = new1qualityProblemDataService.getMap(queryWrapper1);
        shortTime = Double.parseDouble(map2.get("minUsageTime"));
//        System.out.println(shortTime+"---"+longTime);

        //创建范围数组 数组分为十份
        double[] range = new double[11];
        for (int i = 0; i < range.length; i++) {

            double accurate = (longTime - shortTime) * (double) i / 10;
            String doubleString = Double.toString(accurate);
            if(doubleString.length()<5){
                range[i] = Double.parseDouble(doubleString);
            }else{
                String substring = doubleString.substring(0, 4);
                range[i] = Double.parseDouble(substring);
            }
//
        }
        //创建记录累积量数组
        double[] records = new double[10];
        //遍历相应数据列表 累计将所有使用时间 记录在范围数组中
        for (New1qualityProblemData new1qualityProblemData : titleList) {
            double distance = Double.parseDouble(new1qualityProblemData.getFaultpartsUsagetime())-shortTime;
            double times = distance / ((longTime - shortTime) * 0.1);
            String doubleString = Double.toString(times);
            if(doubleString.length()<5){
                times = Double.parseDouble(doubleString);
            }else{
                String substring = doubleString.substring(0, 4);
                times = Double.parseDouble(substring);
            }
            int ceil = (int)Math.ceil(times);
//            System.out.println(ceil);
            if(ceil==0){
                records[ceil]++;
            }else{
                records[ceil-1]++;
            }
        }

        //将数据整合进List 形成前端要求的格式
        for (int i = 0; i < records.length; i++) {
            double[] newDouble = {range[i],range[i+1],records[i]};
            list.add(newDouble);
        }
        resultMap.put("list",list);
        return resultMap;
    }

    @RequestMapping("/question34/table")
    public Map<String, Object> question34Table(String title,double rate,int limit,int page) {
        if(rate<=0) rate=0.8;
        //创建最后map包装结构
        Map<String, List<double[]>> resultMap = new HashMap<>();
        //创建单条数据列表
        List<double[]> list = new ArrayList<>();
        //获得所有故障件名称
        List<New1qualityProblemData> data = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .select("faultyparts_title").groupBy("faultyparts_title")
        );
        //如果没有故障件名称记录
        if (data.size()==0) {
            return null;
        }
        //判断前段传入的故障件名称 数据库中是否存在
        boolean sign = false;
        for (New1qualityProblemData datum : data) {
            if (datum.getFaultypartsTitle().equals(title)) {
                sign = true;
            }
        }
        //所传入故障件标题不存在 直接返回
        if(!sign){
            return null;
        }
        //获得该故障件所有数据
        List<New1qualityProblemData> titleList = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .eq("faultyparts_title", title)
        );
        //获取该故障件最短使用时长 和最长使用时长
        double shortTime = 0.0;
        double longTime = Double.MAX_VALUE;

        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.select("MAX(faultparts_usagetime) AS maxUsageTime").eq("faultyparts_title", title);
        Map<String, String> map1 = new1qualityProblemDataService.getMap(queryWrapper);
        longTime = Double.parseDouble(map1.get("maxUsageTime"));

        QueryWrapper queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.select("MIN(faultparts_usagetime) AS minUsageTime").eq("faultyparts_title", title);
        Map<String, String> map2 = new1qualityProblemDataService.getMap(queryWrapper1);
        shortTime = Double.parseDouble(map2.get("minUsageTime"));
//        System.out.println(shortTime+"---"+longTime);

        //创建范围数组 数组分为十份
        double[] range = new double[11];
        for (int i = 0; i < range.length; i++) {

            double accurate = (longTime - shortTime) * (double) i / 10;
            String doubleString = Double.toString(accurate);
            if(doubleString.length()<5){
                range[i] = Double.parseDouble(doubleString);
            }else{
                String substring = doubleString.substring(0, 4);
                range[i] = Double.parseDouble(substring);
            }
//
        }
        //创建记录累积量数组
        double[] records = new double[10];
        //遍历相应数据列表 累计将所有使用时间 记录在范围数组中
        for (New1qualityProblemData new1qualityProblemData : titleList) {
            double distance = Double.parseDouble(new1qualityProblemData.getFaultpartsUsagetime())-shortTime;
            double times = distance / ((longTime - shortTime) * 0.1);
            String doubleString = Double.toString(times);
            if(doubleString.length()<5){
                times = Double.parseDouble(doubleString);
            }else{
                String substring = doubleString.substring(0, 4);
                times = Double.parseDouble(substring);
            }
            int ceil = (int)Math.ceil(times);
//            System.out.println(ceil);
            if(ceil==0){
                records[ceil]++;
            }else{
                records[ceil-1]++;
            }
        }

        BigDecimal bigDecimalShortTime = new BigDecimal(Double.toString(shortTime));
        //获得符合条件的区间
        int recordsNum = titleList.size();
        List<BigDecimal> start = new ArrayList();
        List<BigDecimal> end = new ArrayList();
        List<New1qualityProblemData> resultList = new ArrayList<>();
        for (int i = 0; i < records.length; i++) {
            if(recordsNum*rate < records[i]){
                start.add(new BigDecimal(Double.toString(range[i])).add(bigDecimalShortTime));
                end.add(new BigDecimal(Double.toString(range[i+1])).add(bigDecimalShortTime));
            }
        }
        for (int i = 0; i < start.size(); i++) {
            List<New1qualityProblemData> result = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                    .between("faultparts_usagetime", start.get(i).toString(), end.get(i).toString()));
            resultList.addAll(result);
        }
        Map<Integer, New1qualityProblemData> testMap = new HashMap<>();
        for (New1qualityProblemData new1qualityProblemData : resultList) {
            testMap.put(new1qualityProblemData.getQualityId(), new1qualityProblemData);
        }
        List<New1qualityProblemData> newResultList = new ArrayList<>();
        for (Map.Entry<Integer, New1qualityProblemData> integerNew1qualityProblemDataEntry : testMap.entrySet()) {
            newResultList.add(integerNew1qualityProblemDataEntry.getValue());
        }



        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", Util.page(limit, page, newResultList));
        mapTable.put("code", 0);
        mapTable.put("count", newResultList.size());
        if(resultList.size()!=0){
            NewTableFlag newTableFlag = new NewTableFlag();
            newTableFlag.setTableId(34);
            newTableFlag.setFlag("1");
            newTableFlagService.update(newTableFlag, new QueryWrapper<NewTableFlag>()
                    .eq("table_id", 34));
        }

        return mapTable;
    }



    @RequestMapping("/question34/type")
    public Map<String, List<String>> question34Type() {
        List<New1qualityProblemData> list = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .select("faultyparts_type")
                .groupBy("faultyparts_type")
        );
        List<String> typeList = new ArrayList<>();
        for (New1qualityProblemData new1qualityProblemData : list) {
            typeList.add(new1qualityProblemData.getFaultypartsType());
        }
        Map<String, List<String>> resultMap = new HashMap<>();
        resultMap.put("typeList", typeList);
        return resultMap;
    }
    @RequestMapping("/question34/title")
    public Map<String, List<String>> question34Title(String type) {
        List<New1qualityProblemData> list = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .select("faultyparts_title")
                .eq("faultyparts_type",type)
                .groupBy("faultyparts_title")
        );
        List<String> titleList = new ArrayList<>();
        for (New1qualityProblemData new1qualityProblemData : list) {
            titleList.add(new1qualityProblemData.getFaultypartsTitle());
        }
        Map<String, List<String>> resultMap = new HashMap<>();
        resultMap.put("titleList", titleList);
        return resultMap;
    }
}


class Question34ChartData implements Serializable {
   double start;
   double end;
   double rate;
   String name;

    public Question34ChartData(double start, double end, double rate, String name) {
        this.start = start;
        this.end = end;
        this.rate = rate;
        this.name = name;
    }

    public Question34ChartData() {
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Question34ChartData{" +
                "start=" + start +
                ", end=" + end +
                ", rate=" + rate +
                ", name='" + name + '\'' +
                '}';
    }
}
