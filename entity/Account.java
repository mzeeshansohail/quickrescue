package com.gr.quickrescue.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "accounts_tbl")
public class Account {
	private int id;
	private String name;
	private String email;
	private String city;
	private List<Contact> contacts;
	
	public Account() {
	}

	public Account(String name, String email, String city) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
	}
	
	
	/**
	 * Primary key auto-incremented
	 * @return
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="account_id", unique=true, nullable=false)
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	@Column (name="Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column (name="Email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column (name= "City")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@OneToMany(mappedBy= "account")
	public List<Contact> getContacts(){
		return this.contacts;
	}
	
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
}