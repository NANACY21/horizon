package com.personal.dao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import com.personal.pojo.User;
//jpql、sql、hql
/**该接口不好使，jar冲突？？？？？？所有查询都不好使 spring/springdata/jdbc/hibernate jar冲突？？
 * 没有实现类了
 * <p>
 * 实体 主键类型
 */
public interface UsersDao extends Repository<User, Integer> {
	/**
	 * 方法名一定这么起，是pojo属性名
	 * 找名字是该参数的
	 * @param username
	 * @return
	 */
	List<User> findByUsernameIs(String username);

	List<User> findByUsernameLike(String username);

	/**
	 * 这里，方法没有命名规则
	 * where pojo属性=...
	 * @param username
	 * @param age
	 * @return
	 */
	@Query(value = "from User where username =:uname and age = :age")
	List<User> getUsersByNameAndAge(@Param(value = "uname") String username, @Param(value = "age") int age);

	/**方法随便写
	 * nativeQuery = true->表示是原生sql 原生sql不起别名
	 * @param name 随便命名？？？
	 * @return
	 */
	@Query(value = "select id,name,age from users where name= ?", nativeQuery = true)
	List<User> queryUsers(String name);
}