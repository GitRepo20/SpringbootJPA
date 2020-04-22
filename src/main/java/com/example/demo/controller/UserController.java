package com.example.demo.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.GlobalAutowiring;
import com.example.demo.model.Movies;
import com.example.demo.model.User;

@RestController
public class UserController {

	@Autowired
	GlobalAutowiring globalAutowiring;
	@Autowired
	SessionFactory sessionFactory;

	/*OneToOne User to Subscription*/
	@RequestMapping("/createuser")
	public void createUser() {
		try {
			globalAutowiring.getUserService().createUser();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*OneToMany User to Multiple Profile */
	@RequestMapping("/createprofile")
	public void createProfile() {
		try {
			globalAutowiring.getUserService().createProfile();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	/*ManyToMany Movies To Profile*/
	@RequestMapping("/createprofilemovies")
	public void createProfileMovies() {
		try {
			globalAutowiring.getUserService().createProfileMovies();			
		}catch(Exception e) {
			e.printStackTrace();
		}			
	}
	
	/*OneToOne User to Subscription*/
	@PostMapping(path="/saveusersubscription")
	public User saveUserSubscription(@RequestBody User user) {
		
		User savedUser=null;
		try {
			savedUser = globalAutowiring.getUserService().saveUserSubscription(user);
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return savedUser;		
	}
	
	/*OneToMany User to Multiple Profile */
	@PostMapping(path="/saveuserprofile" , consumes= "application/json") 
	public User saveUserProfile(@RequestBody User user) {
		
		User savedUser=null;
		try {
			savedUser = globalAutowiring.getUserService().saveUserProfile(user);
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return savedUser;		
	}
	
	@PostMapping(path="/savemoviesprofile" , consumes= "application/json") 
	public Movies saveMoviesProfile(@RequestBody Movies movies) {
		
		Movies savedMovies=null;
		try {
			savedMovies = globalAutowiring.getUserService().saveProfileMovies(movies);
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return savedMovies;		
	}
	
}
