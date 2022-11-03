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
public class Question18Controller extends ApiController {
    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;
    @Resource
    private NewTableFlagService newTableFlagService;
    @RequestMapping("/question18")
    public Map<String, Object> question18() {
//        if(rate<=0) rate=1.5;
        //故障最早发生日期
        Date earlyTime = new Date();
        //故障最晚发生日期
        Date lateTime = new Date(0,1,1);
        //月份区间列表
        String[] monthList;
        //故障件类型列表
        String[] titleList;
        //结果数据集合
        Map<String, Object> resultMap = new HashMap();
        //获取故障件名称
        List<New1qualityProblemData> titles = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .select("jx")
                .groupBy("jx")
                .orderByDesc("jx")
        );
        titleList = new String[titles.size()];
        //获取所有数据项
        List<New1qualityProblemData> dataList = new1qualityProblemDataService.list();
        //获得最早故障日期  和最晚故障日期
        for (New1qualityProblemData new1qualityProblemData : dataList) {
            Date time = new1qualityProblemData.getZbDeliverytime();
//            System.out.println(earlyTime.before(time));
//            System.out.println(time);
            if (time.after(new Date(49,1,1))) {
                if (earlyTime.after(time)) {
                    earlyTime = time;
                }
                if (lateTime.before(time)) {
                    lateTime = time;
                }
            }
        }
        int earlyYear = earlyTime.getYear();
        int earlyMonth = earlyTime.getMonth()+1;
        int lateYear = lateTime.getYear();
        int lateMonth = lateTime.getMonth()+1;
        int range = (lateYear-earlyYear)*12+lateMonth-earlyMonth+1;
        //使用for循环生成中间的月份区间
        monthList = new String[range];
        for (int i = 0; i < range; i++) {
            int addY = (i+earlyMonth-1)/12;
            int resultM = (i+earlyMonth-1)%12+1;
            int resultY = earlyYear + addY +1900;
            monthList[i]=(resultY+"年"+resultM+"月");
        }
        //遍历故障类型次
        List<question18ChartData> series = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            //创建类型数量个数组 数组长度为
            //创建区间数组
            int[] strs = new int[range];
            String titleName = titles.get(i).getJx();
            //遍历全部数据记录
            for (New1qualityProblemData new1qualityProblemData : dataList) {
                //使用地址映射记录 同一时间同一种类的故障件的个数
                Date time = new1qualityProblemData.getZbDeliverytime();
                if (time.after(new Date(49,1,1))) {
                    int year = time.getYear() - earlyYear;
                    int month = time.getMonth() - earlyMonth + 1;
                    if (new1qualityProblemData.getJx().equals(titleName)) {
                        strs[year * 12 + month]++;
                    }
                }
            }
            series.add(new question18ChartData("bar", strs,titleName));
            titleList[i] = titleName;
        }

        //求平均故障率 同种title个数/批次总数
        double[] rates = new double[titles.size()];
        //获得批次总数
        List<New1qualityProblemData> batches = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .select("faultparts_batch").groupBy("faultparts_batch"));
        for (int i = 0; i < titles.size(); i++) {
            int count = new1qualityProblemDataService.count(new QueryWrapper<New1qualityProblemData>()
                    .eq("zb_deliverytime", titles.get(i).getZbDeliverytime()));
            rates[i] = (double)count / batches.size();
        }
        //创建删除标记数组
