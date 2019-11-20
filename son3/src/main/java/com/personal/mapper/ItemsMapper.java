package com.personal.mapper;

import com.personal.pojo.Items;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface ItemsMapper {
    List<Items> getAllItem();
}