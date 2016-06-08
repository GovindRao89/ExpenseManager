function addExpenseToDB() {
	item = {};
	var jsonData = $('form').serializeArray();
	jsonData.forEach(function(data) {
		if (data.name == "title") {
			item["title"] = data.value;
		} else if (data.name == "category") {
			item["category"] = data.value;
		} else if (data.name == "description") {
			item["description"] = data.value;
		} else if (data.name == "date") {
			var ms = new Date(data.value).getTime();
			item["date"] = ms;
		} else if (data.name == "amount") {
			item["amount"] = data.value;
		}
	});
	
	var requiredJson = JSON.stringify(item);
	$.ajax({
		beforeSend : function(xhrObj) {
			xhrObj.setRequestHeader("Content-Type", "application/json");
		},
		type : "POST",
		url : 'webapi/expense/addexpense',
		data : requiredJson,
		dataType : 'json',
		success : function(data) {
			// console.log(data);		
			alert("Expense added successfully");
			window.location.href = "expense.jsp";
		},
		error : function(err) {
			console.log("AJAX error : " + JSON.stringify(err, null, 2));
		}
	});
	return false;
}