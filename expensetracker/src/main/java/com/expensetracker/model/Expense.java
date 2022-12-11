package com.expensetracker.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="expenses")
@Setter
@Getter
public class Expense {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String category;
	
	@Column
	private String category_details;
	
	@Column
	private BigDecimal amount;
	
	@Column
	private String place;
	
	@Column
	private String shop;
	
	@Column
	private String date;
	
	@ManyToOne
	@JoinColumn(name = "uid")
	private User user1;

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory_details() {
		return category_details;
	}

	public void setCategory_details(String category_details) {
		this.category_details = category_details;
	}

	
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", category=" + category + ", category_details=" + category_details + ", amount="
				+ amount + ", place=" + place + ", shop=" + shop + ", date=" + date + ", user1=" + user1 + "]";
	}

	
	
	
}
