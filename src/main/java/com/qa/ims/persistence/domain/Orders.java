package com.qa.ims.persistence.domain;
import java.util.ArrayList;
import java.util.List;

public class Orders {

	private Long o_id;
	private Double Price;
	private Customer customer;
	private List <Items> orderItems = new ArrayList<>();

	public Orders(Long o_id, Double price, Customer customer, List<Items> orderItems) {
		super();
		this.o_id = o_id;
		Price = price;
		this.customer = customer;
		this.orderItems = orderItems;
	}
	
	public Orders(Long o_id, Double price, Customer customer) {
		super();
		this.o_id = o_id;
		Price = price;
		this.customer = customer;
	}

	public Orders(Customer customer, Double price) {
		super();
		Price = price;
		this.customer = customer;
	}

	public Long geto_id() {
		return o_id;
	}

	public void seto_id(Long o_id) {
		this.o_id = o_id;
	}
	
	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Items> getItems(){
		return orderItems;
	}
	
	public void setItems (List<Items> orderitems) {
		this.orderItems = orderitems;
	}
	

	@Override
	public String toString() {
		return "o_id:" + o_id + " Price:" + Price + " customer:" + customer;
	}

//	@Override
//	public String toString() {
//		StringBuilder Orders = new StringBuilder();
//		Orders.append(
//				String.format("%s: %s %s %s ", this.o_id, this.order_date, ordercustomer.getFirstName(), ordercustomer.getSurname()));
//		if (this.orderItems.isEmpty()) {
//			Orders.append( "\n -> Cannot find any items in this order");
//				} else {
//					this.orderItems.forEach(item -> {
//						Orders.append("\n ->");
//						Orders.append(String.format("%s %s", item.getFirstName(), itemcustomer.getSurname()));
//						
//					});
//						
//					}
//					return order_date.toString();
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Price == null) ? 0 : Price.hashCode());
		result = prime * result + ((o_id == null) ? 0 : o_id.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		
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
		Orders other = (Orders) obj;
		if (getPrice() == null) {
			if (other.getPrice() != null)
				return false;
		} else if (!getPrice().equals(other.getPrice()))
			return false;
		if (o_id == null) {
			if (other.o_id != null)
				return false;
		} else if (!o_id.equals(other.o_id))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		return true;
	}

}
