package com.expensemanager.utils;

import java.io.Serializable;
import java.util.List;

import com.expensemanager.entities.Expense;

public class ExpansePageModel implements Serializable {
	
	private static final long serialVersionUID = -4237077187525968670L;
	
	private int pageNumber;
	private int pageSize;
	private List<Expense> listPersons;
	private long totalPageCount;

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Expense> getListPersons() {
		return listPersons;
	}

	public void setListPersons(List<Expense> listPersons) {
		this.listPersons = listPersons;
	}

	public long getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(long pageCount) {
		this.totalPageCount = pageCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExpansePageModel [pageNumber=");
		builder.append(pageNumber);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", listPersons=");
		builder.append(listPersons);
		builder.append(", pageCount=");
		builder.append(totalPageCount);
		builder.append("]");
		return builder.toString();
	}
}
