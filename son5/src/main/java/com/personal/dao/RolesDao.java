package com.personal.dao;

import com.personal.pojo.Roles;
import com.personal.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesDao extends JpaRepository<Roles, Integer> {

}
