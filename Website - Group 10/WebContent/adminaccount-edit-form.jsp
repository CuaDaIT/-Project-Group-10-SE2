<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="nav-bar.jsp"></jsp:include>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="update" method="post">
					<h3 class="text-center">UPDATE ADMIN ACCOUNT</h3>
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" >

					<fieldset class="form-group">
						<label>Username</label> <input type="text"
							value="<c:out value='${user.username}' />" class="form-control"
							name="name" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Pass</label> <input type="text"
							value="<c:out value='${user.address}' />" class="form-control"
							name="address">
					</fieldset>

					<fieldset class="form-group">
						<label>Mobile</label> <input type="text"
							value="<c:out value='${user.mobile}' />" class="form-control"
							name="mobile">
					</fieldset>
					<div class="col text-center">
						<button type="submit" class="btn btn-success">UPDATE</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>