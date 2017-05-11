package com.yuen.domain.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Item> items;

	public Cart() {
        items = new ArrayList<>();
    }
	
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public int getCount() {
		return items.size();
	}
	
	public int getTotal() {
		int total = 0;
		for (Item e : items) {
			total += e.getSubTotal();
		}
		return total;
	}
	
}