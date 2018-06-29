package fr.orsys.bibliotheque.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class SampleAspect {
	
	
	public void log1() {
		System.out.println("============ Execution de l'aspect");
		
	}
	public Object log2(ProceedingJoinPoint pjp) {
		
		Object resultat = null;
		try {
			System.out.println("<<<<<<<<<<<<Debut Execution de l'aspect : " +pjp.getSignature().getName());
			resultat = pjp.proceed();
			System.out.println(">>>>>>>>>>>>Après Execution de l'aspect");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return resultat;
	}

}
