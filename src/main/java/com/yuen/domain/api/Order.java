package com.yuen.domain.api;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String phone;
	private String address;
	private String note;
	private List<Item> items;
	private User user;
	
	public Order() {
		super();
	}

	public Order(String name, String phone, String address, String note, List<Item> items, User user) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.note = note;
		this.items = items;
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
