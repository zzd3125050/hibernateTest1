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
			name<input type="text" name="name"/><br/>
			level<input type="text" name="level"/><br/>
			source<input type="text" name="source"/><br/>
			phone<input type="text" name="phone"/><br/>
			mobile<input type="text" name="mobile"/><br/>
			cCcc<input type="text" name="cC"/><br/>
			<input type="submit" value="提交" />
		</form>
	</body>
</html>
