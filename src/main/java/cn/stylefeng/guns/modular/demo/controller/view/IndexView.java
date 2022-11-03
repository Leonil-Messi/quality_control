package cn.stylefeng.guns.modular.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yyk.
 * @date 2021/11/27 13:56
 */
@Controller
public class IndexView {
    @GetMapping(
            name = "首页",
            path = {"/index"}
    )
    public String platform() {
        return "/index.html";
    }
}
