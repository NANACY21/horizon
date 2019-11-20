package com.personal.web.controller;
import com.personal.pojo.JobExperience;
import com.personal.pojo.NUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

/**ok
 * ui的data传到控制器示例
 * 校验器示例
 * 数据回显示例
 */
@Controller
public class ParamController {

    /**
     * 普通数据类型(cdt)的参数绑定
     * ui组件名必须为SEX
     * @param name ui到db 基于方法参数
     * @return
     */
    @RequestMapping("/cdt.action")
    public String test1(String name, int age, @RequestParam("SEX") String sex) {
        System.out.println(name + age + sex);
        return "index.jsp";
    }

    /**
     * pojo类型的参数绑定
     * 校验器示例
     * 数据回显示例
     * 只校验1分组
     *
     * @param nUser         springmvc会把这个参数类名首字母小写放在request作用域
     * @param br 挨着要数据校验的对象，一个该对象对应一个pojo
     * @return
     */
    @RequestMapping("/pojodt.action")
    public String test2(@Validated(value = {ValiGroup1.class}) NUser nUser, BindingResult br, Model model) {
        System.out.println(nUser);
        //数据校验返回是否有异常
        boolean b = br.hasErrors();
        if (b) {
            FieldError fr = br.getFieldError("nickname");
            model.addAttribute("nickname", nUser.getNickname());
            model.addAttribute("password", nUser.getPassword());
            model.addAttribute("nicknameErr", fr.getDefaultMessage());
            //得到所有数据校验的异常
            List<ObjectError> allErrors = br.getAllErrors();
            for (ObjectError oe : allErrors) {
                System.out.println(oe.getDefaultMessage());
//                model.addAttribute("nicknameErr", oe.getDefaultMessage());
            }
            return "nuser.jsp";
        }
        return "nuser.jsp";
    }

    /**自定义方法参数
     * @param je
     * @return
     */
    @RequestMapping("/custom.action")
    public String test3(JobExperience je) {
        System.out.println(je);
        return "index.jsp";
    }

    /**数组类型的参数绑定
     * @param hobby
     * @return
     */
    @RequestMapping("/Arrayt.action")
    public String test4(String[] hobby) {
        //这样可以得到所有选中的复选框的value
        for (String h : hobby) {
            System.out.println(h);
        }
        return "index.jsp";
    }

    /**
     * 携带数据到ui，直接访问该servlet
     * @param model
     * @return
     */
    @RequestMapping("/toUI.action")
    public String list(Model model) {
        NUser nUser = new NUser();
        nUser.setNickname("gyx");
        NUser nUser2 = new NUser();
        nUser2.setNickname("wyh");
        NUser nUser3 = new NUser();
        nUser3.setNickname("qyx");
        List<NUser> ALLNUSER = new ArrayList<>();
        ALLNUSER.add(nUser);
        ALLNUSER.add(nUser2);
        ALLNUSER.add(nUser3);

        model.addAttribute("ALLNUSER", ALLNUSER);
        return "List818.jsp";
    }

    /**
     * 集合类型的参数绑定
     * @param je
     * @return
     */
    @RequestMapping("/Collectiont.action")
    public String test5(JobExperience je) {
        System.out.println(je);
        for (NUser j : je.getnUsers()) {
            System.out.println(j.getNickname());
        }
        return "index.jsp";
    }
}
