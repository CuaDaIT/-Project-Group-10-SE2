<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Include the JSTL Core library in JSP --%>
<jsp:include page="user-nav-bar.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Covid-19</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<br>
		<h3 class="text-center">VietNam Provinces Statistic</h3>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Province</th>
					<th>Confirmed Patient</th>
					<th>Under Treatment Patient</th>
					<th>Recovered Patient</th>
					<th>Deaths</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<%-- c:forEach => basic iteration tag --%>
				<c:forEach var="VietNamProvince" items="${listProvinces}">
					<tr>
						<%-- c:out => for expressions --%>
						<td><c:out value="${VietNamProvince.name}" /></td>
						<td><c:out value="${VietNamProvince.confirmed}" /></td>
						<td><c:out value="${VietNamProvince.underTreatment}" /></td>
						<td><c:out value="${VietNamProvince.recovered}" /></td>
						<td><c:out value="${VietNamProvince.deaths}" /></td>
						<td><c:out value="${VietNamProvince.date}" /></td>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
	    google.charts.load("current", { packages: ["corechart"] });
	    google.charts.setOnLoadCallback(drawChart);
	    
	    let provinces = [];
	    let patients = [];
	    
	    <c:forEach var="VietNamProvince" items="${listProvinces}">
	    	provinces.push("${VietNamProvince.name}");
			patients.push(parseInt("${VietNamProvince.confirmed}"));
		</c:forEach>
		
		let dataa = new Array(['Province', 'Patients']);
	    for(let i = 0; i < provinces.length;i++){
		    dataa.push([provinces[i], patients[i]]);
	    }
	    function drawChart() {
	      var data = google.visualization.arrayToDataTable(dataa);
	
	      var options = {
	        legend: 'none',
	        pieSliceText: 'label',
	        title: 'Patients In Provice In Vietnam',
	        pieStartAngle: 100,
	
	      };
	
	      var chart = new google.visualization.PieChart(document.getElementById('piechart'));
	      chart.draw(data, options);
	    }
    </script>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
</body>