<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="UTF-8">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="login.js"></script>
</head>
<body>
	<section>
		<form style="padding-left: 100px; padding-top: 30px">
			<h1>Login Form</h1>
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
				<input type="button" value="Login" onclick="login()" />
			</div>
		</form>
		<br />
		<div id="message"></div>
	</section>
</body>
</html>