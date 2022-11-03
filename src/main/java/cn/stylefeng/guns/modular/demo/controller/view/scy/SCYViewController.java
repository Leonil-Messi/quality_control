package cn.stylefeng.guns.modular.demo.controller.view.scy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SCYViewController {
    @GetMapping(
            name = "分析页面",
            path = {"/view/problem2"}
    )
    public String preblem2() {
        return "/modular/business/scy/problem2.html";
    }

    @GetMapping(
            name = "分析页面",
            path = {"/view/problem21"}
    )
    public String problem21() { return "/modular/business/scy/problem21.html"; }
    @GetMapping(
            name = "分析页面",
            path = {"/view/problem22"}
    )
    public String problem22() { return "/modular/business/scy/problem22.html"; }
    @GetMapping(
            name = "分析页面",
            path = {"/view/problem9"}
    )
    public String problem9() { return "/modular/business/scy/problem9.html"; }
    @GetMapping(
            name = "分析页面",
            path = {"/view/problem10"}
    )
    public String problem10() { return "/modular/business/scy/problem10.html"; }
    @GetMapping(
            name = "分析页面",
            path = {"/view/problem17"}
    )
    public String problem17() { return "/modular/business/scy/problem17.html"; }
    @GetMapping(
            name = "分析页面",
            path = {"/view/problem18"}
    )
    public String problem18() { return "/modular/business/scy/problem18.html"; }
//    @GetMapping(
//            name = "分析页面",
//            path = {"/view/problem23"}
//    )
//    public String problem23() { return "/modular/business/scy/problem23.html"; }
 @GetMapping(
            name = "分析页面",
            path = {"/view/problem24"}
    )
    public String problem24() { return "/modular/business/scy/problem24.html"; }

    @GetMapping(
            name = "分析页面",
            path = {"/view/problem26"}
    )
    public String problem26() { return "/modular/business/scy/problem26.html"; }

    @GetMapping(
            name = "分析页面",
            path = {"/view/problem30"}
    )
    public String problem30() { return "/modular/business/scy/problem30.html"; }
    @GetMapping(
            name = "分析页面",
            path = {"/view/problem31"}
    )
    public String problem31() { return "/modular/business/scy/problem31.html"; }

    @GetMapping(
            name = "分析页面",
            path = {"/view/problem32"}
    )
    public String problem32() { return "/modular/business/scy/problem32.html"; }

    @GetMapping(
            name = "分析页面",
            path = {"/view/problem33"}
    )
    public String problem33() { return "/modular/business/scy/problem33.html"; }
    @GetMapping(
            name = "分析页面",
            path = {"/view/problem34"}
    )
    public String problem34() { return "/modular/business/scy/problem34.html"; }
    @GetMapping(
            name = "分析页面",
            path = {"/view/problem35"}
    )
    public String problem35() { return "/modular/business/scy/problem35.html"; }
}
