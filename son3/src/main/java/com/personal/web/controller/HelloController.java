package com.personal.web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HelloController implements Controller {

    /**
     * 这就是doget/dopost
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "spring66mvc");
        mav.setViewName("hello.jsp");
        return mav;
    }
}
