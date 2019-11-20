package com.personal.mapper;

import com.personal.pojo.T_user;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface T_userMapper {
    List<T_user> getT_usersAndItems();

    /**
     * 分页查询
     *
     * PageHelper5插件 Mybatis分页
     * @param rowBounds
     * @return
     */
    List<T_user> getT_userPage(RowBounds rowBounds);

    T_user getT_userByUID(long ID);

    public int addT_user(T_user t_user);

}
