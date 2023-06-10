package com.demo.HealthCare65plus.service;

import java.util.List;

import com.demo.HealthCare65plus.beans.User;

public interface UserService {

	User createUser(User user);

	User getUserById(int userId);

	int updateUser(User user);

	boolean deleteUser(int userid);

	List<User> getAllUsers();

}
