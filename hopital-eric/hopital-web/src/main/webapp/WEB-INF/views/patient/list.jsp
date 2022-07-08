<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- ETAPE 5 : Exécution de la View (JSP) avec les données du Model -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des patients</title>

<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/bootstrap-icons.css"/>">
</head>
<body>

	<div class="container">
		<div class="card mt-3">
			<div class="card-header bg-info text-white"><span class="h2">Liste des patients</span></div>
			<div class="card-body">
				<table class="table table-striped">
					<thead>
						<tr>
						<th>Identifiant</th>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Civilité</th>
						<th></th>
					</tr>
					</thead>
					<tbody>
						<c:forEach items="${mesPatients}" var="pat">
							<c:url value="/patient" var="editUrl">
								<c:param name="mode" value="edit"/>
								<c:param name="id" value="${pat.id}"/>
							</c:url>
							<c:url value="/patient" var="removeUrl">
								<c:param name="mode" value="remove"/>
								<c:param name="id" value="${pat.id}"/>
							</c:url>
							<tr>
								<td>${pat.id}</td>
								<td>${pat.nom}</td>
								<td>${pat.prenom}</td>
								<td>${pat.civ}</td>
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
				<c:url value="/patient" var="addUrl">
					<c:param name="mode" value="add"/>
				</c:url>
				<a href="${addUrl}" class="btn btn-success btn-lg">
					<i class="bi bi-plus-square"></i>
				</a>
			</div>
		</div>
	</div>

<script src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>