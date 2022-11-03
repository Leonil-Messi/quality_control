package cn.stylefeng.guns.modular.demo.controller.view.scy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yyk.
 * @date 2021/11/28 14:30
 */
@Controller
public class Problem23 {
    @GetMapping(
            name = "分析页面",
            path = {"/view/problem23"}
    )
    public String platform() {
        return "/modular/business/scy/problem23.html";
    }
}