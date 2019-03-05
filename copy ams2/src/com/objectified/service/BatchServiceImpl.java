package com.objectified.service;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;


import com.objectified.dao.BatchDao;
import com.objectified.dao.BatchDaoImpl;
import com.objectified.dto.Batch;

@Service("batchservice")
public class BatchServiceImpl implements BatchService {
	@Autowired
	private BatchDao batchdao;


	@Override
	@Transactional
	public void addBatch(Batch batch) {
		this.batchdao.addBatch(batch);
	}

	@Override
	@Transactional
	public List<Object> listBatchs(int pageid, int total) {
		return this.batchdao.listBatchs(pageid, total);
	}

	@Override
	@Transactional
	public List<Object> listCourse() {
		return this.batchdao.listCourse();
	}

}
