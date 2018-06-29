package fr.uni.training.spring.aop.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

import fr.uni.training.spring.aop.User;

/**
 * 
 * @author houahidi
 *
 */
public class SimpleProfiler {
	
	public Object profile(ProceedingJoinPoint pjp, String name, int age)
			throws Throwable {
		
		 Logger logger  = Logger.getLogger(SimpleProfiler.class);
		
		logger.info("Avant --------------------------------");
		StopWatch clock = new StopWatch("Profiling for '" + name + "' and '"
				+ age + "'");
		try {
			clock.start(pjp.toShortString());
			
			User user =  (User)pjp.proceed();
			user.setAge( user.getAge() + 1);
			
			return user;
		} finally {
			clock.stop();
			logger.info("Après " + clock.prettyPrint() +"------");
		}
	}
}