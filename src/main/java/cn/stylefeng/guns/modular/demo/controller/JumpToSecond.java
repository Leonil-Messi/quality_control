package cn.stylefeng.guns.modular.demo.controller;

import cn.stylefeng.guns.modular.demo.dao.NewTableFlagDao;
import cn.stylefeng.guns.modular.demo.entity.NewTableFlag;
import cn.stylefeng.guns.modular.demo.service.NewTableFlagService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("jump")
public class JumpToSecond extends ApiController {
    @Resource
    private NewTableFlagService newTableFlagService;

    @RequestMapping("/toFirst")
    public String jumpToFirst(){
        return "/register.html";
    }

    @RequestMapping("/toSecond")
    public String jumpToSecond(){
        return "/seconds.html";
    }

    @RequestMapping("/toThird")
    public String jumpToThird(){
        return "/third.html";
    }

    @RequestMapping("/toDeploy")
    public String jumpToDeploy(){
        return "/Deploy.html";
    }

    @ResponseBody
    @RequestMapping("/judge")
    public List<NewTableFlag> JudgeRed(){
        QueryWrapper<NewTableFlag> qw = new QueryWrapper<>();
        qw.eq("flag","1");
        List<NewTableFlag> newTableFlags = this.newTableFlagService.list(qw);
        return newTableFlags;
    }

    @ResponseBody
    @RequestMapping("/update")
    public R update(int id, String s) {
        NewTableFlag newTableFlags= new NewTableFlag();
        newTableFlags.setFlag(s);
        newTableFlags.setTableId(id);
        return success(this.newTableFlagService.updateById(newTableFlags));
    }

    @ResponseBody
    @RequestMapping("/aaa")
    public String AAA(@RequestParam("p") String p){
        System.out.println(p);
        return "更改配置成功";
    }
}
