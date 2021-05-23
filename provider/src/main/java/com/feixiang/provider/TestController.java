package com.feixiang.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    private final Logger logger= LoggerFactory.getLogger(TestController.class);

    @GetMapping(value = "/echo/{str}")
    @ResponseBody
    public String echo(@PathVariable String str) {

        logger.error("provider error");
        return "hello alibaba "+str;
    }
}
