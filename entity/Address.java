package com.gr.quickrescue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address_tbl")
public class Address {

	private int id;
	private String lineOne;
	private String lineTwo;
	private String city;
	private String state;
	private String country;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String lineOne, String lineTwo, String city, String state, String country) {
		super();
		this.lineOne = lineOne;
		this.lineTwo = lineTwo;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	@Column (name= "get_line_one")
	public String getLineOne() {
		return lineOne;
	}

	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}
	
	@Column (name= "get_line_two")
	public String getLineTwo() {
		return lineTwo;
	}

	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}

	@Column (name= "get_city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Column (name= "get_state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Column (name= "get_country")
	public String getCountry() {
		return country;
		
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * primary key id auto-incremented
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column (name="address_id", unique=true, nullable=false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}