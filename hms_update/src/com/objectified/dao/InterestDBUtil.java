package com.objectified.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.objectified.dto.Course;

public class InterestDBUtil extends Connection
{
	public List<Course> readCoursedata()
	{
		System.out.println("inside readcourse");
		List<Course> list = new ArrayList<Course>();
		try 
		{
			em = getEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("from Course");
			list = (List<Course>) query.getResultList();
			
			if(list.isEmpty() || list == null)
			{
				System.out.println("Vishesh");
			}
			em.getTransaction().commit();
		}
		catch (Exception e) {
		}
		finally {
			closeEntityManager();
		}
		return list;
	}
	
}
