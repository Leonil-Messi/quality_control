package cn.stylefeng.guns.modular.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yyk.
 * @date 2021/11/24 19:57
 */
@Controller
public class Problem1 {
    @GetMapping(
            name = "分析页面",
            path = {"/view/problem1"}
    )
    public String platform() {

        return "/modular/business/zzh/problem1.html";
    }
}
