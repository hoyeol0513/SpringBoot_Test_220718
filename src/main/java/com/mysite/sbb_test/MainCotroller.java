package com.mysite.sbb_test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainCotroller {
    @RequestMapping("/")
    public String root() {return "redirect:/article/list";}

    @RequestMapping("test")
    @ResponseBody
    public String test(){ return "Sbb_Test";}
}
