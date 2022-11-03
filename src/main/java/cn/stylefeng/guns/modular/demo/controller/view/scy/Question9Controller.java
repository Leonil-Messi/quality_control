package cn.stylefeng.guns.modular.demo.controller.view.scy;

import cn.stylefeng.guns.modular.demo.dao.New3finishedProductDesignDataDao;
import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import cn.stylefeng.guns.modular.demo.entity.New2equipmentDesignData;
import cn.stylefeng.guns.modular.demo.entity.NewTableFlag;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;
import cn.stylefeng.guns.modular.demo.service.New2equipmentDesignDataService;
import cn.stylefeng.guns.modular.demo.service.NewTableFlagService;
import cn.stylefeng.guns.modular.demo.vo.Predict1VO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/data")
public class Question9Controller extends ApiController {
    @Resource
    private New2equipmentDesignDataService new2equipmentDesignDataService;
    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;
    @Resource
    private NewTableFlagService newTableFlagService;

    @GetMapping("/question9/version")
    public Map<String,Object> question9Version() {
        List<New1qualityProblemData> aircraftVersionList = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
                .select("jx")
                .groupBy("jx")
        );
        List<String> list = new ArrayList<>();
        for (New1qualityProblemData new1qualityProblemData : aircraftVersionList) {
            list.add(new1qualityProblemData.getJx());
        }
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("list", list);
        return mapTable;
    }

    @GetMapping("/question9")
    public Map<String,Object> question9(String aircraftVersion,int page,int limit) {
//        if (aircraftVersion == null) {
//            aircraftVersion="title";
//        }
        List<New2equipmentDesignData> jx = new2equipmentDesignDataService.list(new QueryWrapper<New2equipmentDesignData>()
                .eq("jx", aircraftVersion)
        );
        List<String> list1 = new ArrayList<>();
        for (New2equipmentDesignData new2equipmentDesignData : jx) {
            list1.add(new2equipmentDesignData.getZbUnit());
        }
        List<New2equipmentDesignData> aircraftVersionList = new ArrayList<>();
        if (list1.size() != 0) {
            aircraftVersionList = new2equipmentDesignDataService.list(new QueryWrapper<New2equipmentDesignData>()
                    .in("zb_unit", list1)
            );
        }


//        List<String> list2 = new ArrayList<>();
//        for (New2equipmentDesignData new2equipmentDesignData : aircraftVersionList) {
//            list2.add(new2equipmentDesignData.getJx());
//        }
//        List<New1qualityProblemData> resultList = new1qualityProblemDataService.list(new QueryWrapper<New1qualityProblemData>()
//                .in("jx", list2)
//        );
        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", Util.page(limit, page, aircraftVersionList));
        mapTable.put("code", 0);
        mapTable.put("count", aircraftVersionList.size());
//        if(aircraftVersionList.size()!=0){
//            NewTableFlag newTableFlag = new NewTableFlag();
//            newTableFlag.setTableId(9);
//            newTableFlag.setFlag("1");
//            newTableFlagService.update(newTableFlag, new QueryWrapper<NewTableFlag>()
//                    .eq("table_id", 9));
//        }

        return mapTable;
    }
}
