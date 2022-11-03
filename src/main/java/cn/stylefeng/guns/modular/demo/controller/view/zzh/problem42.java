package cn.stylefeng.guns.modular.demo.controller.view.zzh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class problem42 {

    @GetMapping(
            name = "分析页面",
            path = {"/view/problem42"}
    )
    public String platform() {
        return "/modular/business/zzh/problem42.html";
    }
}