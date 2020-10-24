package com.mqlistenerservice.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mqlistenerservice.model.Product;
import com.mqlistenerservice.repositoy.ProductRepository;

@Component
public class ProductDaoImpl implements ProductDao {

	@Autowired
	ProductRepository repository;

	/**
	 * this method id used to save data into database
	 * 
	 * @param productJson this is String parameter
	 */
	@Override
	@Transactional
	public void save(String productJson) {
		ObjectMapper objjectMapper = new ObjectMapper();
		Product product = null;
		try {
			product = objjectMapper.readValue(productJson, Product.class);
			// System.out.println(productJson);
			repository.save(product);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