//        int[] signal = new int[monthList.length];
//
//
//        for (int i = 0; i < titles.size(); i++) {
//            for (int j = 0; j < monthList.length; j++) {
//                if(series.get(i).data[j]<rates[i]*rate){
//
//                    question18ChartData question18ChartData = series.get(i);
//                    int[] data = question18ChartData.getData();
//                    data[j]=0;
//                    question18ChartData.setData(data);
//                    series.set(i, question18ChartData);
//                    signal[j]++;
//                }
//            }
//        }
//
//        //更新 显示数据
//        for (int i = 0; i < titles.size(); i++) {
//            List<Integer> temp = new ArrayList<>();
//            for (int j = 0; j < signal.length; j++) {
//                if(signal[j]!=3){
//                    temp.add(series.get(i).data[j]);
//                }
//            }
//            int[] ints = temp.stream().mapToInt(Integer::valueOf).toArray();
//            series.get(i).setData(ints);
//        }
//
//        //更新月份横坐标
//        List<String> newMonthList = new ArrayList<>();
//        for (int i = 0,j = 0; i < signal.length; i++) {
//            if(signal[i]!=3){
//                newMonthList.add(monthList[i]);
//                }
//        }

        resultMap.put("series",series);
        resultMap.put("monthList", monthList);
        resultMap.put("titleList", titleList);

        return resultMap;
    }

    @RequestMapping("/question18/year")
    public Map<String, Object> question18Year() {
//        if(rate<=0) rate=1.5;
        //故障最早发生日期
        Date earlyTime = new Date();
        //故障最晚发生日期
        Date lateTime = new Date(0,1,1);
        //月份区间列表
        String[] monthList;
        //故障件类型列表
        String[] titleList;
        //结果数据集合
        Map<String, Object> resultMap = new HashMap();
        //获取故障件名称
        List<New1qualityProblemData> titles = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .select("jx")
                .groupBy("jx")
                .orderByDesc("jx")
        );
        titleList = new String[titles.size()];
        //获取所有数据项
        List<New1qualityProblemData> dataList = new1qualityProblemDataService.list();
        //获得最早故障日期  和最晚故障日期
        for (New1qualityProblemData new1qualityProblemData : dataList) {
            Date time = new1qualityProblemData.getZbDeliverytime();
//            System.out.println(earlyTime.before(time));
//            System.out.println(time);
            if(time.getYear()!=49) {
                if (earlyTime.after(time)) {
                    earlyTime = time;
                }
                if (lateTime.before(time)) {
                    lateTime = time;
                }
            }
        }
        int earlyYear = earlyTime.getYear();
        int earlyMonth = earlyTime.getMonth()+1;
        int lateYear = lateTime.getYear();
        int lateMonth = lateTime.getMonth()+1;
        int range = (lateYear-earlyYear)*12+lateMonth-earlyMonth+1;
        //使用for循环生成中间的月份区间
        monthList = new String[range];
        for (int i = 0; i < range; i++) {
            int addY = (i+earlyMonth-1)/12;
            int resultM = (i+earlyMonth-1)%12+1;
            int resultY = earlyYear + addY +1900;
            monthList[i]=(resultY+"年"+resultM+"月");
        }
        //遍历故障类型次
        List<question18ChartData> series = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            //创建类型数量个数组 数组长度为
            //创建区间数组
            int[] strs = new int[range];
            String titleName = titles.get(i).getJx();
            //遍历全部数据记录
            for (New1qualityProblemData new1qualityProblemData : dataList) {
                Date time = new1qualityProblemData.getZbDeliverytime();
                if(time.getYear()!=49) {
                    //使用地址映射记录 同一时间同一种类的故障件的个数
                    int year = time.getYear() - earlyYear;
                    int month = time.getMonth() - earlyMonth + 1;
                    if (new1qualityProblemData.getJx().equals(titleName)) {
                        strs[year * 12 + month]++;
                    }
                }
            }
            series.add(new question18ChartData("bar", strs,titleName));
            titleList[i] = titleName;
        }

        //求平均故障率 同种title个数/批次总数
        double[] rates = new double[titles.size()];
        //获得批次总数
        List<New1qualityProblemData> batches = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .select("faultparts_batch").groupBy("faultparts_batch"));
        for (int i = 0; i < titles.size(); i++) {
            int count = new1qualityProblemDataService.count(new QueryWrapper<New1qualityProblemData>()
                    .eq("zb_deliverytime", titles.get(i).getZbDeliverytime()));
            rates[i] = (double)count / batches.size();
        }
