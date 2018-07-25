package com.gr.quickrescue.repository;

import java.util.List;

import com.gr.quickrescue.entity.Account;

public interface AccountRepository {

	List<Account> getAll();
	boolean add(Account account);
	boolean delete(int id);
	boolean update(int id,Account account);
	void setupDatabase();
	void cleanupDatabase();
	
}
