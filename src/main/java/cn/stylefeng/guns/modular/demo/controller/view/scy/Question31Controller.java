package cn.stylefeng.guns.modular.demo.controller.view.scy;

import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import cn.stylefeng.guns.modular.demo.entity.NewTableFlag;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;
import cn.stylefeng.guns.modular.demo.service.NewTableFlagService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

@RestController
@RequestMapping("/data")
public class Question31Controller extends ApiController {

    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;
    @Resource
    private NewTableFlagService newTableFlagService;
    @RequestMapping("/question31")
    public Map<String, Object> question31() {
        Map<String, Object> resultMap = new HashMap<>();
        //获得所有故障件名称
        List<New1qualityProblemData> titleList = new1qualityProblemDataService
                .list(new QueryWrapper<New1qualityProblemData>()
                        .select("faultyparts_title")
                        .groupBy("faultyparts_title")
                );
        //获得所有故障件制造批次
        List<New1qualityProblemData> batchList = new1qualityProblemDataService
                .list(new QueryWrapper<New1qualityProblemData>()
                        .select("faultparts_batch")
                        .groupBy("faultparts_batch")
                );        //获得所有记录
        //获得所有记录
        List<New1qualityProblemData> dataList = new1qualityProblemDataService.list();
        //List<String> 所有制造批次 keyList
        List<String> keyList = new ArrayList<>();
        for (New1qualityProblemData new1qualityProblemData : batchList) {
            keyList.add(new1qualityProblemData.getFaultpartsBatch());
        }
        //new Map<故障建名称,map<故障件制造批次,int>]>
        Map<String, Map<String,Integer>> titleMap = new HashMap<>();
        //for故障件名称
        for (int i = 0; i < titleList.size(); i++) {
            //map<批次,int>
            Map<String, Integer> batchMap = new HashMap<>();
            //for所有记录
            for (New1qualityProblemData new1qualityProblemData : dataList) {
                //如果不存在则新建 存在则++
                String batch = new1qualityProblemData.getFaultpartsBatch();
                String title = new1qualityProblemData.getFaultypartsTitle();
                if(title.equals(titleList.get(i).getFaultypartsTitle())){
                    if (batchMap.get(batch) == null ) {
                        batchMap.put(batch, 1);
                    } else {
                        Integer integer = batchMap.get(batch) + 1;
                        batchMap.put(batch, integer);
                    }
                }
            }
            titleMap.put(titleList.get(i).getFaultypartsTitle(), batchMap);
        }
        //平均值列表
        Map<String, Double> rates = new HashMap<>();
        //获得平均值
        for (int i = 0; i < titleList.size(); i++) {
            int count = new1qualityProblemDataService.count(new QueryWrapper<New1qualityProblemData>()
                    .eq("faultyparts_title", titleList.get(i).getFaultypartsTitle()));
            rates.put(titleList.get(i).getFaultypartsTitle(),(double)count/batchList.size());
        }
        //List<String> 名称列表
        List<String> nameList = new ArrayList<>();
        //创建series数组 存放数据
        List<Question31ChartData> series = new ArrayList<>();
        //for
        for (Map.Entry<String, Map<String,Integer>> entry : titleMap.entrySet()) {
            //list.add名称
            nameList.add(entry.getKey());
            //int[] 存储次数
            int[] data = new int[batchList.size()];
            //for batchMap 使用 keyList作为key 映射次数
            for (int i = 0; i < entry.getValue().size(); i++) {
                Map<String,Integer> map = entry.getValue();
                Integer integer = map.get(keyList.get(i));
                if(integer==null){
                    data[i] = 0;
                }else {
                    data[i] = integer;
                    //int[]=map.get(key)
                }
            }
//            for (int i = 0; i < data.length; i++) {
////                System.out.println(rates.get(entry.getKey()));
//                Double level = rates.get(entry.getKey()) * rate;
//                if(level.compareTo((double)data[i])>0){
//                    data[i]=0;
//                }
//            }
            series.add(new Question31ChartData("bar", data, entry.getKey()));
        }
        resultMap.put("series",series);
        resultMap.put("keyList", keyList);
        resultMap.put("nameList", nameList);

        return resultMap;
    }

