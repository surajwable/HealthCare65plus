package com.demo.HealthCare65plus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.HealthCare65plus.beans.User;
import com.demo.HealthCare65plus.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;


	@Override
	public User createUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> optionalUser = userDao.findById(userId);
		return optionalUser.orElse(null);
	}

	@Override
	public int updateUser(User user) {
		Optional<User> optionalUser = userDao.findById(user.getUserId());
		if (optionalUser.isPresent()) {
			User existingUser = optionalUser.get();
			existingUser.setName(user.getName());
			existingUser.setContact(user.getContact());
			existingUser.setAddress(user.getAddress());
			existingUser.setDateOfBirth(user.getDateOfBirth());
			existingUser.setEmail(user.getEmail());
			existingUser.setPassword(user.getPassword());
			userDao.save(existingUser);
			return 1;
		}
		return 0;
	}

	@Override
	public boolean deleteUser(int userId) {
		Optional<User> optionalUser = userDao.findById(userId);
		if (optionalUser.isPresent()) {
			userDao.deleteById(userId);
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
}
