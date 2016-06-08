package com.expensemanager.service;

import com.expensemanager.dao.expense.ExpenseDaoImpl;
import com.expensemanager.entities.Expense;
import com.expensemanager.utils.ExpansePageModel;

public class ExpenseService {

	public Expense findExpenseById(Long id) {
		ExpenseDaoImpl expenseDaoImpl = new ExpenseDaoImpl();
		expenseDaoImpl.beginTransaction();
		Expense expense = expenseDaoImpl.findById(id);
		expenseDaoImpl.close();
		return expense;
	}

	public String setExpense(Expense expense) throws Exception {
		ExpenseDaoImpl expenseDaoImpl = new ExpenseDaoImpl();
		expenseDaoImpl.beginTransaction();
		expenseDaoImpl.persist(expense);
		expenseDaoImpl.commitTransection();
		expenseDaoImpl.close();
		String expenseRes = expense.toString();
		return expenseRes;
	}

	public String deleteExpense(Long userId, Long expenseId) throws Exception {
		ExpenseDaoImpl expenseDaoImpl = new ExpenseDaoImpl();
		expenseDaoImpl.beginTransaction();
		expenseDaoImpl.deleteOrphanExpenses(userId, expenseId);
		expenseDaoImpl.commitTransection();
		expenseDaoImpl.close();
		return expenseId + "";
	}

	public ExpansePageModel findAllExpenses(int pageNumber, Long userId) throws Exception {
		ExpenseDaoImpl expenseDaoImpl = new ExpenseDaoImpl();
		expenseDaoImpl.beginTransaction();
		ExpansePageModel expansePageModel = expenseDaoImpl
				.findAllExpenses(pageNumber, userId);
		expenseDaoImpl.close();
		return expansePageModel;
	}

}
