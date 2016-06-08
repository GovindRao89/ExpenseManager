package com.expensemanager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.expensemanager.entities.User;
import com.expensemanager.service.UserService;
import com.expensemanager.utils.UserValidator;

@Path("user")
public class UserController {

	@Context
	HttpServletRequest request;

	@POST
	@Path("/registration")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUser(User user) {

		UserValidator userValidator = new UserValidator();
		UserService userService = new UserService();
		String errorMessage = userValidator.validate(user).getMessage();

		try {
			if (userValidator.checkIFUserClass(user.getClass()) && errorMessage != null) {
				return Response.status(Response.Status.UNAUTHORIZED)
						.entity(errorMessage).build();
			}
			userService.setUser(user);
		} catch (Exception exception) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
		return Response.status(Response.Status.OK).entity(user.getId()).build();
	}

	@POST
	@Path("/authentication")
	@Consumes("application/x-www-form-urlencoded")
	public Response authenticateUser(@FormParam("username") String username,
			@FormParam("password") String password) {

		UserService userService = new UserService();
		User user = null;
		try {
			user = userService.getUserWRTUserName(username);
		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}

		if (user != null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			return Response.ok().build();
		}
		return Response.status(Response.Status.UNAUTHORIZED).build();
	}
}
