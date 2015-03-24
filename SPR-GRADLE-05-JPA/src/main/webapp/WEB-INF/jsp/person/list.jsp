<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="spring.data.jpa.example.title"/></title>
</head>
<body>
<style type="text/css">
    table td { border: 1px solid #ddd; padding: 5px;}
    table .data {
         font-weight: bolder;
    }
</style>
<div class="messages">
    <c:if test="${feedbackMessage != null}">
        <div class="messageblock"><c:out value="${feedbackMessage}"/></div>
    </c:if>
    <c:if test="${errorMessage != null}">
        <div class="errorblock"><c:out value="${errorMessage}"/></div>
    </c:if>
</div>
<h1><spring:message code="person.list.page.title" /></h1>
<a href="<c:url value='/person/create' />"><spring:message code="person.create.link.label"/></a>
<table>
    <thead>
    <tr>
        <td><spring:message code="person.label.firstName"/></td>
        <td><spring:message code="person.label.lastName"/></td>
        <td colspan="2">Options</td>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${persons}" var="person">
        <tr>
            <td class="data"><c:out value="${person.firstName}"/></td>
            <td class="data"><c:out value="${person.lastName}"/></td>

            <td><a href="<c:url value='/person/edit/${person.id}'/>"><spring:message code="person.edit.link.label"/></a></td>
            <td><a href="<c:url value='/person/delete/${person.id}'/>"><spring:message code="person.delete.link.label"/></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h1>Search queries (returning JSON/XML)</h1>
<ul>
    <li>JPA Query: <b><a href="<c:url value='/person/searchQuery/Kowalski' />">/person/searchQuery/Kowalski</a></b></li>
    <li>JPA Named query: <b><a href="<c:url value='/person/searchNamedQuery/Kowalski' />">/person/searchQuery/Kowalski</a></b></li>
    <li>Criteria API: <b><a href="<c:url value='/person/searchCriteria/Kowalski' />">/person/searchCriteria/Kowalski</a></b></li>
</ul>


<h1>Other</h1>
<ul>
    <li>Bean list: <b><a href="<c:url value='/hello' />">/hello</a></b></li>
</ul>


</body>
</html>