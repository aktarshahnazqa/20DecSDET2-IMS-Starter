package com.qa.ims.persistence.domain;

public class Items {

	private Long id;
	private String item_name;
	private Double price;
	private String genre;

	public Items(Long id, String item_name, Double price, String genre) {
		this.seti_id(id);
		this.setitem_name(item_name);
		this.setprice(price);
		this.setgenre(genre);
	}


	public Items( String item_name, Double price, String genre) {
		this.setitem_name(item_name);
		this.setprice(price);
		this.setgenre(genre);
	}

	public Long getid() {
		return id;
	}

	public void seti_id(Long id ) {
		this.id = id;
	}

	public String getitem_name() {
		return item_name;
	}

	public void setitem_name(String item_name) {
		this.item_name = item_name;
	}

	public Double getPrice() {
		return price;
	}

	public void setprice(Double price) {
		this.price = price;
	}

	public String getgenre() {
		return genre;
	}

	public void setgenre(String genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return "id:" + id + " item_name:" + item_name + " Price:" + price + "genre:" + genre;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
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
		Items other = (Items) obj;
		if (getitem_name() == null) {
			if (other.getitem_name() != null)
				return false;
		} else if (!getitem_name().equals(other.getitem_name()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		return true;
	}

}
