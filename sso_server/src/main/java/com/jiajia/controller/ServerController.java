package com.jiajia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ServerController {

    @GetMapping("/checkToken")
    public String checkToken(String redirectUrl, HttpSession session, Model model){
        //获取token
        String token = (String)session.getServletContext().getAttribute("token");
        if(StringUtils.isEmpty(token)){
            model.addAttribute("redirectUrl",redirectUrl);
            return "login";
        }else{
            return null;
        }
    }
}
