<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AssetManager | Signup</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form action="saveuser" method="post">

					<div class="form-group">
						FirstName: <input type="text" name="firstName" class="form-control" />
					</div>
					
					
					<div class="form-group">
						LastName: <input type="text" name="lastName" class="form-control" />
					</div>
					
					
					<div class="form-group">
						Email: <input type="text" name="email" class="form-control"/>
					</div>
					
					
					<div class="form-group">
						Password: <input type="password" name="password" class="form-control"/>
					</div>
					
					
	 
	 			<input type="submit" value="Signup" class="btn btn-success"/>
				</form>
			</div>
			<div class="col-md-3"></div>

		</div>


	</div>
</body>
</html>