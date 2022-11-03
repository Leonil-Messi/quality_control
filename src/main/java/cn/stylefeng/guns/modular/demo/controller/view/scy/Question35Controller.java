package cn.stylefeng.guns.modular.demo.controller.view.scy;

import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import cn.stylefeng.guns.modular.demo.entity.New5finishedproductManufacturingdata;
import cn.stylefeng.guns.modular.demo.entity.NewTableFlag;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;
import cn.stylefeng.guns.modular.demo.service.New5finishedproductManufacturingdataService;
import cn.stylefeng.guns.modular.demo.service.NewTableFlagService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class Question35Controller extends ApiController {
    @Resource
    private New5finishedproductManufacturingdataService new5finishedproductManufacturingdataService;
    @Resource
    private NewTableFlagService newTableFlagService;
    @GetMapping("/question35")
    public Map<String,List> question35(String condition) {
        //创建返回的map
        HashMap<String, List> map = new HashMap<>();
        //创建data数组 遍历存入所有人员节点
        List<Node> data = new ArrayList<>();
        //获得所有记录
        List<New5finishedproductManufacturingdata> list = new5finishedproductManufacturingdataService.list();
        //获得所有故障件制造人员
        List<New5finishedproductManufacturingdata> people = new5finishedproductManufacturingdataService
                .list(new QueryWrapper<New5finishedproductManufacturingdata>()
                        .select("faultparts_person")
                        .groupBy("faultparts_person"));
        //获得相应的source节点 加入data
        if ("name".equals(condition)) {
            List<New5finishedproductManufacturingdata> titles = new5finishedproductManufacturingdataService
                    .list(new QueryWrapper<New5finishedproductManufacturingdata>()
                            .select("faultyparts_title")
                            .groupBy("faultyparts_title")
                    );
            for (New5finishedproductManufacturingdata title : titles) {
                data.add(new Node(title.getFaultypartsTitle()));
            }
        }
        if ("version".equals(condition)) {
            List<New5finishedproductManufacturingdata> titles = new5finishedproductManufacturingdataService
                    .list(new QueryWrapper<New5finishedproductManufacturingdata>()
                            .select("faultparts_model")
                            .groupBy("faultparts_model")
                    );
            for (New5finishedproductManufacturingdata title : titles) {
                data.add(new Node(title.getFaultpartsModel()));
            }
        }
        if ("batch".equals(condition)) {
            List<New5finishedproductManufacturingdata> titles = new5finishedproductManufacturingdataService
                    .list(new QueryWrapper<New5finishedproductManufacturingdata>()
                            .select("faultparts_batch")
                            .groupBy("faultparts_batch")
                    );
            for (New5finishedproductManufacturingdata title : titles) {
                data.add(new Node(title.getFaultpartsBatch()));
            }
        }

        //将人员Node 存入List
        //处理从数据库中取出的人员列表
        List<String> nodeList = new ArrayList<>();
        for (New5finishedproductManufacturingdata person : people) {
            String personList = person.getFaultpartsPerson();
//            String substring = personList.substring(1, personList.length()-1);
            String[] split = personList.split(";");
            for (String s : split) {
                if (!nodeList.contains(s)) {
                    nodeList.add(s);
                }
            }
        }
        //创建links数组
        List<Link> links = new ArrayList<>();
        //获得所有故障名称
        //for 存储所有故障件 与 制造人员关系
        Map<String, Link> records = new HashMap<>();
        for (New5finishedproductManufacturingdata manufacturingdata : list) {
            String title = null;
            //判断condition 为 name version batch
            if ("name".equals(condition)) {
                title = manufacturingdata.getFaultypartsTitle();
            }
            if ("version".equals(condition)) {
                title = manufacturingdata.getFaultpartsModel();
            }
            if ("batch".equals(condition)) {
                title = manufacturingdata.getFaultpartsBatch();
            }
            //处理从数据库中取出的人员列表
            String person = manufacturingdata.getFaultpartsPerson();
//            String substring = person.substring(1, person.length()-1);
            String[] split = person.split(";");
            for (String s : split) {
                Link link = records.get(title+s);
                if (link == null) {

                    records.put(title+s, new Link(title, s, 1));
                }else{
                    link.value+=1;
                    records.put(title+s, link);
                }
            }

        }

        for (Map.Entry<String, Link> entry : records.entrySet()) {
            links.add(entry.getValue());
        }
        for (String s : nodeList) {
            data.add(new Node(s));
        }
        //将source节点加入data
        //data,links数组放入 map中
        map.put("data", data);
        map.put("links", links);
        return map;
    }

    @RequestMapping("/question35/table")
    public Map<String, Object> question35Table(String condition,double rate,int limit,int page) {

        //创建返回的map
        HashMap<String, List> map = new HashMap<>();
        //创建data数组 遍历存入所有人员节点
        List<Node> data = new ArrayList<>();
        //获得所有记录
        List<New5finishedproductManufacturingdata> list = new5finishedproductManufacturingdataService.list();
        //获得所有故障件制造人员
        List<New5finishedproductManufacturingdata> people = new5finishedproductManufacturingdataService
                .list(new QueryWrapper<New5finishedproductManufacturingdata>()
                        .select("faultparts_person")
                        .groupBy("faultparts_person"));
        //获得相应的source节点 加入data
        if ("name".equals(condition)) {
            List<New5finishedproductManufacturingdata> titles = new5finishedproductManufacturingdataService
                    .list(new QueryWrapper<New5finishedproductManufacturingdata>()
                            .select("faultyparts_title")
                            .groupBy("faultyparts_title")
                    );
            for (New5finishedproductManufacturingdata title : titles) {
                data.add(new Node(title.getFaultypartsTitle()));
            }
        }
        if ("version".equals(condition)) {
            List<New5finishedproductManufacturingdata> titles = new5finishedproductManufacturingdataService
                    .list(new QueryWrapper<New5finishedproductManufacturingdata>()
                            .select("faultparts_model")
                            .groupBy("faultparts_model")
                    );
            for (New5finishedproductManufacturingdata title : titles) {
                data.add(new Node(title.getFaultpartsModel()));
            }
        }
        if ("batch".equals(condition)) {
            List<New5finishedproductManufacturingdata> titles = new5finishedproductManufacturingdataService
                    .list(new QueryWrapper<New5finishedproductManufacturingdata>()
                            .select("faultparts_batch")
                            .groupBy("faultparts_batch")
                    );
            for (New5finishedproductManufacturingdata title : titles) {
                data.add(new Node(title.getFaultpartsBatch()));
            }
        }

        //将人员Node 存入List
        //处理从数据库中取出的人员列表
        List<String> nodeList = new ArrayList<>();
        for (New5finishedproductManufacturingdata person : people) {
            String personList = person.getFaultpartsPerson();
//            String substring = personList.substring(1, personList.length()-1);
            String[] split = personList.split(";");
            for (String s : split) {
                if (!nodeList.contains(s)) {
                    nodeList.add(s);
                }
            }
        }
        //创建links数组
        List<Link> links = new ArrayList<>();
        //获得所有故障名称
        //for 存储所有故障件 与 制造人员关系
        Map<String, Link> records = new HashMap<>();
        for (New5finishedproductManufacturingdata manufacturingdata : list) {
            String title = null;
            //判断condition 为 name version batch
            if ("name".equals(condition)) {
                title = manufacturingdata.getFaultypartsTitle();
            }
            if ("version".equals(condition)) {
                title = manufacturingdata.getFaultpartsModel();
            }
            if ("batch".equals(condition)) {
                title = manufacturingdata.getFaultpartsBatch();
            }
            //处理从数据库中取出的人员列表
            String person = manufacturingdata.getFaultpartsPerson();
//            String substring = person.substring(1, person.length()-1);
            String[] split = person.split(";");
            for (String s : split) {
                Link link = records.get(title+s);
                if (link == null) {

                    records.put(title+s, new Link(title, s, 1));
                }else{
                    link.value+=1;
                    records.put(title+s, link);
                }
            }

        }

        for (Map.Entry<String, Link> entry : records.entrySet()) {
            links.add(entry.getValue());
        }
        for (String s : nodeList) {
            data.add(new Node(s));
        }
        //将source节点加入data
        //data,links数组放入 map中
        map.put("data", data);
        map.put("links", links);

        //创建map 记录 每个故障件对应的故障人员参与总数
        Map<String, Integer> recordMap = new HashMap<>();
        for (Link link : links) {
            String source = link.getSource();
            Integer value = recordMap.get(source);
            if (value == null) {
                recordMap.put(source, link.value);
            }else{
                recordMap.put(source, link.value+value);
            }
        }


        //新建resultList  将符合比率的记录集合 新建resultList
        List<New5finishedproductManufacturingdata> resultList
                = new ArrayList<New5finishedproductManufacturingdata>();
        for (Link link : links) {
            if(link.getValue()/(double)recordMap.get(link.source)>rate){
                resultList.addAll(
                        new5finishedproductManufacturingdataService
                                .list(new QueryWrapper<New5finishedproductManufacturingdata>()
                                        .like("faultparts_person", link.target)
                                        .eq("faultyparts_title", link.source)
                                )
                );
            }
        }



        Map<Integer, New5finishedproductManufacturingdata> testMap = new HashMap<>();
        for (New5finishedproductManufacturingdata new5finishedproductManufacturingdata : resultList) {
            testMap.put(new5finishedproductManufacturingdata.getFaultyId(), new5finishedproductManufacturingdata);
        }
        List<New5finishedproductManufacturingdata> newResultList = new ArrayList<>();
        for (Map.Entry<Integer, New5finishedproductManufacturingdata> integerNew1qualityProblemDataEntry : testMap.entrySet()) {
            newResultList.add(integerNew1qualityProblemDataEntry.getValue());
        }

        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", Util.page(limit, page, newResultList));
        mapTable.put("code", 0);
        mapTable.put("count", newResultList.size());


        if(resultList.size()!=0){
            NewTableFlag newTableFlag = new NewTableFlag();
            newTableFlag.setTableId(35);
            newTableFlag.setFlag("1");
            newTableFlagService.update(newTableFlag, new QueryWrapper<NewTableFlag>()
                    .eq("table_id", 35));
        }
        return mapTable;
    }

}

class Node implements Serializable {
    String name;

    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Link implements Serializable{
    String source;
    String target;
    int value;

    public Link(String source, String target, int value) {
        this.source = source;
        this.target = target;
        this.value = value;
    }

    public Link() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Link{" +
                "source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", value=" + value +
                '}';
    }
}
