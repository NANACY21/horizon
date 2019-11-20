package com.personal.service.impl;
import com.personal.mapper.ItemsMapper;
import com.personal.pojo.Items;
import com.personal.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Items> getAllItem() {

        return itemsMapper.getAllItem();
    }
}
