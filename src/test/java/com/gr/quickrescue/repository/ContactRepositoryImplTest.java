package com.gr.quickrescue.repository;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gr.quickrescue.entity.Contact;
import com.gr.quickrescue.entity.Address;

public class ContactRepositoryImplTest { 

	@Test
	public void testGetAllContacts() {
		ContactRepository repo= new ContactRepositoryImpl();
		
		assertNotNull(repo.getAllContacts());	}

	@Test
	public void testAddContact() {
		ContactRepository repo = new ContactRepositoryImpl();
		Contact contact= generateContact();
		assertTrue(repo.addContact(contact));
		repo.deleteContact(contact.getId());
	}


	@Test
	public void testDeleteContact() {
		Contact contact= generateContact();
		contact.setId(1);
		ContactRepository repo= new ContactRepositoryImpl();
		repo.addContact(contact);
		assertTrue(repo.deleteContact(contact.getId()));		
	}

	@Test
	public void testUpdateContact() {
		ContactRepository repo= new ContactRepositoryImpl();
		Contact contact= generateContact();
		repo.addContact(contact);
		assertTrue(repo.updateContact(contact.getId(),contact));
		repo.deleteContact(contact.getId());
	}
	
	
	private Contact generateContact() {
		Address address= new Address("Street 9","House 178","Rawalpindi","Punjab","Pakistan");
		Contact contact=new Contact("Zeeshan","Sohail","zeeshan@gmail.com",
				"male", "03085778891","active",address
				);
		
		return contact;
	}

}
