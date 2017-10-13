package com.octave.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Paosin Von Scarlet on 2017/10/12.
 */
@Controller
public class IndexController {

    @RequestMapping("/home")
    public String index() {
        return "index";
    }
}
