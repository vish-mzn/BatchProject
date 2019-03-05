package com.objectified.dao;

import java.util.List;
import com.objectified.dto.Batch;

public interface BatchDao {

	public void addBatch(Batch p);
	public List<Object> listBatchs(int pagid,int total);
	public List<Object> listCourse();
	/*
	 * public void updatePerson(Person p); public Person getPersonById(int id);
	 * public void removePerson(int id);
	 */
}

