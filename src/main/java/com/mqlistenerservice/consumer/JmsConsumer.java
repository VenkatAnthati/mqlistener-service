package com.mqlistenerservice.consumer;

import javax.jms.Connection;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageConsumer;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;

import com.mqlistenerservice.dao.ProductDao;

@Configuration
@EnableJms
public class JmsConsumer {

	@Autowired
	ProductDao dao;
	
	@Value("${activemq-broker-url}")
	public String brokerURL;
	
	@Autowired
	ActiveMQConnectionFactory connectionFactory;
	
	
	
	/**This method used to receives data from destination queue and send to repository
	 * 
	 */
	@JmsListener(destination = "addProduct-queue")
	public void receivedmsg() {
		Connection conn = null;
        try {
        	//ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory(brokerURL);
        	 conn = connectionFactory.createConnection("consumer", "consumer");
        	 ActiveMQSession session = (ActiveMQSession) conn.createSession(false,
                     ActiveMQSession.INDIVIDUAL_ACKNOWLEDGE);
             ActiveMQMessageConsumer consumer = (ActiveMQMessageConsumer) session
                     .createConsumer(session.createQueue("addProduct-queue"));
             conn.start();
             ActiveMQTextMessage msg = null;
             while ((msg = (ActiveMQTextMessage) consumer.receive()) != null) {
                 System.out.println("JmsConsumer Received message is: " + msg.getText());
                // call productservice to save message in database.           
                 dao.save(msg.getText());
                 // Call your service and ack the message if successfully processed.
                 msg.acknowledge();
             }
        	 
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
}
}
