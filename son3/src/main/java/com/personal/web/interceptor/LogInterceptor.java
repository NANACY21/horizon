package com.personal.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 */
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("run before the controller method run");

        //你猜是啥功能
//        if (request.getRequestURL().toString().endsWith("/login.action")) {
//            return true;
//        } else {
//            HttpSession session = request.getSession();
//            if (null != session.getAttribute("uID")) {
//                return true;
//            } else {
//                response.sendRedirect("login.jsp");
//
//            }
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("run at the controller method return immediately");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("run at the method run finished");
    }
}
