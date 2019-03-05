package com.objectified.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.objectified.dto.Batch;

public interface BatchService {

	public void addBatch(Batch p);
	public List<Object> listBatchs(int pageid,int total);
	public List<Object> listCourse();
	/*public void updatePerson(Person p);
	
	public Person getPersonById(int id);
	public void removePerson(int id);
	*/
}