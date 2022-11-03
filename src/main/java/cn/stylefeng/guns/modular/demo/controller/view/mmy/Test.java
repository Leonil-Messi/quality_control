package cn.stylefeng.guns.modular.demo.controller.view.mmy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yyk.
 * @date 2021/11/28 14:30
 */
@Controller
public class Test {
    @GetMapping(
            name = "分析页面",
            path = {"http://localhost:8080/first"}
    )
    public String platform() {
        return "/first.html";
    }
}
