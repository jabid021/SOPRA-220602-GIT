<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition du patient</title>

<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/bootstrap-icons.css"/>">
</head>
<body>

	<div class="container">
		<div id="patientForm" class="card mt-3">
			<form action="<c:url value="/patient"/>" method="post">
				<div class="card-header bg-info text-white"><h3>Edition du patient</h3></div>
				<div class="card-body">
					<input type="hidden" name="mode" value="save"/>
					<div class="form-group">
						<label for="id">Identifiant:</label> <input type="number"
							class="form-control" name="id" readonly value="${monPatient.id}">
					</div>
					<div class="form-group">
						<label for="intitule">Nom:</label> <input type="text"
							class="form-control" name="nom" value="${monPatient.nom}">
					</div>
					<div class="form-group">
						<label for="promotion">Prénom:</label> <input type="text"
							class="form-control" name="prenom" value="${monPatient.prenom}">
					</div>
					<div class="form-group">
						<label for="dtDebut">Civilité:</label> <input type="text"
							class="form-control" name="civ" value="${monPatient.civ}">
					</div>
				</div>
				<div class="card-footer d-flex justify-content-end" >
					<div class="btn-group btn-group-lg ">
						<button type="submit" class="btn btn-success">
							<i class="bi bi-check-square"></i>
						</button>
						<c:url value="/patient" var="cancelUrl">
							<c:param name="mode" value="cancel"/>
						</c:url>
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