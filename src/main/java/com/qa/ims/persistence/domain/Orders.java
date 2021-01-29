//package com.qa.ims.persistence.domain;
//
//import java.util.ArrayList;
//
//import java.util.List;
//
//public class Orders {
//	
//	private Long o_id;
//	private Customer customer;
//	private double price;
//	private List<Items> itemi_id = new ArrayList<>();
//	
//	
//	public Orders(Customer customer, double price) {
//		super();
//		this.customer = customer;
//		this.price = price;
//	}
//	
//
//	public Orders(Long o_id, Customer customer, double price, List<Items> itemi_id) {
//		super();
//		this.o_id = o_id;
//		this.customer = customer;
//		this.price= price;
//		this.itemi_id = itemi_id;
//		
//	}
//	
//	public Orders(Long o_id, Customer customer, double price) {
//		super();
//		this.o_id = o_id;
//		this.customer = customer;
//		this.price = price;
//		
//		
//	}
//
//	
//	public Orders(Long orderId,Customer customer) {
//		super();
//		this.o_id = orderId;
//		this.customer = customer;
//		
//	}
//
//
//	public Long geto_id() {
//		return o_id;
//	}
//
//	public void seto_id(Long o_id) {
//		this.o_id = o_id;
//	}
//
//	
//
//	public double getprice() {
//		return price;
//	}
//
//	public void setprice(double price) {
//		this.price = price;
//	}
//
//	
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//
//	public List<Items> getitemi_id() {
//		return itemi_id;
//	}
//
//
//	public void setOrderItems(List<Items> itemi_id) {
//		this.itemi_id =itemi_id;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Orders [o_id=" + o_id + ", customer=" + customer + ", price=" + price + ", i_id="
//				+ itemi_id + "]";
//	}
//
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
//		result = prime * result + ((o_id == null) ? 0 : o_id.hashCode());
//		result = prime * result + ((itemi_id == null) ? 0 : itemi_id.hashCode());
//		long temp;
//		temp = Double.doubleToLongBits(price);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		return result;
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Orders other = (Orders) obj;
//		if (customer == null) {
//			if (other.customer != null)
//				return false;
//		} else if (!customer.equals(other.customer))
//			return false;
//		if (o_id == null) {
//			if (other.o_id != null)
//				return false;
//		} else if (!o_id.equals(other.o_id))
//			return false;
//		if (itemi_id == null) {
//			if (other.itemi_id != null)
//				return false;
//		} else if (!itemi_id.equals(other.itemi_id))
//			return false;
//		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
//			return false;
//		return true;
//	}
//
//
//}