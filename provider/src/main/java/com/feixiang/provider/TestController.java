package com.feixiang.provider;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping(value = "/echo/{str}")
    @ResponseBody
    public String echo(@PathVariable String str) {
        return "hello alibaba "+str;
    }
}
