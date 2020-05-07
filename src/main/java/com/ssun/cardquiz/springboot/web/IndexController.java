package com.ssun.cardquiz.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    //파일 확장자 - > index.mustache
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
