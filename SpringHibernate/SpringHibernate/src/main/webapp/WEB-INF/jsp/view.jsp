<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"
	import="com.balsp.hibernate.Project, java.util.List"%>
<html>
<head>
<title>Project Page</title>
</head>
<body>
	<%
		List<Project> projects = (List<Project>) request.getAttribute("Projects");
		out.println("<table border=1");
		out.println("<tr><th>Project Name</th><th>Project Description</th></tr>");
		for (Project p : projects) {
			out.println("<tr>");
			out.println("<td>" + p.getProjectName() + "</td>");
			out.println("<td>" + p.getProjectDescription() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	%>
</body>
</html>