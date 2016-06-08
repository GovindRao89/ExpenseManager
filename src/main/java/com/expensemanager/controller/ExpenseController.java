package com.expensemanager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.expensemanager.entities.Expense;
import com.expensemanager.entities.User;
import com.expensemanager.service.ExpenseService;

@Path("expense")
public class ExpenseController {

	@Context 
	HttpServletRequest request;
	
	@POST
	@Path("/addexpense")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addExpense(Expense expense) {
		ExpenseService expenseService = new ExpenseService();
		try {
			HttpSession session= request.getSession(true);
	    	User user = (User) session.getAttribute("user");
	    	expense.setUser(user);
	    	
			expenseService.setExpense(expense);
		} catch (Exception exception) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}

		return Response.ok().build();
	}
	
	@DELETE
	@Path("/delete/{expenseId}")
	public Response deleteExpense(@PathParam("expenseId") Long expenseId) {
		try {
			HttpSession session= request.getSession(true);
	    	User user = (User) session.getAttribute("user");
	    	
			ExpenseService expenseService = new ExpenseService();
			expenseService.deleteExpense(user.getId(), expenseId);
		} catch (Exception exception) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
		return Response.ok().build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getexpense/{pageNo}")
	public Response getAllExpenses(@PathParam("pageNo") Integer pageNo) {
		try {
			HttpSession session= request.getSession(true);
	    	User user = (User) session.getAttribute("user");
	    	
			ExpenseService expenseService = new ExpenseService();
			return Response.status(Response.Status.OK)
					.entity(expenseService.findAllExpenses(pageNo, user.getId())).build();
		} catch (Exception exception) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
}
