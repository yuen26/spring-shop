package com.yuen.domain.web;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	@NotEmpty
	@Length(max = 100)
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotEmpty
	@Length(max = 1000)
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "image", nullable = true)
	private String image;
	
	@NotNull // with Integer cannot use @NotEmpty 
	@Max(value = 1000000)
	@Min(value = 10000)
	@Column(name = "price", nullable = false)
	private Integer price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id", referencedColumnName = "id")
	@JsonBackReference
	private Category category;
	
	@OneToMany(mappedBy = "pk.product", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Item> items = new HashSet<>();
	
	public Product() {
		super();
		this.image = null;
	}
	
	public Product(String name, String description, int price, String image, Category category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Set<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}