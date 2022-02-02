<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
         import="com.angoor.securesociety.model.Dwelling" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
	   <meta charset="ISO-8859-1">
	   <% String pageTitle = "Add Dwelling";
	      Dwelling dwelling = (Dwelling)request.getAttribute("dwelling");
	      if(dwelling != null) {
	          pageTitle = "Edit Dwelling";
	      } %>
	   <title><%=pageTitle%></title>
	   <style type="text/css">
           .error {
               color: red;
           }
       </style>
	</head>
	<body>
	   <h1><%=pageTitle%></h1>
	   <form:form action="dwelling" method="post" modelAttribute="dwelling">
	       <table>
	           <tr>
	               <td>Dwelling Number</td>
	               <td>
	                   <form:input path="dwellingId" /> <br />
                       <form:errors path="dwellingId" cssClass="error" />
                   </td>
	           </tr>
	       </table>
	   </form:form>
	</body>
</html>