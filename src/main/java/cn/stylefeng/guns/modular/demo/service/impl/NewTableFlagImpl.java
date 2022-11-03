package cn.stylefeng.guns.modular.demo.service.impl;

import cn.stylefeng.guns.modular.demo.dao.New1qualityProblemDataDao;
import cn.stylefeng.guns.modular.demo.dao.NewTableFlagDao;
import cn.stylefeng.guns.modular.demo.entity.New1qualityProblemData;
import cn.stylefeng.guns.modular.demo.entity.NewTableFlag;
import cn.stylefeng.guns.modular.demo.service.New1qualityProblemDataService;
import cn.stylefeng.guns.modular.demo.service.NewTableFlagService;
import cn.stylefeng.roses.kernel.db.api.sqladapter.table.TableFieldListSql;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service("NewTableFlagService")
public class NewTableFlagImpl extends ServiceImpl<NewTableFlagDao, NewTableFlag> implements NewTableFlagService {

}
