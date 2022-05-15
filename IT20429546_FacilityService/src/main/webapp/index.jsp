
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="org.electro_grid.model.Facility"%>



<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Facility Service Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.4.1.min.js"></script>
<script src="Components/Facility.js"></script>
</head>
<body>
<div class = "container">
<div class = "row">
<div class = "col">
	<h1>Facility Service Management</h1>
	
	<form id="formFacility" name="formFacility" method="post" action="index.jsp">
	
		 Service Name :
		 <input id="serviceName" name="serviceName" type="text"
 						class="form-control form-control-sm">
 						
		<br> Service Type:
		<input id="serviceType" name="serviceType" type="text"
 						class="form-control form-control-sm">
 						
		<br> Unit Cost:
		<input id="unitCost" name="unitCost" type="text"
 						class="form-control form-control-sm">
 										
		<br> Maximum Unit:
		<input id="maxUnit" name="maxUnit" type="text"
						 class="form-control form-control-sm">
						 
		<br> Additional Cost:
		<input id="addCost" name="addCost" type="text"
						 class="form-control form-control-sm">
						 
		<br>
		<input id="btnSave" name="btnSave" type="button" value="Save"
						 class="btn btn-primary">
						 
		<input type="hidden" id="hidServiceIDSave" name="hidServiceIDSave" value="">
	</form>
	
	<br/>
	<!-- Show output -->

	<div id= "alertSuccess" class="alert alert-success">
 	
 		
 	</div>
 	<div id = "alertError" class="alert-danger"></div>
	
	<br>
	<br>
	
	<div id ="divFacilityGrid">
	<%
	 Facility userObj = new Facility(); 
	 out.print(userObj.readFacility()); 
	%>
	</div>

</body>
</html> 