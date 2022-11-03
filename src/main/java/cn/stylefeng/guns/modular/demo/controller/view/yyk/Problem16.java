package cn.stylefeng.guns.modular.demo.controller.view.yyk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yyk.
 * @date 2021/11/24 16:20
 */
@Controller
public class Problem16 {
    @GetMapping(
            name = "分析页面",
            path = {"/view/problem16"}
    )
    public String platform() {
        return "/modular/business/yyk/problem16.html";
    }
}
