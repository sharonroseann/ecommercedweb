<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
    <div class="row">
       
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                    
                </div>

    <div class="col-xs-6 col-sm-6 col-md-6 text-right">
     <p>
                        <em>Date: <%=new java.util.Date() %> </em>
                    </p>
                    <p>
                        <em>OrderId:GADGKIN_00145${OrderDetail.orderId} </em>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="text-center">
                    <h1>Receipt</h1>
                </div>
             
       


   
   <table class="table table-hover">
	
		 <thead>
                        <tr>
		
			
			<th>Product Name</th>
			<th>Quantity</th>
			<th class="text-center">Price</th>
			<th class="text-center">Total Price</th>
			
		</tr>
 </thead>
  <tbody>
		<c:forEach items="${listCart}" var="cart">
	<form action="<c:url value="/updateCart/${cart.cartId}"/>" method="get">

				<tr>
				
				
					<td>${cart.productName}</td>
					<td>${cart.quantity}</td>
					<td>${cart.price}</td>
					<td>${cart.quantity * cart.price}/-</td>
					
		</tr>
		</form>

		</c:forEach>


		<tr>
		<td>  </td>
		<td>  </td>
			<td class="text-right"><h4><strong>Grand Total Price</strong></h4></td>
			<td class="text-center text-danger"><h4><strong>RS.${grandTotal}/-</strong></h4></td>
		</tr>
		</tbody>
		
 </table> 
 </div>
 </div>     
</body>
</html>
</html>
