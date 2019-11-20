package com.personal.web.controller;

import com.personal.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
    @RequestMapping("/ex1.action")
    public String ex1(int i) throws Exception {
        if (i > 0) {
            throw new CustomException("自定义异常");
        } else {
            throw new Exception("exception!!!!!");
        }
    }
}
