<!-- ETAPE 5 : Exécution de la View à partir des données du Model -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des adresses</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/bootstrap-icons.css"/>">
</head>
<body>
	<div class="container">
		<div class="card mt-3">
			<div class="card-header bg-info text-white"><span class="h2">Liste des adresses</span></div>
			<div class="card-body">
				<table class="table table-striped">
					<thead>
						<tr>
						<th>Identifiant</th>
						<th>Rue</th>
						<th>Code postal</th>
						<th>Ville</th>
						<th></th>
					</tr>
					</thead>
					<tbody>
						<c:forEach items="${adresses}" var="adr">
							<c:url value="/adresse/edit" var="editUrl">
								<c:param name="id" value="${adr.id}"/>
							</c:url>
							<c:url value="/adresse/delete/${adr.id}" var="removeUrl"/>
							<tr>
								<td>${adr.id}</td>
								<td>${adr.rue}</td>
								<td>${adr.codePostal}</td>
								<td>${adr.ville}</td>
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
				<c:url value="/adresse/add" var="addUrl"/>
				<a href="${addUrl}" class="btn btn-success btn-lg">
					<i class="bi bi-plus-square"></i>
				</a>
			</div>
		</div>
	</div>
	
<script src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>