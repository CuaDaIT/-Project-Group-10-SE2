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
		<h3 class="text-center">Each Day in VietNam Statistic</h3>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Date</th>
					<th>Cases</th>
					<th>Recovered Patient</th>
					<th>Deaths</th>
				</tr>
			</thead>
			<tbody>
				<%-- c:forEach => basic iteration tag --%>
				<c:forEach var="EachDay" items="${listEachDay}">
					<tr>
						<%-- c:out => for expressions --%>
						<td><c:out value="${EachDay.date}" /></td>
						<td><c:out value="${EachDay.cases}" /></td>
						<td><c:out value="${EachDay.recovered}" /></td>
						<td><c:out value="${EachDay.deaths}" /></td>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    	google.charts.load('current', { 'packages': ['corechart'] });
    	google.charts.setOnLoadCallback(drawChart);
		let datee = [];
		let casess = [];
		let recoveredd = [];
		let deathss = [];
		
		<c:forEach var="EachDay" items="${listEachDay}">
			datee.push("${EachDay.date}");
			casess.push(parseInt("${EachDay.cases}"));
			recoveredd.push(parseInt("${EachDay.recovered}"));
			deathss.push(parseInt("${EachDay.deaths}"));
		</c:forEach>

		for(let i = 0; i < datee.length; i++){
		    let temp = datee[i].substring(0, 10);
		    datee[i] = temp;
		}
		
		let dataa = new Array(['Date', 'Cases', 'Recovered Patient', 'Deaths']);
	    for(let i = 0; i < datee.length;i++){
		    dataa.push([datee[i], (casess[i]), (recoveredd[i]), (deathss[i])]);
	    }
	    function drawChart() {
	      var data = google.visualization.arrayToDataTable(dataa);
	      
	      var options = {
	        title: 'Vietnam Trend Overall',
	        curveType: 'function',
	        legend: { position: 'bottom' },
	        vAxis:{viewWindow: {min: 0, max: 500}},
	        
	      };
	
	      var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
	
	      chart.draw(data, options);
	    }
    </script>
    <div id="curve_chart" style="width: 100%; height: 500px; margin-bottom: 64px;"></div>
</body>