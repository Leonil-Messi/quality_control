package cn.stylefeng.guns.modular.demo.controller.view.rule;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yyk.
 * @date 2021/12/1 12:05
 */
@Controller
public class anaysis {
    @GetMapping(
            name = "ana1",
            path = {"/role/ana1"}
    )
    public String platform1() {
        return "/modular/business/rule/anaysis1.html";
    }

    @GetMapping(
            name = "ana5",
            path = {"/role/ana5"}
    )
    public String platform5() {
        return "/modular/business/rule/anaysis5.html";
    }

    @GetMapping(
            name = "ana6",
            path = {"/role/ana6"}
    )
    public String platform2() {
        return "/modular/business/rule/anaysis6.html";
    }


    @GetMapping(
            name = "ana7",
            path = {"/role/ana7"}
    )
    public String platform7() {
        return "/modular/business/rule/anaysis7.html";
    }

    @GetMapping(
            name = "ana8",
            path = {"/role/ana8"}
    )
    public String platform3() {
        return "/modular/business/rule/anaysis8.html";
    }

    @GetMapping(
            name = "ana17",
            path = {"/role/ana17"}
    )
    public String platform4() {
        return "/modular/business/rule/anaysis17.html";
    }

    @GetMapping(
            name = "ana18",
            path = {"/role/ana18"}
    )
    public String platform18() {
        return "/modular/business/rule/anaysis17.html";
    }


    @GetMapping(
            name = "ana19",
            path = {"/role/ana19"}
    )
    public String platform19() {
        return "/modular/business/rule/anaysis19.html";
    }

    @GetMapping(
            name = "ana20",
            path = {"/role/ana20"}
    )
    public String platform20() {
        return "/modular/business/rule/anaysis20.html";
    }

}
