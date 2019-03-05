package com.objectified.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.objectified.dto.Batch;
import com.objectified.dto.Course;

@Repository
public class BatchDaoImpl  implements BatchDao,Observer{

	private Connection cn=null;
	
	   public BatchDaoImpl(Connection ov)
	   {
	      this.cn = ov;
	   }
	   @Override
		public void update(Observable arg0, Object arg1) {
		   
			// TODO Auto-generated method stub
		  this.cn.em=(EntityManager)arg0;
		   
		}
	@Override
	public void addBatch(Batch batch)
	{
		cn.notifyObservers();
		cn.em.persist(batch);
	
	}
	@Override
	public  List<Object> listBatchs(int pageid,int total)
	{
		List<Object> listBatch = new ArrayList<Object>();
		try {
			cn.em = cn.getEntityManager();
			cn.em.getTransaction().begin();
			Query query = cn.em.createQuery("from Batch");
			query.setMaxResults(total);
			query.setFirstResult(pageid - 1);
			listBatch = (List<Object>) query.getResultList();
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.closeEntityManager();
		}
		return listBatch;
	}
	@Override
	public  List<Object> listCourse()
	{
		List<Object> listCourse = new ArrayList<Object>();
		try {
			cn.em = cn.getEntityManager();
			cn.em.getTransaction().begin();
			Query query = cn.em.createQuery("from Course");
			listCourse = (List<Object>) query.getResultList();
			cn.em.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return listCourse;
	}

	
}
