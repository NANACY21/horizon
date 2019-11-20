package com.personal.web.controller;

import com.personal.pojo.Items;
import com.personal.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @RequestMapping("/getAllItem.action")
    public List<Items> getAllItem() {
        List<Items> items = itemsService.getAllItem();
        for (Items o : items) {
            System.out.println(o);
        }
        return itemsService.getAllItem();
    }
}
