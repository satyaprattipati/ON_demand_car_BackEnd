//package com.cg.models;
//
//import javax.validation.constraints.NotEmpty;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Transient;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection = "orderdetailsdb")
//public class OrderDetails 
//{
//	@Id
//	@NotEmpty(message = "Order Id must not be empty")
//	private int orderId;
//	@NotEmpty(message = "carName must not be empty")
//	private String carName;
//	@NotEmpty(message = "car model must not be empty")
//	private String carModel;
//	@NotEmpty(message = "UserName must not be empty")
//	private String username;
//	@NotEmpty(message = "date must not be empty")
//	private String date;
//	@NotEmpty(message = "contact must not be empty")
//	private Long contactno;
//	@NotEmpty(message = "address must not be empty")
//	private String address;
//	@NotEmpty(message = "washpackId must not be empty")
//	private int washpackId;
//
//	
//	
//
//	public int getWashpackId() {
//		return washpackId;
//	}
//
//
//	public void setWashpackId(int washpackId) {
//		this.washpackId = washpackId;
//	}
//
//
//	@Transient
//    public static final String SEQUENCE_NAME = "users_sequence";
//	
//
//	public OrderDetails() {
//		super();
//	}
//
//
//	public OrderDetails(@NotEmpty(message = "Order Id must not be empty") int orderId,
//			@NotEmpty(message = "carName must not be empty") String carName,
//			@NotEmpty(message = "car model must not be empty") String carModel,
//			@NotEmpty(message = "UserName must not be empty") String username,
//			@NotEmpty(message = "date must not be empty") String date,
//			@NotEmpty(message = "contact must not be empty") Long contactno,
//			@NotEmpty(message = "address must not be empty") String address,
//			@NotEmpty(message = "washpackId must not be empty") int washpackId) {
//		super();
//		this.orderId = orderId;
//		this.carName = carName;
//		this.carModel = carModel;
//		this.username = username;
//		this.date = date;
//		this.contactno = contactno;
//		this.address = address;
//		this.washpackId = washpackId;
//	}
//
//
//	public int getOrderId() {
//		return orderId;
//	}
//
//
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
//
//
//	public String getCarName() {
//		return carName;
//	}
//
//
//	public void setCarName(String carName) {
//		this.carName = carName;
//	}
//
//
//	public String getCarModel() {
//		return carModel;
//	}
//
//
//	public void setCarModel(String carModel) {
//		this.carModel = carModel;
//	}
//
//
//	public String getUsername() {
//		return username;
//	}
//
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//
//	public String getDate() {
//		return date;
//	}
//
//
//	public void setDate(String date) {
//		this.date = date;
//	}
//
//
//	public Long getContactno() {
//		return contactno;
//	}
//
//
//	public void setContactno(Long contactno) {
//		this.contactno = contactno;
//	}
//
//
//	public String getAddress() {
//		return address;
//	}
//
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//
//	public static String getSequenceName() {
//		return SEQUENCE_NAME;
//	}
//
//
//	@Override
//	public String toString() {
//		return "OrderDetails [orderId=" + orderId + ", carName=" + carName + ", carModel=" + carModel + ", username="
//				+ username + ", date=" + date + ", contactno=" + contactno + ", address=" + address + ", washpackId="
//				+ washpackId + "]";
//	}
//
//}









package com.cg.models;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orderdetailsdb")
public class OrderDetails 
{
	@Id
	@NotEmpty(message = "Order Id must not be empty")
	private int orderId;
	@NotEmpty(message = "carName must not be empty")
	private String carName;
	@NotEmpty(message = "vehicleType must not be empty")
	private String vehicleType;
	@NotEmpty(message = "UserName must not be empty")
	private String username;
	@NotEmpty(message = "date must not be empty")
	private String date;
	@NotEmpty(message = "contact must not be empty")
	private Long contactno;
	@NotEmpty(message = "address must not be empty")
	private String address;
	@NotEmpty(message = "washpackId must not be empty")
	private int washpackId;

	
	

	public int getWashpackId() {
		return washpackId;
	}


	public void setWashpackId(int washpackId) {
		this.washpackId = washpackId;
	}


	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	

	public OrderDetails() {
		super();
	}


	public OrderDetails(@NotEmpty(message = "Order Id must not be empty") int orderId,
			@NotEmpty(message = "carName must not be empty") String carName,
			@NotEmpty(message = "vehicleType must not be empty") String vehicleType,
			@NotEmpty(message = "UserName must not be empty") String username,
			@NotEmpty(message = "date must not be empty") String date,
			@NotEmpty(message = "contact must not be empty") Long contactno,
			@NotEmpty(message = "address must not be empty") String address,
			@NotEmpty(message = "washpackId must not be empty") int washpackId) {
		super();
		this.orderId = orderId;
		this.carName = carName;
		this.vehicleType = vehicleType;
		this.username = username;
		this.date = date;
		this.contactno = contactno;
		this.address = address;
		this.washpackId = washpackId;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getCarName() {
		return carName;
	}


	public void setCarName(String carName) {
		this.carName = carName;
	}


	


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public Long getContactno() {
		return contactno;
	}


	public void setContactno(Long contactno) {
		this.contactno = contactno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}


	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", carName=" + carName + ", vehicleType=" + vehicleType + ", username="
				+ username + ", date=" + date + ", contactno=" + contactno + ", address=" + address + ", washpackId="
				+ washpackId + "]";
	}


	

}

