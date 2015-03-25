<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>Spring 3.x MVC - Contact Manager</title>
</head>
<body>

<%-- this disiplays logged user info --%>
<h2>Hello ${loggedUser}. Welcome in Contact Manager</h2>

<sec:authorize ifAnyGranted="ROLE_ADMIN">
    <h2 style="color:green">yey, i'm an admin</h2>
</sec:authorize>
 
<form:form method="post" action="add.html" commandName="contact">
 
    <table>
    <tr>
        <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
        <td><form:input path="firstname" /></td>
    </tr>
    <tr>
        <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
        <td><form:input path="lastname" /></td>
    </tr>
    <tr>
        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td><form:label path="phone"><spring:message code="label.phone"/></form:label></td>
        <td><form:input path="phone" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.addcontact"/>"/>
        </td>
    </tr>
</table>
</form:form>
 
<h3>Contacts</h3>
<c:if  test="${!empty contactList}">
<table class="data">
<tr>
    <th>Name</th>
    <th>Email</th>
    <th>Phone</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${contactList}" var="contact">
    <tr>
        <td>${contact.lastname}, ${contact.firstname} </td>
        <td>${contact.email}</td>
        <td>${contact.phone}</td>
        <sec:authorize ifAnyGranted="ROLE_ADMIN">
			<td><a href="delete/${contact.id}">delete</a></td> 
		</sec:authorize>
        
    </tr>
</c:forEach>
</table>
</c:if>

  <br/>

  <%-- This makes all the link context-relative --%>
  <a href="<spring:url value="/logout" htmlEscape="true" />">Logout</a>
  <br/>

</body>
</html>