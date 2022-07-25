<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition du fournisseur</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/bootstrap-icons.css"/>">
</head>
<body>
	<div class="container">
		<div class="card mt-3">
			<form action="<c:url value="/fournisseur/save"/>" method="post">
				<div class="card-header bg-info text-white"><h3>Edition du fournisseur</h3></div>
				<div class="card-body">
					<div class="form-group">
						<label for="id">Identifiant:</label> <input type="number"
							class="form-control" name="id" readonly value="${fournisseur.id}">
					</div>
					<div class="form-group">
						<label for="nom">Nom:</label> <input type="text"
							class="form-control" name="nom" value="${fournisseur.nom}">
					</div>
					<div class="form-group">
						<label for="prenom">Prénom:</label> <input type="text"
							class="form-control" name="prenom" value="${fournisseur.prenom}">
					</div>
					<div class="form-group">
						<label for="societe">Société:</label> <input type="text" 
							class="form-control" name="societe" value="${fournisseur.societe}">
					</div>
					<div class="form-group">
						<label for="idAdresse">Adresse:</label>
						<select class="form-control" name="idAdresse">
							<option value="">Veuillez sélectionner une adresse</option>
							<c:forEach items="${adresses}" var="adr">
								<option value="${adr.id}" ${adr.id == fournisseur.adresse.id ? 'selected' : ''}>${adr.id} - ${adr.rue} ${adr.codePostal} ${adr.ville}</option>
							</c:forEach>
						</select> 
					</div>
				</div>
				<div class="card-footer d-flex justify-content-end" >
					<div class="btn-group btn-group-lg ">
						<button type="submit" class="btn btn-success">
							<i class="bi bi-check-square"></i>
						</button>
						<c:url value="/fournisseur/cancel" var="cancelUrl"/>
						<a href="${cancelUrl}" class="btn btn-warning">
							<i class="bi bi-backspace"></i>
						</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<script src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>