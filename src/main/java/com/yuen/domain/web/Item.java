package com.yuen.domain.web;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "item")
@AssociationOverrides({
	@AssociationOverride(
		name = "pk.order",
		joinColumns = @JoinColumn(name = "order_id")),
	@AssociationOverride(
		name = "pk.product",
		joinColumns = @JoinColumn(name = "product_id")),
})
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PK pk = new PK();
	
	@Embeddable
	private static class PK implements Serializable {

		private static final long serialVersionUID = 1L;
			
		@ManyToOne(fetch = FetchType.LAZY)
		private Order order;
		
		@ManyToOne(fetch = FetchType.LAZY)
		private Product product;

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((order == null) ? 0 : order.hashCode());
			result = prime * result + ((product == null) ? 0 : product.hashCode());
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
			PK other = (PK) obj;
			if (order == null) {
				if (other.order != null)
					return false;
			} else if (!order.equals(other.order))
				return false;
			if (product == null) {
				if (other.product != null)
					return false;
			} else if (!product.equals(other.product))
				return false;
			return true;
		}
		
	}
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Column(name = "price", nullable = false)
	private int price;
	
	public Item() {
		
	}
	
	@Transient
	public Order getOrder() {
		return pk.getOrder();
	}
	
	public void setOrder(Order order) {
		pk.setOrder(order);
	}
	
	@Transient
	public Product getProduct() {
		return pk.getProduct();
	}

	public void setProduct(Product product) {
		pk.setProduct(product);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	public int getSubTotal() {
		return pk.getProduct().getPrice() * quantity;
	}

}