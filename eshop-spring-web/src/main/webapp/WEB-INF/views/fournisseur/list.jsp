<!-- ETAPE 5 : Exécution de la View à partir des données du Model -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des fournisseurs</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/bootstrap-icons.css"/>">
</head>
<body>
	<div class="container">
		<div class="card mt-3">
			<div class="card-header bg-info text-white"><span class="h2">Liste des fournisseurs</span></div>
			<div class="card-body">
				<table class="table table-striped">
					<thead>
						<tr>
						<th>Identifiant</th>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Société</th>
						<th>Adresse</th>
						<th></th>
					</tr>
					</thead>
					<tbody>
						<c:forEach items="${fournisseurs}" var="four">
							<c:url value="/fournisseur/edit" var="editUrl">
								<c:param name="id" value="${four.id}"/>
							</c:url>
							<c:url value="/fournisseur/delete/${four.id}" var="removeUrl"/>
							<tr>
								<td>${four.id}</td>
								<td>${four.nom}</td>
								<td>${four.prenom}</td>
								<td>${four.societe}</td>
								<td>(${four.adresse.id}) ${four.adresse.rue} ${four.adresse.codePostal} ${four.adresse.ville}</td>
								<td>
									<div class='btn-group btn-group-sm'>
										<a href="${editUrl}" class='btn btn-primary'>
											<i class='bi bi-pencil-square'></i>
										</a>
										<a href="${removeUrl}" class='btn btn-danger'>
											<i class='bi bi-trash'></i>
										</a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
			
				</table>
			</div>
			<div class="card-footer">
				<c:url value="/fournisseur/add" var="addUrl"/>
				<a href="${addUrl}" class="btn btn-success btn-lg">
					<i class="bi bi-plus-square"></i>
				</a>
			</div>
		</div>
	</div>
	
<script src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>