package cn.stylefeng.guns.modular.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.stylefeng.guns.modular.demo.dao.NewTestDao;
import cn.stylefeng.guns.modular.demo.entity.NewTest;
import cn.stylefeng.guns.modular.demo.service.NewTestService;
import org.springframework.stereotype.Service;

/**
 * (NewTest)表服务实现类
 *
 * @author makejava
 * @since 2021-11-24 19:42:42
 */
@Service("newTestService")
public class NewTestServiceImpl extends ServiceImpl<NewTestDao, NewTest> implements NewTestService {

}
