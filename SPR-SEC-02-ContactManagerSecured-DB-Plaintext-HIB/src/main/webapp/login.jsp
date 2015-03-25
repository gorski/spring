<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head><title>Login page</title></head>
<body> 

<form action="j_spring_security_check" method="post">

    <c:if test="${not empty param.login_error}">
      <div style="color:red;">
        Podano nieprawidłowe hasło lub login, spróbuj ponownie.<br/>        
      </div>
 <% Object exception = session.getAttribute(org.springframework.security.web.WebAttributes.AUTHENTICATION_EXCEPTION);
      if (exception != null) {
    	  %><%=((Exception)exception).getMessage()%><%
      }
	%>
      <br/>
    </c:if>
  
	<label for="j_username">Username</label>
	<input type="text" name="j_username" id="j_username"/>
	<br/>
	<label for="j_password">Password</label>
	<input type="password" name="j_password" id="j_password"/>
	<br/>	
	<input type="submit" value="Login"/>
</form>
</body>
</html>
