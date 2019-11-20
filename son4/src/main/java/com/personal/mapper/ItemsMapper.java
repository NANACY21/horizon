package com.personal.mapper;

import com.personal.pojo.Items;

public interface ItemsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKey(Items record);
}