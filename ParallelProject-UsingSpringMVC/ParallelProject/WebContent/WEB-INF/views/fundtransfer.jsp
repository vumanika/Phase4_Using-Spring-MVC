<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="fundtransfer1" method="get" modelAttribute="customer">  

<tr>
					<td>Enter Source MobileNumber:</td>
					<td><input name="sourcemobileNo" size="30" /></td>
		
				<tr>
					<td>Enter Destination MobileNumber:</td>
					<td><input name="desmobileNo" size="30" /></td>
					
				</tr>
				<tr>
					<td>Amount to Transfer:</td>
					<td><input name="balance" size="30" /></td>
			
				</tr>
<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</form:form>
</body>
</html>