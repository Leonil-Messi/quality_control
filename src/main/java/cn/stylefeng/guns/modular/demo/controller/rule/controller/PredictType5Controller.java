package cn.stylefeng.guns.modular.demo.controller.rule.controller;

import cn.hutool.core.util.StrUtil;
import cn.stylefeng.guns.modular.demo.dao.New3finishedProductDesignDataDao;
import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;
import cn.stylefeng.guns.modular.demo.service.New3finishedProductDesignDataService;
import cn.stylefeng.guns.modular.demo.vo.Predict1VO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import org.beetl.ext.fn.StringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yyk.
 * @date 2021/12/6 9:25
 */
@RestController
@RequestMapping("rule")
public class PredictType5Controller {
    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;



    //predict19
    @RequestMapping("predict19")
    public R predict19() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("* ,time-fixed_time as differTime");

        List<Map<String, String>> listMaps = this.new1qualityProblemDataService.listMaps(wrapper);

        for (int i = 0; i < listMaps.size(); i++) {
            // 间隔时间
            int differINSTANCE = 7;
            //System.out.println(String.valueOf(listMaps.get(i).get("differTime")));
            if (Integer.valueOf(String.valueOf(listMaps.get(i).get("differTime"))) < differINSTANCE) {
                listMaps.remove(i);
            }
        }
        return R.ok(listMaps);
    }

    //predict20
    @RequestMapping("predict20")
    public R predict20() {
        List<New1qualityProblemData> new1qualityProblemData = this.new1qualityProblemDataService.list();

        List result = new ArrayList();
        // 查看有多少机型
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("jx");
        wrapper.groupBy("jx");
        List<Map<String, String>> jxlistMaps = this.new1qualityProblemDataService.listMaps(wrapper);

        for (int j = 0; j < jxlistMaps.size(); j++) {
            String jxName = String.valueOf(jxlistMaps.get(j).get("jx"));


            //存在的人员
            HashMap<String, String> stringList = new HashMap<>();
            List nameList = new ArrayList();
            List nList = new ArrayList();

            int k = 0;
            // 查找此机型下的所有人员
            for (int i = 0; i < new1qualityProblemData.size(); i++) {

                if (new1qualityProblemData.get(i).getJx().equals(jxName)) {
                    k++;
                    String fixPersons = new1qualityProblemData.get(i).getFixedPerson();

                    //[王三将;许啸天]
                    fixPersons = StrUtil.removePrefix(fixPersons, "[");
                    fixPersons =StrUtil.removeSuffix(fixPersons,"]");

                    //[王三将，许啸天]
                    List<String> itemstringList = StrUtil.split(fixPersons, ";");

                    for (int q = 0; q < itemstringList.size(); q++) {
                        //如果有此 key - name，则num加一
                        if ( stringList.containsKey(itemstringList.get(q)) ){
                            String numKey = itemstringList.get(q) + "num";
                            //获取旧值
                            Integer oldValue = Integer.valueOf(stringList.get(numKey));
                            //删除旧的
                            stringList.remove(numKey);
                            //添加新的
                            stringList.put(numKey, String.valueOf(oldValue+1));
                        } else {
                            //如果总数组没有就加入
                            // 加入 name 还要加入num
                            stringList.put(itemstringList.get(q),itemstringList.get(q));
                            nList.add(itemstringList.get(q));

                        //    添加 num
                            String numKey = itemstringList.get(q) + "num";
                            stringList.put(numKey, String.valueOf(1));
                            nameList.add(numKey);
                        }
                    }

                }


            }

            // 对于某一个机型，上面for执行完毕会生成下面map  ： stringList
            //{
            //          "王三将num": "2",
            //          "许啸天num": "2",
            //          "王三将": "王三将",
            //          "许啸天": "许啸天"
            //}

            //共有多少条 此机型对应的

            //List itemList = new ArrayList();
            HashMap itemHash = new HashMap();
            itemHash.put("allNums",k);
            itemHash.put("jx",jxName);
            itemHash.put("nList",nList);
            itemHash.put("nameList",nameList);

            for (int m = 0; m < nameList.size(); m++) {
                //得到每个人员对应的数量
                Integer value = Integer.valueOf(stringList.get(nameList.get(m)));

                //占比 大于 20%
                if (value / k > 0.2) {
                    itemHash.put(nList.get(m),nList.get(m));
                    itemHash.put(nameList.get(m),stringList.get(nameList.get(m)));
                }

            }
            result.add(itemHash);

        }

        return  R.ok(result);
    }


}
