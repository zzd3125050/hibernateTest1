<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>  
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>    
		<title>test.jsp</title>
		<meta name="pragma" content="no-cache">
		<meta name="cache-control" content="no-cache">
		<meta name="expires" content="-1">
	</head>
	
	

	<body>
		<form action='<c:url value="/cust" />' method="post">
			name<input type="text" name="custName"/><br/>
			level<input type="text" name="custLevel"/><br/>
			source<input type="text" name="custSource"/><br/>
			phone<input type="text" name="custPhone"/><br/>
			mobile<input type="text" name="custMobile"/><br/>
			<input type="submit" value="提交" />
		</form>
	</body>
</html>
