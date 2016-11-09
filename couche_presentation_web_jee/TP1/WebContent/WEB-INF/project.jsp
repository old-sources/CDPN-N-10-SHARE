<%@page import="fr.imie.CrowdFundingEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="fr.imie.labels" var="labelsProperties" />
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:message key="projectScreenTitle" bundle="${labelsProperties}" />

	<form method="POST">
		<c:choose>
			<c:when test="${! modeEdition}">
				<h1>
					<c:out value="${project.name}" />
				</h1>
				<h2>
					<c:out value="${project.goal}" />
				</h2>
				<div>
					<c:out value="${project.description}" />
				</div>
				<button name="editionAction"><fmt:message key="projectEditButton" bundle="${labelsProperties}" /></button>
			</c:when>
			<c:otherwise>
				<input name="idInput" type="hidden" value="${project.id}" />
				<div>
					<label for="nameInput"><fmt:message key="projectNameLabel" bundle="${labelsProperties}" /></label><input id="nameInput"
						name="nameInput" type="text" value="${project.name}" />
				</div>
				<div>
					<label for="goalInput"><fmt:message key="projectGoalLabel" bundle="${labelsProperties}" /></label><input id="goalInput"
						name="goalInput" type="text" value="${project.goal}" />
				</div>
				<div>
					<label for="descriptionInput"><fmt:message key="projectDescriptionLabel" bundle="${labelsProperties}" /></label><input
						id="descriptionInput" name="descriptionInput" type="text"
						value="${project.description}" />
				</div>
				<button name="saveAction"><fmt:message key="projectSaveButton" bundle="${labelsProperties}" /></button>
			</c:otherwise>
		</c:choose>
	</form>

</body>
</html>