//        //创建删除标记数组
//        int[] signal = new int[monthList.length];
//
//        for (int i = 0; i < titles.size(); i++) {
//            for (int j = 0; j < monthList.length; j++) {
//                question18ChartData question18ChartData = series.get(i);
//                int[] data = question18ChartData.getData();
//                data[j]=0;
//                question18ChartData.setData(data);
//                series.set(i, question18ChartData);
//                signal[j]++;
//            }
//        }
//
//        //更新 显示数据
//        for (int i = 0; i < titles.size(); i++) {
//            List<Integer> temp = new ArrayList<>();
//            for (int j = 0; j < signal.length; j++) {
//                if(signal[j]!=3){
//                    temp.add(series.get(i).data[j]);
//                }
//            }
//            int[] ints = temp.stream().mapToInt(Integer::valueOf).toArray();
//            series.get(i).setData(ints);
//        }
//
//        //更新月份横坐标
//        List<String> newMonthList = new ArrayList<>();
//        for (int i = 0,j = 0; i < signal.length; i++) {
//            if(signal[i]!=3){
//                newMonthList.add(monthList[i]);
//            }
//        }
//        //反向 推导得出被删除记录
//        for (int i = 0; i < titles.size(); i++) {
//            int[] list = new int[lateYear - earlyYear + 1];
//            for (int i1 = 0; i1 < monthList.length; i1++) {
//                String substring = monthList[i1].substring(0, 4);
//                int parseInt = Integer.parseInt(substring);
//                int index = parseInt-earlyYear-1900;
//                list[index]+=series.get(i).data[i1];
//            }
//            series.get(i).setData(list);
//        }

        String[] yearList;
        int yearRange = lateYear - earlyYear+1;
        //使用for循环生成中间的年份
        yearList = new String[yearRange];
        for (int i = 0; i < yearRange; i++) {
            int resultY = earlyYear + 1900;
            yearList[i]=(resultY+i+"年");
        }

        resultMap.put("series",series);
        resultMap.put("yearList", yearList);
        resultMap.put("titleList", titleList);

        return resultMap;
    }

    @RequestMapping("/question18/table")
    public Map<String, Object> question18Table(double rate,int limit,int page) {
        if(rate<=0) rate=1.5;
        //故障最早发生日期
        Date earlyTime = new Date();
        //故障最晚发生日期
        Date lateTime = new Date(0,1,1);
        //月份区间列表
        String[] monthList;
        //故障件类型列表
        String[] titleList;
        //结果数据集合
        Map<String, Object> resultMap = new HashMap();
        //获取故障件名称
        List<New1qualityProblemData> titles = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .select("jx")
                .groupBy("jx")
                .orderByDesc("jx")
        );
        titleList = new String[titles.size()];
        //获取所有数据项
        List<New1qualityProblemData> dataList = new1qualityProblemDataService.list();
        //获得最早故障日期  和最晚故障日期
        for (New1qualityProblemData new1qualityProblemData : dataList) {
            Date time = new1qualityProblemData.getZbDeliverytime();
//            System.out.println(earlyTime.before(time));
//            System.out.println(time);
            if (time.after(new Date(49,1,1))) {
                if (earlyTime.after(time)) {
                    earlyTime = time;
                }
                if (lateTime.before(time)) {
                    lateTime = time;
                }
            }
        }
        int earlyYear = earlyTime.getYear();
        int earlyMonth = earlyTime.getMonth()+1;
        int lateYear = lateTime.getYear();
        int lateMonth = lateTime.getMonth()+1;
        int range = (lateYear-earlyYear)*12+lateMonth-earlyMonth+1;
        //使用for循环生成中间的月份区间
        monthList = new String[range];
        for (int i = 0; i < range; i++) {
            int addY = (i+earlyMonth-1)/12;
            int resultM = (i+earlyMonth-1)%12+1;
            int resultY = earlyYear + addY +1900;
            monthList[i]=(resultY+"年"+resultM+"月");
        }
        //遍历故障类型次
        List<question18ChartData> series = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            //创建类型数量个数组 数组长度为
            //创建区间数组
            int[] strs = new int[range];
            String titleName = titles.get(i).getJx();
            //遍历全部数据记录
            for (New1qualityProblemData new1qualityProblemData : dataList) {
                //使用地址映射记录 同一时间同一种类的故障件的个数
                Date time = new1qualityProblemData.getZbDeliverytime();
                if (time.after(new Date(49,1,1))) {
                    int year = time.getYear() - earlyYear;
                    int month = time.getMonth() - earlyMonth + 1;
                    if (new1qualityProblemData.getJx().equals(titleName)) {
                        strs[year * 12 + month]++;
                    }
                }
            }
            series.add(new question18ChartData("bar", strs,titleName));
            titleList[i] = titleName;
        }

        //求平均故障率 同种title个数/批次总数
        double[] rates = new double[titles.size()];
        //获得总数
        for (int i = 0; i < titles.size(); i++) {
            Map<String, Object> map = new1qualityProblemDataService.getMap(new QueryWrapper<New1qualityProblemData>()
                    .select("date_format(zb_deliverytime,'%Y-%m'),COUNT('zb_deliverytime') AS timeCount")
                    .groupBy("date_format(zb_deliverytime,'%Y-%m')")
                    .eq("zb_deliverytime", titles.get(i).getZbDeliverytime())
            );
            Long timeCount = (Long)map.get("timeCount");
            int count = new1qualityProblemDataService.count(new QueryWrapper<New1qualityProblemData>()
                    .eq("zb_deliverytime", titles.get(i).getZbDeliverytime()));
            rates[i] = count / (double)timeCount;
        }
        //创建删除标记数组
        int[] signal = new int[monthList.length];

        for (int i = 0; i < titles.size(); i++) {
            for (int j = 0; j < monthList.length; j++) {
//                System.out.println(rates[i]);
                Map<String, Object> map = new1qualityProblemDataService.getMap(new QueryWrapper<New1qualityProblemData>()
                        .select("date_format(zb_deliverytime,'%Y-%m'),COUNT('zb_deliverytime') AS timeCount")
                        .groupBy("date_format(zb_deliverytime,'%Y-%m')")
                        .eq("zb_deliverytime", titles.get(i).getZbDeliverytime())
                );
                Long timeCount = (Long)map.get("timeCount");

                if(series.get(i).data[j]/(double)timeCount<rates[i]*rate){
                    question18ChartData question18ChartData = series.get(i);
                    int[] data = question18ChartData.getData();
                    data[j]=0;
                    question18ChartData.setData(data);
                    series.set(i, question18ChartData);
                    signal[j]++;
                }
            }
        }

        //更新 显示数据
        for (int i = 0; i < titles.size(); i++) {
//            List<Integer> temp = new ArrayList<>();
            int[] ints = new int[monthList.length];
            for (int j = 0; j < signal.length; j++) {
                if(signal[j]!=titles.size()){
                    ints[j] = (series.get(i).data[j]);
                }
            }
//            int[] ints = temp.stream().mapToInt(Integer::valueOf).toArray();
//            if(ints==null){
//                ints = new int[1];
//            }
            question18ChartData data = series.get(i);
            data.setData(ints);
            series.set(i, data);

        }

        //更新月份横坐标
        List<String> newMonthList = new ArrayList<>();
        for (int i = 0,j = 0; i < signal.length; i++) {
            if(signal[i]!=titles.size()){
                newMonthList.add(monthList[i]);
            }
        }
        //反向 推导得出被删除记录
        List<NameTimeNum> list = new ArrayList();
        for (int i = 0; i < titles.size(); i++) {
            for (int i1 = 0; i1 < monthList.length; i1++) {
                String substring = monthList[i1].substring(0, monthList[i1].length()-1);
                String[] split = substring.split("年");
                if (split[1].length()==1) {
                    split[1] = "0"+split[1];
                }
                String monthString = split[0]+split[1];
//                if(series.get(i).data==null){
//                    list.add(new NameTimeNum(series.get(i).getName(), monthString, 0));
//                }
                if ( series.get(i).data[i1]==0) {
                    list.add(new NameTimeNum(series.get(i).getName(), monthString, 0));
                }
            }
        }
