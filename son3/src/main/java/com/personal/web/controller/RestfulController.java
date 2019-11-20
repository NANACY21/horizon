package com.personal.web.controller;

import com.personal.pojo.Item;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Restful
 */
//@CrossOrigin()用处是什么
@RestController//这样返回json对象
public class RestfulController {
    /**
     * 请求url getItem/3
     * @param id
     * @return
     */
    @RequestMapping(value = "/getItem/{ID}")
    public Item getItem(@PathVariable("ID") int id) {
        Item item = new Item(id, "n66nnnn", 12345679);
        return item;
    }
}
