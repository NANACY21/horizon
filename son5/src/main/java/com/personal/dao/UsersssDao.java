package com.personal.dao;

import com.personal.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**有分页 排序功能
 * 不好使！！！增删改好使 查询不好使！！！！
 */
public interface UsersssDao extends PagingAndSortingRepository<User, Integer> {


}
