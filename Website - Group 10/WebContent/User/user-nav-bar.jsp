<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Covid-19</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
<style>
body {
  overflow-x: hidden;
}

#sidebar-wrapper {
  min-height: 100vh;
  margin-left: -15rem;
  -webkit-transition: margin .25s ease-out;
  -moz-transition: margin .25s ease-out;
  -o-transition: margin .25s ease-out;
  transition: margin .25s ease-out;
}

#sidebar-wrapper .sidebar-heading {
  padding: 0.875rem 1.25rem;
  font-size: 1.2rem;
}

#sidebar-wrapper .list-group {
  width: 15rem;
}

#page-content-wrapper {
  min-width: 100vw;
}

#wrapper.toggled #sidebar-wrapper {
  margin-left: 0;
}

@media (min-width: 768px) {
  #sidebar-wrapper {
    margin-left: 0;
  }

  #page-content-wrapper {
    min-width: 0;
    width: 100%;
  }

  #wrapper.toggled #sidebar-wrapper {
    margin-left: -15rem;
  }
}
</style>
</head>

<body>
  <div class="d-flex" id="wrapper">
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading">COVID-19 Analysis</div>
      <div class="list-group list-group-flush">
        <a href="<%=request.getContextPath()%>/user" class="list-group-item list-group-item-action bg-light">Home page</a>
        <a href="<%=request.getContextPath()%>/user/world" class="list-group-item list-group-item-action bg-light">The World Statistic</a>
        <a href="<%=request.getContextPath()%>/user" class="list-group-item list-group-item-action bg-light">The Countries Statistic</a>
        <a href="<%=request.getContextPath()%>/user/province" class="list-group-item list-group-item-action bg-light">Vietnam's Provinces</a>
        <a href="<%=request.getContextPath()%>/user/eachday" class="list-group-item list-group-item-action bg-light">Each Day in VietNam</a>
      </div>
    </div>
    
 <div id="page-content-wrapper">
  <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
            <li class="nav-item">
              <a class="nav-link" href="<%=request.getContextPath()%>/login">Admin Login</a>
            </li>
           </ul>
    </div>
  </nav>
</body>
</html>