//        System.out.println(list);
        List<New1qualityProblemData> resultList = new ArrayList();
        for (New1qualityProblemData new1qualityProblemData : dataList) {
            int sign=0;
            for (NameTimeNum nameTimeNum : list) {
                Date date = new1qualityProblemData.getZbDeliverytime();
//                System.out.println(date);
                String year = date.getYear()+1900+"";
                String month = date.getMonth()+1+"";
                String time = year+month;


                if (time.equals(nameTimeNum.getTime())
                        &&new1qualityProblemData
                        .getJx()
                        .equals(nameTimeNum.getName())
                )sign=1;
            }
            if (sign==0&&new1qualityProblemData.getZbDeliverytime().after(new Date(49,1,1))) {
                resultList.add(new1qualityProblemData);
            }
        }
//        System.out.println(resultList);



        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", Util.page(limit, page, resultList));
        mapTable.put("code", 0);
        mapTable.put("count", resultList.size());

        if(resultList.size()!=0){
            NewTableFlag newTableFlag = new NewTableFlag();
            newTableFlag.setTableId(18);
            newTableFlag.setFlag("1");
            newTableFlagService.update(newTableFlag, new QueryWrapper<NewTableFlag>()
                    .eq("table_id", 18));
        }

        return mapTable;
    }
}

class question18ChartData implements Serializable {
    public String type;
    public int[] data;
    public String name;

    public question18ChartData(String type, int[] data, String name) {
        this.type = type;
        this.data = data;
        this.name = name;
    }

    public question18ChartData() {
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

//class NameTimeNum implements Serializable{
//    String time;
//    String name;
//    int num;
//
//    public NameTimeNum(String name, String time, int num) {
//        this.time = time;
//        this.name = name;
//        this.num = num;
//    }
//
//    public NameTimeNum() {
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getNum() {
//        return num;
//    }
//
//    public void setNum(int num) {
//        this.num = num;
//    }
//
//    @Override
//    public String toString() {
//        return "NameTimeNum{" +
//                "time='" + time + '\'' +
//                ", name='" + name + '\'' +
//                ", num=" + num +
//                '}';
//    }
//}