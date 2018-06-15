<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>  
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>    
		<title>form.jsp</title>
		<meta name="pragma" content="no-cache">
		<meta name="cache-control" content="no-cache">
		<meta name="expires" content="-1">
	</head>

	<body>
		<form action='<c:url value="/ognl1"/>' method="post">
			<input type="text" name="username"/><br/>
			<input type="text" name="password"/><br/>
			<input type="text" name="address"/><br/>
			<input type="submit" value="提交"/>
		</form>
	</body>
</html>
