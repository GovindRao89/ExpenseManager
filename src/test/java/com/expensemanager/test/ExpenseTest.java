package com.expensemanager.test;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import com.expensemanager.entities.Expense;
import com.expensemanager.service.ExpenseService;
import com.expensemanager.utils.ExpansePageModel;

public class ExpenseTest {

	@Test
	public void testExpenseById() throws Exception {
		ExpenseService expenseService = new ExpenseService();
		Expense expense = expenseService.findExpenseById(12l);
		System.out.println(expense.getId());
		assertEquals(new Long(12l), expense.getId());
	}

	@Test
	public void testSetExpense() throws Exception {
		ExpenseService expenseService = new ExpenseService();
		Expense expense = new Expense();
		expense.setTitle("Title1");
		expense.setCategory("Category1");
		expense.setDescription("Description1");
		expense.setDate(new Date());
		expense.setAmount(4000.00);
		String string = expenseService.setExpense(expense);
		assertEquals(expense.toString(), string);
	}
	
	@Test
	public void testDeleteExpense() throws Exception {
		ExpenseService expenseService = new ExpenseService();
		String expId = expenseService.deleteExpense(20l, 12l);
		assertEquals(12l, Long.parseLong(expId));
	}
	
	@Test
	public void testFindAllExpense() throws Exception {
		ExpenseService expenseService = new ExpenseService();
		ExpansePageModel expansePageModel = expenseService.findAllExpenses(1, 20l);
		assertNotNull(expansePageModel.getListPersons());
	}
}
