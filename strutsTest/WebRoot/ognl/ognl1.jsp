<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>    
		<title>ognl1.jsp</title>
		<meta name="pragma" content="no-cache">
		<meta name="cache-control" content="no-cache">
		<meta name="expires" content="-1">
	</head>

	<body>
		EL表达式取值：<br/>
		<c:forEach items="${users }" var="user">
			${user.username }<br/>
			${user.password }<br/>
			${user.address }<br/>
		</c:forEach>
		struts2标签取值:<br/>
		<s:iterator value="users">
			<s:property value="username"/><br/>
			<s:property value="password"/><br/>
			<s:property value="address"/><br/>
		</s:iterator>
	</body>
</html>
