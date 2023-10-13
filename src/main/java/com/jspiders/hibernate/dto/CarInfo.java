package com.jspiders.hibernate.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="car_info")
public class CarInfo {
	@Id
//	@GeneratedValue
	@Column(name="c_id")
	private int c_id;
	@Column(name="c_name")
	private String c_name;
	@Column(name="model")
	private String model;
	@Column(name="Brand")
	private String Brand;
	@Column(name="fuel")
	private String fuel;
	@Column(name="price")
	private double price;
}