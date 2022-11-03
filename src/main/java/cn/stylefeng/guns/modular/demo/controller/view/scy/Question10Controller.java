package cn.stylefeng.guns.modular.demo.controller.view.scy;

import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import cn.stylefeng.guns.modular.demo.entity.New2equipmentDesignData;
import cn.stylefeng.guns.modular.demo.entity.New3finishedProductDesignData;
import cn.stylefeng.guns.modular.demo.entity.NewTableFlag;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;
import cn.stylefeng.guns.modular.demo.service.New2equipmentDesignDataService;
import cn.stylefeng.guns.modular.demo.service.New3finishedProductDesignDataService;
import cn.stylefeng.guns.modular.demo.service.NewTableFlagService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
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
public class Question10Controller extends ApiController {
    @Resource
    private New3finishedProductDesignDataService new3finishedProductDesignDataService;
    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;
    @Resource
    private NewTableFlagService newTableFlagService;

    @GetMapping("/question10/type")
    public Map<String,Object> question10Type() {
        List<New1qualityProblemData> faultpartsTypeList = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .select("faultyparts_type")
                .groupBy("faultyparts_type")
        );
        List<String> list = new ArrayList<>();
        for (New1qualityProblemData new1qualityProblemData : faultpartsTypeList) {
            list.add(new1qualityProblemData.getFaultypartsType());
        }
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("list", list);
        return mapTable;
    }

    @GetMapping("/question10")
    public Map<String,Object> question10(String faultpartsType,int page,int limit) {
//        if (aircraftVersion == null) {
//            aircraftVersion="title";
//        }
        List<New3finishedProductDesignData> typeList = new3finishedProductDesignDataService.list(new QueryWrapper<New3finishedProductDesignData>()
                .eq("product_type", faultpartsType)
        );
//        List<String> list1 = new ArrayList<>();
//        for (New2equipmentDesignData new2equipmentDesignData : jx) {
//            list1.add(new2equipmentDesignData.getZbUnit());
//        }
//        List<New2equipmentDesignData> aircraftVersionList = new ArrayList<>();
//        if (list1.size() != 0) {
//            aircraftVersionList = new2equipmentDesignDataService.list(new QueryWrapper<New2equipmentDesignData>()
//                    .in("zb_unit", list1)
//            );
//        }


//        List<String> list2 = new ArrayList<>();
//        for (New2equipmentDesignData new2equipmentDesignData : aircraftVersionList) {
//            list2.add(new2equipmentDesignData.getJx());
//        }
//        List<New1qualityProblemData> resultList = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
//                .in("jx", list2)
//        );
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", Util.page(limit, page, typeList));
        mapTable.put("code", 0);
        mapTable.put("count", typeList.size());

//        if(typeList.size()!=0){
//            NewTableFlag newTableFlag = new NewTableFlag();
//            newTableFlag.setTableId(10);
//            newTableFlag.setFlag("1");
//            newTableFlagService.update(newTableFlag, new QueryWrapper<NewTableFlag>()
//                    .eq("table_id", 10));
//        }
        return mapTable;
    }
}
