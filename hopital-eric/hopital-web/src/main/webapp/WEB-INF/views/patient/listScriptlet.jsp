<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="formation.hopital.model.Patient" %>
<!-- ETAPE 5 : Exécution de la View (JSP) avec les données du Model -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des patients</title>
</head>
<body>

<% List<Patient> patientListe = (List<Patient>)request.getAttribute("mesPatients");%>

	<table>
		<tr>
			<th>Identifiant</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Civilité</th>
		</tr>
		
		<% for(Patient pat : patientListe) { %>
				
				<tr>
					<td><%=pat.getId()%></td>
					<td><%=pat.getNom()%></td>
					<td><%=pat.getPrenom()%></td>
					<td><%=pat.getCiv()%></td>
				</tr>
		
		<% } %>
		
	</table>


</body>
</html>