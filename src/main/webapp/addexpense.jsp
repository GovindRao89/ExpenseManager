<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="UTF-8">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="addexpense.js"></script>
</head>
<body>
	<section>
		<form style="padding-left: 100px; padding-top: 30px">
			<h1>Enter expense details</h1>
			<div>
				<label for="user">Category: </label> <input type="text"
					name="category" id="category" />
			</div>
			<br />
			<div>
				<label for="pass">Title: </label> <input type="text"
					name="title" id="title" />
			</div>
			<br />
			<div>
				<label for="pass">Description: </label> <input type="text"
					name="description" id="description" />
			</div>
			<br />
			<div>
				<label for="pass">Date: </label> <input type="date"
					name="date" id="date" />
			</div>
			<br />
			<div>
				<label for="pass">Amount: </label> <input type="number"
					name="amount" id="amount" />
			</div>
			<br />
			<div>
				<input type="button" value="Add Expense" onclick="addExpenseToDB()" />
			</div>
		</form>
		<br />
		<div id="message"></div>
	</section>
</body>
</html>