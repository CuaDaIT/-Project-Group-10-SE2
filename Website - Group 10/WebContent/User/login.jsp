<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
<style>
    .col-centered{
    float: none;
    margin: 0 auto;
}
</style>
</head>
<body>
  <body style="background-color: #4b5257">
  <div class="container">
  <div class="col-xs-12 col-sm-8 col-md-4 col-lg-4 col-centered">
  <div class="jumbotron">
        <h3>Please login</h3>
        <form action="Dashboard.jsp">
          <div class="form-group">
            <input type="email" class="form-control" placeholder="Enter Username">
          </div>
          <div class="form-group">
            <input type="password" class="form-control" placeholder="Enter password">
          </div>
          <div class="custom-checkbox">
            <label><input type="checkbox"> Remember me</label>
          </div>
          <button type="submit" class="btn-primary form-control">Login</button>
        </form>
      </div>
  </div>
  </div>
</body>
</html>