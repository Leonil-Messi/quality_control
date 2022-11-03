package cn.stylefeng.guns.modular.demo.controller;



import cn.stylefeng.guns.modular.demo.controller.view.scy.Util;
import cn.stylefeng.guns.modular.demo.dao.New1qualityProblemDataDao;
import cn.stylefeng.guns.modular.demo.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (New1qualityProblemData)表控制层
 *
 * @author makejava
 * @since 2021-11-26 15:56:44
 */
@RestController
@RequestMapping("new1qualityProblemData")
public class New1qualityProblemDataController extends ApiController {

    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;


    @Resource
    private New1qualityProblemDataDao new1qualityProblemDataDao;


    @RequestMapping(path = "problem1")
    public R problem1() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.groupBy("DATE_FORMAT(time,'%Y-%m')");
        wrapper.select("DATE_FORMAT(time,'%Y-%m') as month, count(*) as itemNums");
        wrapper.orderByAsc("month");
        return success(this.new1qualityProblemDataService.listMaps(wrapper));
    }
    @RequestMapping("/question1/table")
    public Map<String, Object> question1Table(String[] s,int limit,int page){
        List<New1qualityProblemData> resultList = new ArrayList<>();
        for (int i =0;i<s.length;i++) {
            List<New1qualityProblemData> dataList = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                    .eq("DATE_FORMAT(time,'%Y-%m')", s[i])
            );
            resultList.addAll(dataList);
        }
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", Util.page(limit, page, resultList));
        mapTable.put("code", 0);
        mapTable.put("count", resultList.size());
        return mapTable;
    }
    @RequestMapping(path = "problem3")
    public R problem3() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("time,jx");
        return success(this.new1qualityProblemDataService.listMaps(wrapper));
    }
    @RequestMapping("/question3/table")
    public Map<String, Object> question3Table(String[] s,String[] t,int limit,int page){
        List<New1qualityProblemData> resultList = new ArrayList<>();
        for (int i =0;i<s.length;i++) {
            List<New1qualityProblemData> dataList = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                    .eq("DATE_FORMAT(time,'%Y%m')", s[i]).eq("jx",t[i])
            );
            resultList.addAll(dataList);
        }
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", Util.page(limit, page, resultList));
        mapTable.put("code", 0);
        mapTable.put("count", resultList.size());
        return mapTable;
    }
    @RequestMapping("/problem15")
    public R problem15() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.groupBy("zb_unit");
        wrapper.select("zb_unit, count(*) as itemNums");
        wrapper.orderByDesc("itemNums");

        // SQL:
        // SELECT   zb_unit, count(*) as itemNums   FROM new_1quality_problem_data    GROUP BY zb_unit ORDER BY itemNums

        return success(this.new1qualityProblemDataService.listMaps(wrapper));
    }

    @RequestMapping("/problem16")
    public R problem16() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.groupBy("zb_batch");
        wrapper.select("zb_batch, count(*) as itemNums");
        wrapper.orderByDesc("itemNums");

        // SQL:
        // SELECT   zb_batch, count(*) as itemNums   FROM new_1quality_problem_data    GROUP BY zb_batch ORDER BY itemNums

        return success(this.new1qualityProblemDataService.listMaps(wrapper));
    }

    @RequestMapping(path = "problem4")
    public R problem4() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.groupBy("zb_troop");
        wrapper.select("zb_troop, count(*) as itemNums");
        wrapper.orderByDesc("itemNums");
        return success(this.new1qualityProblemDataService.listMaps(wrapper));
    }
    @RequestMapping("/problem4/table")
    public Map<String, Object> problem4Table(double rate,Integer limit,Integer page) {
        int count;
        float totalAccidentRate;
        int type;
        List<New1qualityProblemData> resultList = new ArrayList<>();
        count = new1qualityProblemDataService.count();
        List<New1qualityProblemData> list = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .groupBy("zb_troop")
                .select("zb_troop")
        );
        type = list.size();
        totalAccidentRate = count / (float) type;
        for (New1qualityProblemData data : list) {
            List<New1qualityProblemData> dataList = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                    .eq("zb_troop", data.getZbTroop())
            );
            int num = dataList.size();
            if (num >= totalAccidentRate * rate) {
                resultList.addAll(dataList);
            }
        }
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", Util.page(limit, page, resultList));
        mapTable.put("code", 0);
        mapTable.put("count", resultList.size());
        return mapTable;
    }

    @RequestMapping(path = "problem11")
    public R problem11() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.groupBy("failure_mode");
        wrapper.select("failure_mode, count(*) as itemNums");
        return success(this.new1qualityProblemDataService.listMaps(wrapper));
    }
    @RequestMapping("/problem11/table")
    public Map<String, Object> problem11Table(double rate,int limit,int page) {
        int count;
        float totalAccidentRate;
        int type;
        List<New1qualityProblemData> resultList = new ArrayList<>();
        count = new1qualityProblemDataService.count();
        List<New1qualityProblemData> list = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .groupBy("failure_mode")
                .select("failure_mode")
        );
        type = list.size();
        totalAccidentRate = count / (float) type;
        for (New1qualityProblemData data : list) {
            List<New1qualityProblemData> dataList = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                    .eq("failure_mode", data.getFailureMode())
            );
            int num = dataList.size();
            if (num >= totalAccidentRate * rate) {
                resultList.addAll(dataList);
            }
        }
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", Util.page(limit, page, resultList));
        mapTable.put("code", 0);
        mapTable.put("count", resultList.size());
        return mapTable;
    }

    @RequestMapping(path = "problem13")
    public R problem13() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.groupBy("environment");
        wrapper.select("environment, count(*) as itemNums");
        return success(this.new1qualityProblemDataService.listMaps(wrapper));
    }
    @RequestMapping("/problem13/table")
    public Map<String, Object> problem13Table(double rate,int limit,int page) {
        int count;
        float totalAccidentRate;
        int type;
        List<New1qualityProblemData> resultList = new ArrayList<>();
        count = new1qualityProblemDataService.count();
        List<New1qualityProblemData> list = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .groupBy("environment")
                .select("environment")
        );
        type = list.size();
        totalAccidentRate = count / (float) type;
        for (New1qualityProblemData data : list) {
            List<New1qualityProblemData> dataList = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                    .eq("environment", data.getEnvironment())
            );
            int num = dataList.size();
            if (num >= totalAccidentRate * rate) {
                resultList.addAll(dataList);
            }
        }
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", Util.page(limit, page, resultList));
        mapTable.put("code", 0);
        mapTable.put("count", resultList.size());
        return mapTable;
    }

    @RequestMapping(path = "problem12")
    public R problem12() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("failure_mode, time");
        wrapper.ne("time","1949-01-01");
        return success(this.new1qualityProblemDataService.listMaps(wrapper));
    }
    @PostMapping("addData")
    public R insert(@RequestBody List<New1qualityProblemData> new1qualityProblemData) {
        return success(this.new1qualityProblemDataService.saveBatch(new1qualityProblemData));
    }
    @RequestMapping(path = "getId")
    public R getId() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("quality_id");
        return success(this.new1qualityProblemDataService.listMaps(wrapper));
    }
    @RequestMapping(path = "/problem23")
    public R selectFaultypartTitle() {
        QueryWrapper<New1qualityProblemData> qw = new QueryWrapper<>();
        qw.select("faultyparts_title,count(*) as faultpartsNum");
        qw.groupBy("faultyparts_title");
        return success(this.new1qualityProblemDataService.listMaps(qw));
    }
    @RequestMapping(path = "/problem9")
    public R problem9() {
        QueryWrapper<New1qualityProblemData> qw = new QueryWrapper<>();
        qw.select("count(*) as nums, time");
        qw.groupBy("time");
        qw.orderByAsc("time");
        return success(this.new1qualityProblemDataService.listMaps(qw));
    }
    @RequestMapping(path = "/problem25")
    public R selectFaultypartModel() {
        QueryWrapper<New1qualityProblemData> qw = new QueryWrapper<>();
        qw.select("faultparts_model,count(*) as faultpartsNum");
        qw.groupBy("faultparts_model");
        return success(this.new1qualityProblemDataService.listMaps(qw));
    }
    @RequestMapping(path = "/problem39")
    public Map<String, Object> select39(int limit,int page) {
        QueryWrapper<New1qualityProblemData> qw = new QueryWrapper<>();
        qw.select("key_factory,count(*) faultpartsUnitNum");
        qw.groupBy("key_factory");
        List<New1qualityProblemData> n1 = this.new1qualityProblemDataService.list(qw);
        List<FaultypartsCount> faultypartsCounts = new ArrayList<>();
        for(int i=0;i<n1.size();i++){
            FaultypartsCount faultypartsCount = new FaultypartsCount();
            int n = selectcountByname(n1.get(i).getKeyFactory());
            faultypartsCount.setKeyFactory(n1.get(i).getKeyFactory());
            faultypartsCount.setCount(n);
            faultypartsCount.setNum(n1.size());
            faultypartsCounts.add(faultypartsCount);
        }
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", MmyUtil.page(limit, page, faultypartsCounts));
        mapTable.put("code", 0);
        mapTable.put("count", faultypartsCounts.size());
        return mapTable;
    }
    private int selectcountByname(String a){
        QueryWrapper<New1qualityProblemData> qw=new QueryWrapper();
        qw.eq("key_factory",a);
        Integer count = new1qualityProblemDataService.count(qw);
        return count;
    }
    @RequestMapping(path = "/problem40")
    public Map<String, Object> select40(int limit,int page) {
        QueryWrapper<New1qualityProblemData> qw = new QueryWrapper<>();
        qw.select("key_batch,count(*) faultpartsUnitNum");
        qw.groupBy("key_batch");
        List<New1qualityProblemData> n1 = this.new1qualityProblemDataService.list(qw);
        List<KeyBatch> keyBatches = new ArrayList<>();
        for(int i=0;i<n1.size();i++){
            KeyBatch keyBatch = new KeyBatch();
            int n = selectcountByBatch(n1.get(i).getKeyBatch());
            keyBatch.setKeyBatch(n1.get(i).getKeyBatch());
            keyBatch.setCount(n);
            keyBatch.setNum(n1.size());
            keyBatches.add(keyBatch);
        }
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", MmyUtil.page(limit, page, keyBatches));
        mapTable.put("code", 0);
        mapTable.put("count", keyBatches.size());
        return mapTable;
    }
    private int selectcountByBatch(String a){
        QueryWrapper<New1qualityProblemData> qw=new QueryWrapper();
        qw.eq("key_batch",a);
        Integer count = new1qualityProblemDataService.count(qw);
        return count;
    }
    @RequestMapping(path = "/problem41")
    public Map<String, Object> select41(int limit,int page) {
        QueryWrapper<New1qualityProblemData> qw = new QueryWrapper<>();
        qw.select("key_deliverytime,count(*) faultpartsUnitNum");
        qw.groupBy("key_deliverytime");
        List<New1qualityProblemData> n1 = this.new1qualityProblemDataService.list(qw);
        List<KeyDeliveryTime> keyDeliveryTimes = new ArrayList<>();
        for(int i=0;i<n1.size();i++){
            KeyDeliveryTime keyDeliveryTime = new KeyDeliveryTime();
            Date date = n1.get(i).getKeyDeliverytime();
            String time = DataToString(date);
            keyDeliveryTime.setKeyDeliverytime(time);
            int n = selectcountBytime(n1.get(i).getKeyDeliverytime());
            keyDeliveryTime.setCount(n);
            keyDeliveryTime.setNum(n1.size());
            keyDeliveryTimes.add(keyDeliveryTime);
        }
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", MmyUtil.page(limit, page, keyDeliveryTimes));
        mapTable.put("code", 0);
        mapTable.put("count", keyDeliveryTimes.size());
        return mapTable;
    }
    private int selectcountBytime(Date a){
        QueryWrapper<New1qualityProblemData> qw=new QueryWrapper();
        qw.eq("key_deliverytime",a);
        Integer count = new1qualityProblemDataService.count(qw);
        return count;
    }
    private String DataToString(Date date) {
        SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        String date1 = sformat.format(date);
        String[] times = date1.split("-");
        String time = times[0] + times[1]+times[2];
        return time;
    }
    @RequestMapping("/listall")
    public Map<String, Object> list(int limit,int page) {
        List<New1qualityProblemData> new1qualityProblemDataa = this.new1qualityProblemDataService.list();
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", MmyUtil.page(limit, page,new1qualityProblemDataa));
        mapTable.put("code", 0);
        mapTable.put("count", new1qualityProblemDataa.size());
        return mapTable;
    }

    @RequestMapping(path="problem38")

    public R problem38() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.groupBy("key_name");
        wrapper.select("count(*) as value,key_name as name");
        wrapper.orderByDesc("value");

        // SQL:
        // SELECT   zb_unit, count(*) as itemNums   FROM new_1quality_problem_data    GROUP BY zb_unit ORDER BY itemNums

        return success(this.new1qualityProblemDataService.listMaps(wrapper));
    }


    @RequestMapping(path="problem19")

    public List<problem19b> problem19() {
        int symbol=1;
        List<problem19> list=this.new1qualityProblemDataDao.problem19back();
        String name[]=new String[list.size()];
        //统计所有工厂名
        for (int i = 0,j=0; i < list.size(); i++){
            symbol=1;
            for (int s = 0; s <=j; s++){
                if(name[s]!=null&&list.get(i).getFactorname().equals(name[s])){
                    symbol=0;
                    break;
                }
            }
            if(symbol==1){
                name[j]=list.get(i).getFactorname();
                j=j+1;
            }
        }
        int len=0;
        for(int i = 0; i < name.length; i++){
            if(name[i]!=null){
                len++;
            }
        }
        //根据工厂统计其各种类型数
        List<problem19b> listb=new ArrayList<>(len);

        for(int i=0;i<len;i++){
            problem19b enti = new problem19b();
            enti.setFactorname(name[i]);
            enti.setNofix(0);enti.setOnemon(0);enti.setTwomon(0);
            enti.setThreemon(0);enti.setMore(0);
            listb.add(enti);
        }

        problem19b t = new problem19b();

        for(int i=0;i< list.size();i++){
            for(int j=0;j<len;j++){
                if(list.get(i).getFactorname().equals(listb.get(j).getFactorname())){
                    if(list.get(i).getTimediff()<0){
                        t=listb.get(j);t.setNofix(listb.get(j).getNofix()+1);listb.set(j,t);
                        t=null;
                    }
                    if(list.get(i).getTimediff()<=30&&list.get(i).getTimediff()>=0){
                        t=listb.get(j);t.setOnemon(listb.get(j).getOnemon()+1);listb.set(j,t);t=null;
                        t=listb.get(j);t.setTwomon(listb.get(j).getTwomon()+1);listb.set(j,t);t=null;
                        t=listb.get(j);t.setThreemon(listb.get(j).getThreemon()+1);listb.set(j,t);t=null;
                    }
                    if(list.get(i).getTimediff()<=60&&list.get(i).getTimediff()>30){
                        t=listb.get(j);t.setTwomon(listb.get(j).getTwomon()+1);listb.set(j,t);t=null;
                        t=listb.get(j);t.setThreemon(listb.get(j).getThreemon()+1);listb.set(j,t);t=null;
                    }
                    if(list.get(i).getTimediff()<=90&&list.get(i).getTimediff()>60){
                        t=listb.get(j);t.setThreemon(listb.get(j).getThreemon()+1);listb.set(j,t);t=null;
                    }
                    if(list.get(i).getTimediff()>90){
                        t=listb.get(j);t.setMore(listb.get(j).getMore()+1);listb.set(j,t);t=null;
                    }

                }
            }
        }
        return listb;
    }

    @RequestMapping("/problem20")
    public List<problem44> list20(Integer limit,Integer page) {
        List<problem44> listjx = this.new1qualityProblemDataDao.problem20back1();
        List<problem44> listun = this.new1qualityProblemDataDao.problem20back2();
        List<problem44> list = new ArrayList<>(listjx.size()+listun.size());
        list.addAll(listjx);list.addAll(listun);
        return list;
    }

    @RequestMapping("/problem20tab")
    public Map<String, Object> list20tab(Integer limit,Integer page) {
        List<problem44> listjx = this.new1qualityProblemDataDao.problem20back1();
        List<problem44> listun = this.new1qualityProblemDataDao.problem20back2();
        List<problem44> list = new ArrayList<>(listjx.size()+listun.size());
        int sum=0; int avg;
        int wrona[]= new int[list.size()];
        List<problem44> wrongobj = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++){
            sum=Integer.parseInt(list.get(i).getValue())+sum;
        }
        avg=sum/5;
        for (int i = 0, j=0; i < list.size(); i++){
            int a=Integer.parseInt(list.get(i).getValue());
            if(a>=avg) {
                wrona[j]=1;
                j++;
            }
            else{wrona[j]=0;j++;}
        }

        for (int i = 0; i < wrona.length; i++){
            if(wrona[i]==1){
                wrongobj.add(list.get(i));
            }}
        list.addAll(listjx);list.addAll(listun);
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data",page(limit, page,wrongobj));
        mapTable.put("code", 0);
        mapTable.put("count", wrongobj.size());
        return mapTable;
    }
    public List page(Integer limit,Integer page,List list){
        if (limit == null || page == null||limit<0||page<0) {
            return list;
        }
        int start = (page - 1) * limit;
        int end = page * limit;
        if(start>list.size()){
            return new ArrayList<Object>();
        }else if(end>list.size()){
            return list.subList(start, list.size());
        }
        return list.subList(start, end);
    }

}
