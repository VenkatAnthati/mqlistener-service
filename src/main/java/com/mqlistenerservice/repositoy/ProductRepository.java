package com.mqlistenerservice.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mqlistenerservice.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
