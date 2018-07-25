package com.gr.quickrescue.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gr.quickrescue.entity.Account;

public class AccountRepositoryImplTest {

	@BeforeClass
	public static void setup() {
		AccountRepository repo= new AccountRepositoryImpl();
		repo.setupDatabase();
	}
	@Test
	public void testGetAll() {
		AccountRepository repo= new AccountRepositoryImpl();
		assertNotNull(repo.getAll());
	}

	@Test
	public void testAdd() {
		AccountRepository repo = new AccountRepositoryImpl();
		Account account = generateAccount();
		assertTrue(repo.add(account));
		repo.delete(account.getId());
	}

	@Test
	public void testDelete() {
		Account account= generateAccount();
		account.setId(1);
		AccountRepository repo= new AccountRepositoryImpl();
		repo.add(account);
		assertTrue(repo.delete(account.getId()));		
	}

	@Test
	public void testUpdate() {
		AccountRepository repo= new AccountRepositoryImpl();
		Account account= generateAccount();
		repo.add(account);
		assertTrue(repo.update(account.getId(),account));
		repo.delete(account.getId());
	}
	
	private Account generateAccount() {
		return new Account("Usman", "usm@gmail.com", "Islamabad");
	}
	
	@AfterClass
	public static void cleanup() {
		AccountRepository repo = new AccountRepositoryImpl();
		repo.cleanupDatabase();
	}
}

