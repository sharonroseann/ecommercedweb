<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value="/UpdateProduct"/>" method="post">
<table align="center" class="table">
<tr>
    <td colspan="2">
    <center><h3>EDIT Product</h3></center>
    </td>
</tr>
<tr>
    <td>Product ID</td>
    <td><input type="text" name="productID" value="${product.productid}" readonly/></td>
</tr>
<tr>
    <td>Product Name</td>
    <td><input type="text" name="productName" value="${product.productName}"  /></td>
</tr>
<tr>
    <td>Product Desc</td>
    <td><input type="text" name="productDesc" value="${product.productDesc}"  /></td>
</tr>   
<tr>
    <td>Product Price</td>
    <td><input type="text" name="price" value="${product.price}"  /></td>
</tr>
<tr>
    <td>Product Stock</td>
    <td><input type="text" name="stock" value="${product.stock}"  /></td>
</tr>

<tr>
    <td>Product's CategoryID</td>
    <td><input type="text" name="categoryID" value="${product.categoryId}"  /></td>
</tr>
<tr>
    <td>Product's SupplierID</td>
    <td><input type="text" name="supplierID" value="${product.supplierId}"  /></td>
</tr>
<tr>
    <td colspan=2 align="center"><input type="submit" value="Update Product"/></td>
</tr>    



</table>
</form>


</body>
</html>