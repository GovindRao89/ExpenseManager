function login() {
	var data = $('form').serialize();
	$.ajax({
		beforeSend : function(xhrObj) {
			xhrObj.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
		},
		type : "POST",
		url : 'webapi/user/authentication',
		data : data,
		processData : false,
		contentType : false,
		success : function(data) {
			// console.log(data);
			$("#message").html("User logged in successfully");
			alert("User logged in successfully");
			window.location.href = "expense.jsp";
		},
		error : function(err) {
			console.log("AJAX error : " + JSON.stringify(err, null, 2));
		}
	});
	return false;
}