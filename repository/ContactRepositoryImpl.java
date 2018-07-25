package com.gr.quickrescue.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.gr.quickrescue.config.HibernateConfiguration;
import com.gr.quickrescue.entity.Contact;

public class ContactRepositoryImpl implements ContactRepository {

	HibernateConfiguration hb= new HibernateConfiguration();
	
	/**
	 * function to display all contacts
	 */
	@SuppressWarnings("deprecation")
	@Override
	public List<Contact> getAllContacts() {
		try {
			Session session= hb.getFactory().openSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Contact> list = session.createCriteria(Contact.class).list();
			
			session.getTransaction().commit();
			session.close();
			return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

	}

	/**
	 * function to add contact into contact_tbl
	 */
	@Override
	public boolean addContact(Contact contact) {
		try {
			Session session = hb.getFactory().openSession();
			session.beginTransaction();
			session.save(contact);
			session.getTransaction().commit();
			return true;
		}  catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}	
	}

	/**
	 * function to delete from contact_tbl using id
	 */
	@Override
	public boolean deleteContact(int id) {
		try {
			Contact contact= new Contact();
			contact.setId(id);
			Session session= hb.getFactory().openSession();
			session.beginTransaction();
			Contact ct = session.get(Contact.class, id);
			session.delete(ct);
			session.getTransaction().commit();
			session.close();
			return true;
			}
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	/**
	 * function to update the database entry using id and contact object
	 */
	@Override
	public boolean updateContact(int id, Contact contact) {
		try {
			Session session= hb.getFactory().openSession();
			session.beginTransaction();
			contact.setId(id);
			session.update(contact);
			session.getTransaction().commit();
			session.close();
			return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}

	}

}
