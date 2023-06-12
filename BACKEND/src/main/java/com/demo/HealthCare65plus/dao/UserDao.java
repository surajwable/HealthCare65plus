package com.demo.HealthCare65plus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.HealthCare65plus.beans.Patient;
import com.demo.HealthCare65plus.beans.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
}
