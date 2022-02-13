package com.demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
	//SessionFactory
	StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
												.configure("hibernate.cfg.xml").build();
	SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
	
	//Session
	Session session = factory.openSession();
	
	//Session session  = factory.getCurrentSession();
	//start the transaction
	Transaction tx=session.getTransaction();
	try {
		tx.begin();
		//create and save customer
		tx.commit();
	}catch(HibernateException ex) {
		ex.printStackTrace();
		tx.rollback();
	}
	
	//commit the transaction
	
	//error-> roll-back
	
	//session close
	
	//session-factory close
}
