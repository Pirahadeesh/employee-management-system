package com.employeemanagementSys.Springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagementSys.Springboot.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

}
