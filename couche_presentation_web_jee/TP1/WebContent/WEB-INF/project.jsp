<%@page import="fr.imie.CrowdFundingEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Boolean modeEdition = (Boolean) request.getAttribute("modeEdition");%>
<% CrowdFundingEntity project = (CrowdFundingEntity) request.getAttribute("project");%>
	<form method="POST">
		<%
			if (!modeEdition) {
		%>
		<h1><%=project.getName()%></h1>
		<h2><%=project.getGoal()%></h2>
		<div><%=project.getDescription()%></div>
		<%
			} else {
		%>
		<input name="idInput" type="hidden" value="<%=project.getId()%>" />
		<div>
			<label for="nameInput">nom</label><input id="nameInput"
				name="nameInput" type="text" value="<%=project.getName()%>" />
		</div>
		<div>
			<label for="goalInput">objectif</label><input id="goalInput"
				name="goalInput" type="text" value="<%=project.getGoal()%>" />
		</div>
		<div>
			<label for="descriptionInput">descritpion</label><input
				id="descriptionInput" name="descriptionInput" type="text"
				value="<%=project.getDescription()%>" />
		</div>
		<%
			}
		%>
		<div>
			<%
				if (!modeEdition) {
			%>
			<button name="editionAction">editer</button>
			<%
				} else {
			%>
			<button name="saveAction">sauvegarder</button>
			<%
				}
			%>

		</div>
	</form>

</body>
</html>