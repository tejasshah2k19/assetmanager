<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AssetManager | ForgetPassword </title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet" href="mystyle.css">
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form action="forgetpassword" method="post">
					
					<div class="form-group">
						Email: <input type="text" name="email" class="form-control"/>
					</div>
					
					 
	 
	 			<input type="submit" value="Help!!" class="btn btn-success"/>
				</form>
				<span class="error">${error }</span>
				<br><br><a href="login">Login?</a>
					|
					<a href="signup">New User?</a>
					
			</div>   
			<div class="col-md-3"></div>

		</div>


	</div>
</body>
</html>