    @RequestMapping("/question31/table")
    public Map<String, Object> question33Table(double rate,int limit,int page) {
        Map<String, Object> resultMap = new HashMap<>();
        //获得所有故障件名称
        List<New1qualityProblemData> titleList = new1qualityProblemDataService
                .list(new QueryWrapper<New1qualityProblemData>()
                        .select("faultyparts_title")
                        .groupBy("faultyparts_title")
                );
        //获得所有故障件制造批次
        List<New1qualityProblemData> batchList = new1qualityProblemDataService
                .list(new QueryWrapper<New1qualityProblemData>()
                        .select("faultparts_batch")
                        .groupBy("faultparts_batch")
                );        //获得所有记录
        //获得所有记录
        List<New1qualityProblemData> dataList = new1qualityProblemDataService.list();
        //List<String> 所有制造批次 keyList
        List<String> keyList = new ArrayList<>();
        for (New1qualityProblemData new1qualityProblemData : batchList) {
            keyList.add(new1qualityProblemData.getFaultpartsBatch());
        }
        //new Map<故障建名称,map<故障件制造批次,int>]>
        Map<String, Map<String,Integer>> titleMap = new HashMap<>();
        //for故障件名称
        for (int i = 0; i < titleList.size(); i++) {
            //map<批次,int>
            Map<String, Integer> batchMap = new HashMap<>();
            //for所有记录
            for (New1qualityProblemData new1qualityProblemData : dataList) {
                //如果不存在则新建 存在则++
                String factory = new1qualityProblemData.getFaultpartsBatch();
                String title = new1qualityProblemData.getFaultypartsTitle();
                if(title.equals(titleList.get(i).getFaultypartsTitle())){
                    if (batchMap.get(factory) == null ) {
                        batchMap.put(factory, 1);
                    } else {
                        Integer integer = batchMap.get(factory) + 1;
                        batchMap.put(factory, integer);
                    }
                }
            }
            titleMap.put(titleList.get(i).getFaultypartsTitle(), batchMap);
        }
        //平均值列表
        Map<String, Double> rates = new HashMap<>();
        //获得平均值
        for (int i = 0; i < titleList.size(); i++) {
            int count = new1qualityProblemDataService.count(new QueryWrapper<New1qualityProblemData>()
                    .eq("faultyparts_title", titleList.get(i).getFaultypartsTitle()));
            rates.put(titleList.get(i).getFaultypartsTitle(),(double)count/batchList.size());
        }
        //List<String> 名称列表
        List<String> nameList = new ArrayList<>();
        //创建series数组 存放数据
        List<Question31ChartData> series = new ArrayList<>();
        //for
        for (Map.Entry<String, Map<String,Integer>> entry : titleMap.entrySet()) {
            //list.add名称
            nameList.add(entry.getKey());
            //int[] 存储次数
            int[] data = new int[batchList.size()];
            //for batchMap 使用 keyList作为key 映射次数
            for (int i = 0; i < entry.getValue().size(); i++) {
                Map<String,Integer> map = entry.getValue();
                Integer integer = map.get(keyList.get(i));
                if(integer==null){
                    data[i] = 0;
                }else {
                    data[i] = integer;
                    //int[]=map.get(key)
                }
            }
            for (int i = 0; i < data.length; i++) {
//                System.out.println(rates.get(entry.getKey()));
                Double level = rates.get(entry.getKey()) * rate;
                if(level.compareTo((double)data[i])>0){
                    data[i]=0;
                }
            }
            series.add(new Question31ChartData("bar", data, entry.getKey()));
        }
        //新建resultList
        List<New1qualityProblemData> resultList = new ArrayList<>();
        //创建二维数组
        int[][] sign = new int[titleList.size()][batchList.size()];
        for (int i = 0; i < titleList.size(); i++) {
            sign[i] = series.get(i).data;
        }
        //获得符合规则的记录的  title和unit
        Map<String, String> tmpMap = new HashMap<>();
        for (int i = 0; i < titleList.size(); i++) {
            for (int j = 0; j < batchList.size(); j++) {
                if(sign[i][j]!=0){
                    tmpMap.put(nameList.get(i), keyList.get(j));
                }
            }
        }

        for (New1qualityProblemData new1qualityProblemData : dataList) {
            for (Map.Entry<String, String> entry : tmpMap.entrySet()) {
                if (new1qualityProblemData.getFaultypartsTitle()
                        .equals(entry.getKey())
                        &&new1qualityProblemData.getFaultpartsBatch()
                        .equals(entry.getValue())
                ) {
                    resultList.add(new1qualityProblemData);
                }
            }
        }
//        System.out.println(limit);
//        System.out.println(page);
//        System.out.println(resultList);
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", Util.page(limit, page, resultList));
        mapTable.put("code", 0);
        mapTable.put("count", resultList.size());

        if(resultList.size()!=0){
            NewTableFlag newTableFlag = new NewTableFlag();
            newTableFlag.setTableId(31);
            newTableFlag.setFlag("1");
            newTableFlagService.update(newTableFlag, new QueryWrapper<NewTableFlag>()
                    .eq("table_id", 31));
        }
        return mapTable;

    }
}


class Question31ChartData implements Serializable {
    public String type;
    public int[] data;
    public String name;

    public Question31ChartData(String type, int[] data, String name) {
        this.type = type;
        this.data = data;
        this.name = name;
    }

    public Question31ChartData() {
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
        return "Question31ChartData{" +
                "type='" + type + '\'' +
                ", data=" + Arrays.toString(data) +
                ", name='" + name + '\'' +
                '}';
    }
}