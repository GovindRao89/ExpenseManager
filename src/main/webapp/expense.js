$(window).load(function() {
	$(function() {
		var data = getExpenseList();
	});
});

function displayExpenseSummery(data) {
	var totalExpense = 0;
	var tr;

	var monthNames = [ "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" ];

	for (var i = 0; i < data.listPersons.length; i++) {
		tr = $('<tr/>');
		tr.append("<td>" + data.listPersons[i].category + "</td>");
		tr.append("<td>" + data.listPersons[i].title + "</td>");
		tr.append("<td>" + data.listPersons[i].description + "</td>");
		var date = new Date(data.listPersons[i].date);
		var day = date.getDate();
		var monthIndex = date.getMonth();
		var year = date.getFullYear();
		tr.append("<td>" + day + ' ' + monthNames[monthIndex] + ' ' + year
				+ "</td>");
		tr.append("<td>" + data.listPersons[i].amount + "</td>");
		$("#mt > tbody").append(tr);

		totalExpense = totalExpense + data.listPersons[i].amount;
	}
	localStorage.setItem("expense_data", data);
	$("#message").html("Total Expenditure: " + totalExpense);
}

function sendExpenseMail() {
	var email = "recipients=" + $('#mailto')[0].value;

	$.ajax({
		beforeSend : function(xhrObj) {
			xhrObj.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
		},
		type : "POST",
		url : 'webapi/email/sendmail',
		data : email,
		processData : false,
		contentType : false,
		success : function(data) {
			alert("Your message was sent successfully.");
		},
		error : function(err) {
			console.log("AJAX error : " + JSON.stringify(err, null, 2));
		}
	});
}

function getExpenseList() {
	$.ajax({
		'url' : 'webapi/expense/getexpense/1',
		'type' : 'GET',
		'success' : function(data) {
			displayExpenseSummery(data);

		}
	});
}

function addExpenseClick() {
	window.location.href = "addexpense.jsp";
}

function sendMail() {
	var data = sendExpenseMail();
}