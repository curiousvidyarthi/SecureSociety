<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
         import="com.angoor.securesociety.model.Dwelling" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	   <meta charset="ISO-8859-1">
	   <title>Dwellings List</title>
	   <style type="text/css">
	       div{
               width: 100%;
           }
           button{
               padding: 6px 8px 4px 8px;
           }
	   </style>
	</head>
	<body>
	   <div>
	       <h2 style="display: inline;">Dwellings</h2>
	       <button style="float: right;" onclick="">Add Dwelling</button>
	   </div>
	   <!-- % Iterable<Dwelling> dwellingsList = (Iterable<Dwelling>)request.getAttribute("dwellingsList"); %-->
	   <core:choose>
	       <core:when test="${not empty dwellingsList}">
		       <ul>
		          <core:forEach var="dwelling" items="${dwellingsList}">
		              <li>Id: ${dwelling.id}, Dwelling Number: ${dwelling.dwellingNumber}, Door Number: ${dwelling.doorNumber}, Block: ${dwelling.block}, FloorNumber: ${dwelling.floorNumber}, Area: ${dwelling.area}, UDS: ${dwelling.uds}, Dwelling Type: ${dwelling.dwellingTypeId}</li>
		          </core:forEach>
	            </ul>
            </core:when>
            <core:otherwise>No dwellings found</core:otherwise>
	   </core:choose>
	</body>
</html>