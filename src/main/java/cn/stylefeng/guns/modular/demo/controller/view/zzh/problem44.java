package cn.stylefeng.guns.modular.demo.controller.view.zzh;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class problem44 {

    @GetMapping(
            name = "分析页面",
            path = {"/view/problem44"}
    )
    public String platform() {
        return "/modular/business/zzh/problem44.html";
    }
}