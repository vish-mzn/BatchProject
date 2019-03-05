package com.objectified.dao;

import java.util.Observable;

import javax.persistence.EntityManager;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionBeginAspect  extends Connection{
	@Around("execution(* com.objectified.dao.BatchDaoImpl.addBatch(..))") // point-cut
																			// expression
	public void logAround(ProceedingJoinPoint joinPoint) throws Exception {

		System.out.println("Before running the addBatch() in the BatchDaoImpl.java class!");
		System.out.println("Hijacked Method name : " + joinPoint.getSignature().getName());
		System.out.println("************************");
		try {

			// Object o=em;
			em = getEntityManager();
			em.getTransaction().begin();
			
			 joinPoint.proceed();
			 em.getTransaction().commit();

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
			closeEntityManagerFactory();
		}

	}

}
