<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>  
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>    
		<title>form2.jsp</title>
		<meta name="pragma" content="no-cache">
		<meta name="cache-control" content="no-cache">
		<meta name="expires" content="-1">
	</head>

	<body>
		<form action='<c:url value="/form2"></c:url>' method="post">
			用户名：<input type="text" name="username"/><br/>
			密码：<input type="text" name="password"/><br/>
			地址：<input type="text" name="address"/><br/>
			<input type="text" name="cMobile"/><br/>
			<input type="text" name="cLevel"/><br/>
			<input type="submit" value="提交"/>
		</form>
	</body>
</html>
