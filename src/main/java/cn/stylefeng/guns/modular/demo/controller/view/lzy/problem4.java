package cn.stylefeng.guns.modular.demo.controller.view.lzy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Lzy.
 * @date 2021/11/25 15:02
 */
@Controller
public class problem4 {
    @GetMapping(
            name = "分析页面",
            path = {"view/problem4"}
    )
    public String platform() {
        return "/modular/business/lzy/problem4.html";
    }
}
