function register() {
	item = {};
	var jsonData = $('form').serializeArray();
	jsonData.forEach(function(data) {
		if (data.name == "username") {
			item["username"] = data.value;
		} else if (data.name == "password") {
			item["password"] = data.value;
		} else if (data.name == "passwordConfirm") {
			item["passwordConfirm"] = data.value;
		}
	});
	var requiredJson = JSON.stringify(item);
	$.ajax({
		beforeSend : function(xhrObj) {
			xhrObj.setRequestHeader("Content-Type", "application/json");
		},
		type : "POST",
		url : 'webapi/user/registration',
		data : requiredJson,
		dataType : 'json',
		success : function(data) {
			// console.log(data);
			$("#message").html("Registered successfully");
			alert("User registered successfully");
			window.location.href = "login.jsp";
		},
		error : function(err) {
			console.log("AJAX error : " + JSON.stringify(err, null, 2));
		}
	});
	return false;
}


function alreadyRegistered() {
	window.location.href = "login.jsp";
}