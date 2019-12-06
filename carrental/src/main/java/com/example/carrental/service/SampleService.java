package com.example.carrental.service;

import com.example.carrental.model.Sample;
import com.example.carrental.repository.SampleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.QueueConnectionFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Service
@Transactional
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    public Sample save(Sample sample) {
try{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
			
			Queue queue = (Queue) applicationContext.getBean("queue");
			
			// Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html	
			QueueConnection connection = factory.createQueueConnection();
			
			// Open a session
			QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			
			// Start the connection
			connection.start();
			// Create a sender	
			QueueSender queueSender = session.createSender(queue);
			// Create a message
			Sample message = sampleRepository.saveAndFlush(sample);;
			TextMessage textMessage = session.createTextMessage();
			//textMessage.setText(message);
			// Send the message
			queueSender.send(textMessage);
			// Close the session			
			session.close();
			// Close the connection
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
    	
        return sampleRepository.saveAndFlush(sample);
    }

    public Optional<Sample> getOne(String PlateNumber){
        return sampleRepository.findByPlateNumber(PlateNumber);
    }
    public List<Sample> findAll(){
    	return sampleRepository.findAll();
    }
    
    
}
