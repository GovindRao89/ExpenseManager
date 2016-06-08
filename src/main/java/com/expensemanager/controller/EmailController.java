package com.expensemanager.controller;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.expensemanager.entities.Expense;
import com.expensemanager.entities.User;
import com.expensemanager.service.ExpenseService;
import com.expensemanager.utils.ExpansePageModel;

@Path("email")
public class EmailController {

	@Context
	HttpServletRequest request;

	@POST
	@Path("/sendmail")
	@Consumes("application/x-www-form-urlencoded")
	public Response sendSSLMessage(@FormParam("recipients") String recipients) throws Exception {
		boolean debug = true;

		final String SMTP_HOST_NAME = "smtp.gmail.com";
		final String SMTP_PORT = "465";
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		final String from = "govindrao90@gmail.com";
		final String subject = "Expense Summary";

		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");

		class GMailAuthenticator extends Authenticator {
			String user;
			String pw;

			public GMailAuthenticator(String username, String password) {
				super();
				this.user = username;
				this.pw = password;
			}

			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pw);
			}
		}

		Session session = Session.getInstance(props, new GMailAuthenticator(
				"yourgmailid@gmail.com", "yourgmailpassword"));
		session.setDebug(debug);

		Message msg = new MimeMessage(session);
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);

		System.out.println("rECIPENT" + recipients);
		InternetAddress addressTo = new InternetAddress(recipients);
		msg.setRecipient(Message.RecipientType.TO, addressTo);

		// Setting the Subject and Content Type
		msg.setSubject(subject);

		HttpSession httpSession = request.getSession(true);
		User user = (User) httpSession.getAttribute("user");

		ExpenseService expenseService = new ExpenseService();

		ExpansePageModel expansePageModel = expenseService.findAllExpenses(1, user.getId());
		List<Expense> expenses = expansePageModel.getListPersons();
		
		StringBuffer stringBuffer = new StringBuffer();

		for (Expense expense : expenses) {
			stringBuffer.append("Title :");
			stringBuffer.append(expense.getTitle());
			stringBuffer.append("\n");
			
			stringBuffer.append("Category :");
			stringBuffer.append(expense.getCategory());
			stringBuffer.append("\n");
			
			stringBuffer.append("Description :");
			stringBuffer.append(expense.getDescription());
			stringBuffer.append("\n");
			
			stringBuffer.append("Amount :");
			stringBuffer.append(expense.getAmount());
			stringBuffer.append("\n");
		}
		
		msg.setContent(stringBuffer.toString(), "text/plain");
		Transport.send(msg);
		return Response.status(Response.Status.OK).build();
	}
}
