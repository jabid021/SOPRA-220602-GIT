<!-- ETAPE 5 : Exécution de la View à partir des données du Model -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Je suis dans la liste des produits</h1>
	
	<ul>
		<c:forEach items="${mesProduits}" var="prod">
			<li>${prod.id} - ${prod.libelle}</li>
		</c:forEach>
	
	</ul>
	
	
</body>
</html>