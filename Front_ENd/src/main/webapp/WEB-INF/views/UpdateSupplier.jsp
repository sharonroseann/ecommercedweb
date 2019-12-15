<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ Taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="resources/images/bg6.jpg">
	<h2 algin="center">Supplier Page</h2>
	
	<form action="<c:url value ='/UpdateSupplier'/>"  method="post">
		<table align="center">
			<tr>
				<td colspan="2">SupplierInfo</td>
			</tr>
			<tr>
				<td>SupplierID</td>
				<td><input type="text" name="supId"
					value="${supplier.supplierId}" /></td>
			</tr>
			<tr>
				<td>SupplierName</td>
				<td><input type="text" name="supName"
					value="${supplier.supplierName}" /></td>
			</tr>
			<tr>
				<td>SupplierDesc</td>
				<td><input type="text" name="supDesc"
					value="${supplier.supplierDesc}" /></td>
			</tr>

			<tr>
					<td colspan="2"></br><center>
							<input type="submit" value="Save Supplier" />
						</center>
						</td>
				</tr>
				</center>
				</form>
		</table>



</body>
</html>