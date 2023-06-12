package com.demo.HealthCare65plus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.HealthCare65plus.beans.HealthHistory;
import com.demo.HealthCare65plus.beans.Patient;
import com.demo.HealthCare65plus.beans.User;
import com.demo.HealthCare65plus.service.HealthHistoryService;
import com.demo.HealthCare65plus.service.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired(required=false)
	UserService userService;
	
	@Autowired
	HealthHistoryService healthHistoryService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/users/{userid}")
	public ResponseEntity<User> getUserById(@PathVariable int userId) {
		User user = userService.getUserById(userId);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	//update user
	@PutMapping("/users")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		int n=userService.updateUser(user);
		if(n>0)
			return new ResponseEntity<String>("user updated successfully "+user,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	//delete user
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/users/{userid}")
	public ResponseEntity<String> deleteUser(@PathVariable int userid) {
		boolean status=userService.deleteUser(userid);
		if(status)
			return new ResponseEntity<String>("user deleted successfully "+ userid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get user for login
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/login")
	public ResponseEntity<User> getUserForValidation(@RequestBody User user1) {
		List<User> userList= userService.getAllUsers();
		for(User user:userList)
		{
			if(user.getEmail().equals(user1.getEmail()) && user.getPassword().equals(user1.getPassword()))
			{
				return new ResponseEntity(user,HttpStatus.OK);
			}
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/users/{userId}/bookAppointment")
	public ResponseEntity<HealthHistory> bookAppointment(@PathVariable int userId, @RequestBody HealthHistory healthHistory) {
	    // Check if the user is a patient
	    User user = userService.getUserById(userId);
	    if (user instanceof Patient) {
	        healthHistory.setPatient((Patient) user); // Set the patient for the appointment
	        HealthHistory bookedAppointment = healthHistoryService.createHealthHistory(healthHistory);
	        return ResponseEntity.status(HttpStatus.CREATED).body(bookedAppointment);
	    } else {
	        return ResponseEntity.badRequest().build(); // Return error response for non-patient users
	    }
	}

}
