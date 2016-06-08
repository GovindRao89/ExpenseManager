<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="UTF-8">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="register.js"></script>
</head>
<body>
	<section>

		<form style="padding-left: 100px; padding-top: 30px">
			<h1>Registration Form</h1>
			<div>
				<label for="user">Username: </label> <input type="text"
					name="username" id="username" />
			</div>
			<br />
			<div>
				<label for="pass">Password: </label> <input type="password"
					name="password" id="password" />
			</div>
			<br />
			<div>
				<label for="pass">Confirm Password: </label> <input type="password"
					name="passwordConfirm" id="passwordConfirm" />
			</div>
			<br />
			<div>
				<input type="button" value="Register" onclick="register()" />
			</div>
			<br />
			<div>
				<input type="button" value="Aleary registered" onclick="alreadyRegistered()" />
			</div>
		</form>
		<br />
		<div id="message"></div>
	</section>
</body>
</html>