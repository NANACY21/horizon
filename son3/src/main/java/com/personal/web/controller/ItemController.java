package com.personal.web.controller;
import com.personal.pojo.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

/**
 * json数据交互示例
 */
@Controller
//@RestController Controller + ResponseBody
public class ItemController {
    /**
     *
     * @param item 注解表示把来自ui的json串转成（封装成）对象类型
     * @return 注解表示返回json格式
     */
    @RequestMapping("/addItem.action")
    @ResponseBody
    public String addItem(@RequestBody Item item) {
        System.out.println(item);
        return "success!!!!!!";
    }

    /**
     *
     * @return 表示把集合解析成json串的集合 json特有的返回值
     */
    @RequestMapping("/listAllItem.action")
    public @ResponseBody List<Item> getAllItem() {
        List<Item> allItem = new ArrayList<>();
        Item item1 = new Item(0,"手机",500);
        Item item2 = new Item(1,"电脑",100);
        Item item3 = new Item(2,"手表",200);

        allItem.add(item1);
        allItem.add(item2);
        allItem.add(item3);
        return allItem;
    }

    @RequestMapping("/getItem.action")
    public @ResponseBody Item getItemById(int id) {
        Item item = new Item(id, "66ab", 12);
        return item;

    }
}
