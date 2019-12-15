<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
 .navbar-header {
 padding-top: 0;
 padding-bottom: 0;
 height: 35px;
 }
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="topnav">
      <a class="navbar-brand"  href="#"><b>GADGET_KING</b></a>
    </div>

<c:if test="${!sessionScope.loggedIn}">
         <ul class="nav navbar-nav">
         
    <li><a href="login"><b>Login</b></a></li>
  <li><a href="register"><b>Register</b></a></li>
  
   <li><a href="AboutUs"><b>AboutUs</b></a></li>
  <li><a href="ContactUs"><b>ContactUs</b></a></li>
     </ul>
</c:if>
<c:if test="${sessionScope.loggedIn}">
   <c:if test="${sessionScope.role=='admin'}">
   <ul class="nav navbar-nav">
      <li>
<a href="category">Category</a></li>
   
   <li>
   <li>
<a href="supplier">Supplier</a></li>
   
   <li>
<a href="product">Product</a></li>
    </ul>
  
</c:if>
<c:if test="${sessionScope.role=='user'}">

 <ul class="nav navbar-nav">
      <li>
<a href="<c:url value="/productdisplay"/>">Product Catalog</a></li>
    <li>
<a href="<c:url value="/cart"/>">Cart</a></li>
   </ul>
   
</c:if>
<ul class="nav navbar-nav navbar-right">
   <li>
<a href="<c:url value="/perform_logout"/>">Logout</a></li>
</ul>

</c:if>
</div>
</nav>

</body>
</html>