<%@page import="fr.imie.CrowdFundingEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste de Projet</title>
</head>
<body>
	<table>
		<%
			List<CrowdFundingEntity> projectList = (List<CrowdFundingEntity>) request.getAttribute("projects");
			for (CrowdFundingEntity projet : projectList) {
		%>
		<tr>
			<td><%=projet.getName()%></td>
			<td><%=projet.getGoal().toString()%></td>
			<td><a href="./project?id=<%=projet.getId()%>">editer</a></td>
		</tr>
		<%
			}
		%>
	</table>



</body>
</html>