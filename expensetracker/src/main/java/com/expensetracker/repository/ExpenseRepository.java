package com.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensetracker.model.Expense;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
}
