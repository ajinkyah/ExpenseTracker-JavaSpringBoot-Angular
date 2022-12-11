package com.expensetracker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Setter
@Getter

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String Email;
	
	private String Username;
	
	private String Password;
	
	private long Budget;

	public long getBudget() {
		return Budget;
	}

	public void setBudget(long budget) {
		Budget = budget;
	}
	
	@OneToMany(mappedBy = "user1",cascade = CascadeType.ALL)
	//@JoinColumn(name = "ex_fk", referencedColumnName = "id")
	@JsonIgnore
	private List<Expense> expense = new ArrayList();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public List<Expense> getExpense() {
		return expense;
	}

	public void setExpense(List<Expense> expense) {
		this.expense = expense;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Email=" + Email + ", Username=" + Username + ", Password=" + Password + ", Budget="
				+ Budget + ", expense=" + expense + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
