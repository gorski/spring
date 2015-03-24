<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contacts</title>
</head>
<body>
<h1>Contacts</h1>
Hello: ${loggedUser}
<hr/>
<form:form method="post" action="contacts" commandName="contact">
    <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="lastName">Lastname</form:label></td>
        <td><form:input path="lastName" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add contact"/>
        </td>
    </tr>
</table>
</form:form>

<h1>Contacts</h1>
<table>
<c:forEach items="${contacts}" var="contact">
    <tr>
    	<td>[ ${contact.id} ]</td>
        <td>${contact.name}</td>
        <td>${contact.lastName}</td>
     
	 <sec:authorize ifAnyGranted="ROLE_ADMIN">
	    	<td><a href="<c:url value='contacts/remove/${contact.id}' />">Remove</a></td>       
     </sec:authorize>
     </tr>
</c:forEach>
</table>


</body>
</html>