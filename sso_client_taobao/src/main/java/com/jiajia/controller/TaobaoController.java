package com.jiajia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaobaoController {

    @GetMapping("/taobao")
    public String index(){
        return "index";
    }
}
