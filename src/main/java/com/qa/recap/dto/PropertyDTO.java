package com.qa.recap.dto;

import com.qa.recap.domain.Property;
import com.qa.recap.domain.Status;
import com.qa.recap.domain.Type;

public class PropertyDTO {

	private Integer id;

	private String address;

	private String postcode;

	private Type type;

	private Integer price;
	private Integer baths;

	private Integer beds;

	private Boolean garden;

	private Status status;

	private String seller;

	public PropertyDTO(Property property) {
		super();
		this.id = property.getId();
		this.address = property.getAddress();
		this.postcode = property.getPostcode();
		this.type = property.getType();
		this.price = property.getPrice();
		this.baths = property.getBaths();
		this.beds = property.getBeds();
		this.garden = property.getGarden();
		this.status = property.getStatus();
		if (property.getSeller() != null) {
			this.seller = property.getSeller().getFirstName() + " " + property.getSeller().getLastName();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getBaths() {
		return baths;
	}

	public void setBaths(Integer baths) {
		this.baths = baths;
	}

	public Integer getBeds() {
		return beds;
	}

	public void setBeds(Integer beds) {
		this.beds = beds;
	}

	public Boolean getGarden() {
		return garden;
	}

	public void setGarden(Boolean garden) {
		this.garden = garden;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

}
