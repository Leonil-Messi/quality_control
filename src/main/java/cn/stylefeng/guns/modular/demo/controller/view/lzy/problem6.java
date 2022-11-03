package cn.stylefeng.guns.modular.demo.controller.view.lzy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Lzy.
 * @date 2021/11/28 17:41
 */
@Controller
public class problem6 {
    @GetMapping(
            name = "分析页面",
            path = {"view/problem6"}
    )
    public String platform() {
        return "/modular/business/lzy/problem6.html";
    }
}
