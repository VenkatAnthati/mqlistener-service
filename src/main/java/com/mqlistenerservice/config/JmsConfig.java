package com.mqlistenerservice.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@Configuration
public class JmsConfig {

	@Value("${activemq-broker-url}")
	public String brokerURL;

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("addProduct-queue");
	}
	/*
	 * @Bean // Serialize message content to json using TextMessage public
	 * org.springframework.jms.support.converter.MessageConverter
	 * jacksonJmsMessageConverter() {
	 * org.springframework.jms.support.converter.MappingJackson2MessageConverter
	 * converter = new
	 * org.springframework.jms.support.converter.MappingJackson2MessageConverter();
	 * converter.setTargetType(MessageType.TEXT);
	 * converter.setTypeIdPropertyName("_type"); return converter; }
	 */

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);
		//connectionFactory.setBrokerURL(brokerURL);
		// connectionFactory.setTrustedPackages(Arrays.asList("org.api","java.util"));
		return connectionFactory;
	}

	/*
	 * Used for Receiving Message
	 * 
	 * @Bean public JmsListenerContainerFactory<?> jsaFactory(ConnectionFactory
	 * connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
	 * DefaultJmsListenerContainerFactory factory = new
	 * DefaultJmsListenerContainerFactory();
	 * factory.setMessageConverter(jacksonJmsMessageConverter());
	 * configurer.configure(factory, connectionFactory); return factory; }
	 */

}
