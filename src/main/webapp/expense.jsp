<!DOCTYPE html>
<html>
<head>
<script type='text/javascript'
	src='http://code.jquery.com/jquery-1.10.1.js'></script>
<script type="text/javascript" src="expense.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script type='text/javascript'
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
</head>
<body>


	<section>

		<div class="container" style="padding-top: 30px">
			<h1 style="padding-bottom: 40px">Expense Summary</h1>

			<table id="mt" class="table table-hover">
				<thead>
					<tr>
						<th>Category</th>
						<th>Title</th>
						<th>Description</th>
						<th>Date</th>
						<th>Amount</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>

			<button onclick="addExpenseClick()">Add expense</button>

			<div id="message" style="margin-top: 30px"></div>
		<form style="padding-top: 30px">
			<input id="mailto" />
		</form>
		<button style="margin-top: 10px" onclick="sendMail()">Send mail</button>

		</div>


	</section>
</body>
</html>