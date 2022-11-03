package cn.stylefeng.guns.modular.demo.controller.view.mmy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yyk.
 * @date 2021/11/28 14:30
 */
@Controller
public class Problem41 {
    @GetMapping(
            name = "分析页面",
            path = {"/view/problem41"}
    )
    public String platform() {
        return "/modular/business/mmy/problem41.html";
    }
}
