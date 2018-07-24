<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Account Details</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Name</th><th>MobileNumber</th><th>Balance</th></tr>  
   
   <tr>  
   <td>${customer.name}</td>  
   <td>${customer.mobileNo}</td>  
   <td>${customer.wallet.balance}</td> 
   </tr>  
 
   </table>  
   <br/>  
   <a href=""><input type="submit" value="Go To Home Page" /></a>
  
</body>
</html>