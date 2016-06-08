package com.expensemanager.dao.expense;

import java.util.Iterator;
import java.util.List;
import com.expensemanager.dao.DaoImpl;
import com.expensemanager.entities.Expense;
import com.expensemanager.entities.User;
import com.expensemanager.utils.ExpansePageModel;

public class ExpenseDaoImpl extends DaoImpl<Long, Expense> implements
		ExpenseDao {

	public ExpansePageModel findAllExpenses(int pageNumber, Long userId) {
		User user = (User) entityManager
				.createQuery(
						"select u from User u join fetch u.expenses where u.id = :id")
				.setParameter("id", userId).getSingleResult();
		
		final int pageSize = 10;
		List<Expense> listPersons = user.getExpenses();
		int pageCount = listPersons.size();
		ExpansePageModel expansePageModel = new ExpansePageModel();
		expansePageModel.setPageNumber(pageNumber);
		expansePageModel.setPageSize(pageSize);
		expansePageModel.setTotalPageCount((int) pageCount / pageSize + 1);
		expansePageModel.setListPersons(listPersons);
		return expansePageModel;
	}

	public void deleteOrphanExpenses(Long userId, Long expenseId) {
		User user = (User) entityManager
				.createQuery(
						"select u from User u join fetch u.expenses where u.id = :id")
				.setParameter("id", userId).getSingleResult();

		for (Iterator<Expense> iterator = user.getExpenses().iterator(); iterator
				.hasNext();) {
			Expense expense = iterator.next();
			if (expense.getId().equals(expenseId)) {
				user.removeExpenses(expense);
				break;
			}
		}
	}
}