<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<%@ page isELIgnored="false"%>

<style>
.error {
	color: #000080;
	font-style: italic;
}
</style>
<!-- <link href="../../css/addition.css" rel="stylesheet"> -->
<%-- 	<spring:url value="/resources/css/addition.css" var="mainCss" /> --%>
<%-- 		<link href="${mainCss}" rel="stylesheet" /> --%>
<%-- <link href="<c:url value="/resources/css/addition.css" />" rel="stylesheet"> --%>
<%-- <script src="<c:url value="/resources/js/add.js"/>"></script> --%>
</head>
<body>
	<h1>Welcome</h1>
	<form:form action="/SpringWithMaven/add" method="post" modelAttribute="addtionEntity">
		<table>
			<tr>
				<td>Value One :</td>
				<td><form:input path="valueOne" placeholder=""/></td>
<%-- 						value="${addtionEntity.valueOne}"  /></td>--%>
						
				<td><form:errors path="valueOne" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Value Two :</td>
				<td><form:input path="valueTwo" placeholder=""	value="${addtionEntity.valueTwo}" /></td>
				<td><form:errors path="valueTwo" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Result :</td>
				<td><form:input path="result" placeholder="" value="${addtionEntity.result}"/></td>
				<td><form:errors path="result" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>
</body>