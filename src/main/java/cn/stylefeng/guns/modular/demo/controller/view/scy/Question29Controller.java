package cn.stylefeng.guns.modular.demo.controller.view.scy;

import cn.stylefeng.guns.modular.demo.dao.New3finishedProductDesignDataDao;
import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;
import cn.stylefeng.guns.modular.demo.vo.Predict1VO;
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
public class Question29Controller extends ApiController {
    @Resource
    private New1qualityProblemDataService new1qualityProblemDataService;
    @Resource
    private New3finishedProductDesignDataDao new3finishedProductDesignDataDao;

    @GetMapping("/question29")
    public Map<String,Object> question29(String condition,int page,int limit) {
        if (condition == null) {
            condition="title";
        }
        List<Predict1VO> dataList;
        if("title".equals(condition)){
            dataList = new3finishedProductDesignDataDao.select1FaultypartsTitleEqual3productName();
        }else{
            dataList = new3finishedProductDesignDataDao.select1FaultypartsModelEqual3productModel();
        }

        Map<String, Object> mapTable = new HashMap<>();
        mapTable.put("data", Util.page(limit, page, dataList));
        mapTable.put("code", 0);
        mapTable.put("count", dataList.size());
        return mapTable;
    }


}
