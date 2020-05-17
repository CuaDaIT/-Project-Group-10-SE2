<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit the world statistic</title>
</head>
<body>
	<jsp:include page="ad-nav-bar.jsp"></jsp:include>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="update" method="post">
					<h3 class="text-center">UPDATE THE WOLRD STATISTIC</h3>
					<input type="hidden" name="id" value="<c:out value='${worldgeneral.id}' />" >

					<fieldset class="form-group">
						<label>Date</label> <input type="text"
							value="<c:out value='${worldgeneral.date}' />" class="form-control"
							name="date" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>New Confirmed</label> <input type="text"
							value="<c:out value='${worldgeneral.newConfirmed}' />" class="form-control"
							name="newConfirmed">
					</fieldset>

					<fieldset class="form-group">
						<label>Total Confirmed</label> <input type="text"
							value="<c:out value='${worldgeneral.totalConfirmed}' />" class="form-control"
							name="totalConfirmed">
					</fieldset>
					
					<fieldset class="form-group">
						<label>New Deaths</label> <input type="text"
							value="<c:out value='${worldgeneral.newDeaths}' />" class="form-control"
							name="newDeaths">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Total Deaths</label> <input type="text"
							value="<c:out value='${worldgeneral.totalDeaths}' />" class="form-control"
							name="totalDeaths">
					</fieldset>
					
					
					<fieldset class="form-group">
						<label>New Recovered</label> <input type="text"
							value="<c:out value='${worldgeneral.newRecovered}' />" class="form-control"
							name="newRecovered">
					</fieldset>
					
										
					<fieldset class="form-group">
						<label>Total Recovered</label> <input type="text"
							value="<c:out value='${worldgeneral.totalRecovered}' />" class="form-control"
							name="totalRecovered">
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