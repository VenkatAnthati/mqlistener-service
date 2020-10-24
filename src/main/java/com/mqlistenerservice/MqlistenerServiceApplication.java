package com.mqlistenerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mqlistenerservice.consumer.JmsConsumer;

@SpringBootApplication
public class MqlistenerServiceApplication implements CommandLineRunner{
	
	@Autowired
	JmsConsumer consumer;
	
	public static void main(String[] args) {
		SpringApplication.run(MqlistenerServiceApplication.class, args);
	}

	
	@Override
    public void run(String... args) throws Exception {
		consumer.receivedmsg();
    }
}
