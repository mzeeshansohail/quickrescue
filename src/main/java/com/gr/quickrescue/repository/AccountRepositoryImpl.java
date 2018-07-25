package com.gr.quickrescue.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.gr.quickrescue.config.HibernateConfiguration;
import com.gr.quickrescue.entity.Account;

public class AccountRepositoryImpl implements AccountRepository {

	HibernateConfiguration hb= new HibernateConfiguration();
	
	@Override
	public void setupDatabase() {
		// TODO Auto-generated method stub
		try {
			Session session = hb.getFactory().openSession();
			session.beginTransaction();
			Account account = new Account("Zeeshan Sohail","zeeshansohail@gmail.com","Rawalpindi");
			Account account1 = new Account("Usman", "usm@gmail.com", "Rawalpindi");
			session.save(account);
			session.save(account1);	
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {			
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Function to display all contacts
	 */

	public List<Account> getAll() {
		try {
		Session session = hb.getFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Account> list = session.createCriteria(Account.class).list();
		session.getTransaction().commit();
		session.close();
		return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * function to add into account_tbl
	 */
	public boolean add(Account account) {
		try {
			Session session = hb.getFactory().openSession();
			session.beginTransaction();
			session.save(account);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * function to delete from database table using id
	 */
	public boolean delete(int id) {
		try {
		Session session = hb.getFactory().openSession();
		Account account= new Account();
		account.setId(id);
		session.beginTransaction();
		session.delete(account);
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
	 * function to update using id and account
	 */
	public boolean update(int id, Account account) {
		try {
		Session session = hb.getFactory().openSession();
		session.beginTransaction();
		account.setId(id);
		session.update(account);
		session.getTransaction().commit();
		session.close();
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void cleanupDatabase() {
		// TODO Auto-generated method stub
		try {
			Session session = hb.getFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("truncate table account");
			q.executeUpdate();
			session.getTransaction().commit();
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
