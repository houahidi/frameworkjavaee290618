package fr.uni.training.spring.aop.impl;

import fr.uni.training.spring.aop.User;
import fr.uni.training.spring.aop.UserService;

/**
 * 
 * @author houahidi
 *
 */
public class DefaultUserService implements UserService {
	
	
	public User getUser(String name, int age) {
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {		
//			e.printStackTrace();
//		}
		return new User(name, age);
	}
}