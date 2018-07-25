package com.gr.quickrescue.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gr.quickrescue.entity.Address;
import com.gr.quickrescue.entity.Contact;

public class HibernateConfiguration {

	private static SessionFactory sessionFactory;

	public HibernateConfiguration() {
		this.setupFactory();
	}

	public SessionFactory getFactory() {
		return sessionFactory;
	}

	/**
	 * Hibernate Configuration and setting up the sessionFactory
	 */
	public void setupFactory() {

		if (HibernateConfiguration.sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(Address.class); 
			cfg.addAnnotatedClass(Contact.class);
			cfg.configure("hibernate.cfg.xml");
			HibernateConfiguration.sessionFactory = cfg.buildSessionFactory();
		}
	}
}
