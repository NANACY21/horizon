package com.personal.pojo;

import javax.persistence.*;

/**
 * 人
 */
//标识是一个实体类
@Entity
//该实体类对应的表名
@Table(name = "users")
public class User {

	@Id//表示是主键
	/**
	 * 主键生成策略
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column
	private Integer id;
	//指定db中字段名与之对应
	@Column(name = "name", length = 20, nullable = false)
	private String username;
	@Column
	private int age;

	//关联关系
	//一个角色可以有多个人，一个人只有一个角色
//	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)//立即加载该属性
//	@JoinColumn(name = "roles_id")
//	private Roles roles;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	public Roles getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Roles roles) {
//		this.roles = roles;
//	}


	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", age=" + age +
				'}';
	}
}
