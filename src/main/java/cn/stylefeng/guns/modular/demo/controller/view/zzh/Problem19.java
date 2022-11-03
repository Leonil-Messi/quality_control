package cn.stylefeng.guns.modular.demo.controller.view.zzh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zzh.
 * @date 2021/11/24 16:20
 */
@Controller
public class Problem19 {
    @GetMapping(
            name = "分析页面",
            path = {"/view/problem19"}
    )
    public String platform() {
        return "/modular/business/zzh/problem19.html";
    }
}
