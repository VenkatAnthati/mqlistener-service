package com.mqlistenerservice.dao;

import org.springframework.stereotype.Service;

@Service
public interface ProductDao {

	/** 
	 * this method id used to save data into database
	 * @param productJson this is String parameter
	 */
	void save(String prodjson);
}
