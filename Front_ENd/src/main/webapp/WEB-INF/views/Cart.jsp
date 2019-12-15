<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body background="resources/images/bg3.jpg">


 <section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Your Order</h1>
     </div>
</section> 
<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">

       <thead>
                        <tr>
                          

    
                           <th scope="col">SL #</th>
                           <th scope="col">Product Name</th>
                           <th scope="col">Quantity</th>
                            <th scope="col">Price</th>
                             <th scope="col">Total Price</th>
                              <th scope="col">Operation</th>
          </tr>
       </thead>
      <tbody>
      <c:forEach items="${listCart}" var="cart" varStatus="loop">
      <form action="<c:url value="/updateCart/${cart.cartId}"/>" method="get">
     
     <tr>
      
     <td>${loop.count}.</td>

        <td>${cart.productName}</td>
        <td><input type="text" value="${cart.quantity}" name="quantity"/></td>
        <td>${cart.price}</td>
        <td>${cart.quantity * cart.price}/-</td>
        <td>
            <input type="submit" value="Update" class="btn btn-success"/>
            <a class="btn btn-danger" href="<c:url value="/deleteCart/${cart.cartId}"/>">Delete</a>
        </td>
        </tr>
        </form>
        </c:forEach>
        
        <tr>
           <td><strong>Grand Total Price</strong></td>
           <td class="text-right"><strong>${grandTotal}/-</strong></td>
          </tr>
          </tbody>
          </table>
          </div>
          </div>
      
        <div class="col mb-2">
            <div class="row">
           <div class="col-sm-12  col-md-6"><a href="<c:url value="/productdisplay"/>">Continue Shopping</a></div>
			 <div class="col-sm-12 col-md-6 text-right"><a href="<c:url value="/orderConfirm"/>">Checkout</a></div>
			 
     </div>
   </div>
     </div>
   </div>
  </div>   

</body>
</html>