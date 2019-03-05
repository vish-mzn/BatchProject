package com.objectified.dao;

import java.util.Observable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import com.objectified.dto.Batch;

public class Connection extends Observable {
	protected EntityManagerFactory emf = null;

	/* EntityManager */
	public EntityManager em = null;
	
	// protected Employee employee = new Employee();
	protected EntityManager getEntityManager() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("persistence");
			setChanged();
		}

		if (em == null || !em.isOpen()) {
			em = emf.createEntityManager();
			setChanged();
		}
		return em;
	}

	public void closeEntityManagerFactory() {
		if (emf != null) {
			emf.close();
			setChanged();
		}
	}

	protected void closeEntityManager() {
		if (em != null || em.isOpen()) {
			em.close();
			setChanged();
		}
	}

}
