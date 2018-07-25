package com.gr.quickrescue.repository;

import java.util.List;

import com.gr.quickrescue.entity.Contact;

public interface ContactRepository {
	List <Contact> getAllContacts();
	boolean addContact(Contact contact);
	boolean deleteContact(int id);
	boolean updateContact(int id, Contact contact);
}
