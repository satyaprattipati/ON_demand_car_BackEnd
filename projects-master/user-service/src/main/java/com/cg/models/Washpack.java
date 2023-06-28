
package com.cg.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="washpackdb")
public class Washpack {
	
	@Id
	private Integer id;
	private String packname;
	private Integer Cost;
	private String description;

	
	public Washpack() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCost() {
		return Cost;
	}
	public void setCost(Integer cost) {
		Cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPackname() {
		return packname;
	}
	public void setPackname(String packname) {
		this.packname = packname;
	}
	@Override
	public String toString() {
		return "Washpack [id=" + id + ", packname=" + packname + ", Cost=" + Cost + ", description=" + description
				+ "]";
	}
	

}
