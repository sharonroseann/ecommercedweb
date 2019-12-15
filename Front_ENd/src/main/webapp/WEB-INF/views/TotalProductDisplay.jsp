<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br/><br/>
<form action="<c:url value="/addToCart/${product.productid}"/>" method="get">
  
<table class="table-bordered">
<tr>
    <td rowspan="7">
  
   <img src ='<c:url value='/resources/images/${product.productid}.jpg'></c:url>' height="70" width="70" alt="Generic placeholder thumbnal"> 
    
    
    </td>
    <td>Product ID</td>
    <td>${product.productid}</td>
</tr>
<tr>
    <td>Product Name</td>
    <td>${product.productName}</td>
</tr>
<tr>
    <td>Description</td>
    <td>${product.productDesc}</td>
</tr>
<tr>
    <td>Price</td>
    <td>INR.${product.price}</td>
</tr>
<tr>
    <td>Stock</td>
    <td>${product.stock}</td>
</tr>
<tr>
    <td>Category ID</td>
    <td>${product.categoryId}</td>
</tr>
<tr>
    <td>Supplier ID</td>
    <td>${product.supplierId}</td>
</tr>

<tr>
    <td>
        Quantity
        <select name="quantity">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
         </select>
       </td>
   <td><input type="submit" value="Add To Cart" class="btn btn-warning"/></td>
 </tr>  


</table>
</form>

</body>
</html>