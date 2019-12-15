<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="resources/images/bg3.jpg">
	<h2 algin="center">Category Page</h2>
	
	<form action="<c:url value ='/UpdateCategory'/>"  method="post">
		<table align="center">
			<tr>
				<td colspan="2">CategoryInfo</td>
			</tr>
			<tr>
				<td>CategoryID</td>
				<td><input type="text" name="catId"
					value="${category.categoryId}" /></td>
			</tr>
			<tr>
				<td>CategoryName</td>
				<td><input type="text" name="catName"
					value="${category.categoryName}" /></td>
			</tr>
			<tr>
				<td>CategoryDesc</td>
				<td><input type="text" name="catDesc"
					value="${category.categoryDesc}" /></td>
			</tr>
				</center>
				
				
				<tr>
					<td colspan="2"></br><center>
							<input type="submit" value="Save Category" class="btn btn-success"> 
						</center>
						</td>
				</tr>
				
				</form>
		</table>


</body>
</html>