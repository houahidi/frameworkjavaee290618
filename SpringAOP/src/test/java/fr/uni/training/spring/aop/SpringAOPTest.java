package fr.uni.training.spring.aop;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.uni.training.spring.aop.User;
import fr.uni.training.spring.aop.UserService;
import fr.uni.training.spring.aop.aspect.SimpleProfiler;





@ContextConfiguration(locations = {"classpath:spring-aop.xml" }) 
@RunWith(SpringJUnit4ClassRunner.class)

public class SpringAOPTest {
	
	static Logger logger  = Logger.getLogger(SpringAOPTest.class);
	
	@Resource(name="service")
	private UserService userService;
	
	
	@Test  
	public void testService(){
		
		logger.info("Debut Test");
		int age = 40;
		User user = userService.getUser("Hafid OUAHIDI", age);
		logger.info("Résultat Test" + user.getAge());		
		
		assertEquals(age, user.getAge());
		
	}
	
	
}
