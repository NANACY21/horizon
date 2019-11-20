package com.personal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**标准控制器只3种方法返回值
 * 这是一个普通的pojo，方法随意写
 * 这是注解式servlet
 *
 * 以前访问servlet：提交表单访问，地址栏直接访问，js函数跳到servlet，servlet都是
 * 给一个urlPatterns，从而访问这个servlet，
 *
 * 这里也给一个urlPatterns，仅仅这样就行了
 */
@Controller

/*请求时前加这个路径 则 /user/test9.action
这样方法前是相同urlPattern也没事，类前加的不一样就行了
 */
//@RequestMapping("/user")
public class UserController {

    /**
     * 这是请求映射注解，参数是urlPatterns
     * @return 第一种方法返回值
     */
    @RequestMapping("/test9.action")
    public ModelAndView test1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.jsp");//如果配置视图解析器不加.jsp
        return modelAndView;
    }

    /**这样只能处理get请求，地址栏直接访问的那种是get请求
     *
     * 请求必须包含name，且值必须为admin；请求不能包含age
     * @return 第二种方法返回值
     */
    @RequestMapping(value = "/test2.action",method = RequestMethod.GET,params = {"name=admin","!age"})
    public String test2() {
        return "index.jsp";
    }


//    配置一个通用方法，这个方法可以跳转到任何视图（页面）上


    /**
     * 第三种方法返回值
     * @param response
     * @throws IOException
     */
    @GetMapping("test3.acton")
    public void text3(HttpServletResponse response) throws IOException {
        System.out.println("test3");
        response.sendRedirect("index.jsp");//也可以跳到另一个servlet
    }

    //这样只能处理get请求
    //最常见
    @GetMapping("test4.action")
    public String test4() {
        //return "index.jsp";//这是请求转发，
        return "redirect:index.jsp";//这是重定向，地址栏变了
    }

    //该方法参数可以写，很灵活
    @GetMapping("test5.action")
    public ModelAndView test5() {
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");
        list.add("dddd");
        ModelAndView modelAndView = new ModelAndView();

        //携带data到页面，相当于request设置属性
        modelAndView.addObject("list", list);
        modelAndView.setViewName("index.jsp");

        return modelAndView;
    }

    @GetMapping("test6.action")
    public String test6(Model model) {
        //相当于request设置属性
        model.addAttribute("messi", "nancy");
        return "index.jsp";//默认请求转发
    }


    /**文件上传，不影响接收ui的data pojo和普通类型的值
     *
     * @param request
     * @param pic
     * @param title
     * @return
     */
    @PostMapping("/upload.action")
    public String upload(HttpServletRequest request, MultipartFile pic,String title) {
        System.out.println("来自ui的data:" + title);
        if (pic != null && pic.getOriginalFilename() != null && pic.getOriginalFilename().length() > 0) {
            System.out.println(pic.getOriginalFilename());
            //上传的文件的名
            String originalFilename = pic.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
            //上传到这个位置
            String savePath = "D:\\university\\3_2\\horizon\\son3\\src\\main\\webapp\\upload";
            System.out.println("路径："+request.getContextPath());
            File file = new File(savePath + "\\" + newName);
            try {
                pic.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "index.jsp";
    }
}
