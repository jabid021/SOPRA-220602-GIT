<!-- ETAPE 5 : Exécution de la View à partir des données du Model -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des produits</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/bootstrap-icons.css"/>">
</head>
<body>
	<div class="container">
		<div class="card mt-3">
			<div class="card-header bg-info text-white"><span class="h2">Liste des produits</span></div>
			<div class="card-body">
				<table class="table table-striped">
					<thead>
						<tr>
						<th>Identifiant</th>
						<th>Libellé</th>
						<th>Prix d'achat</th>
						<th>Prix de vente</th>
						<th>Référence</th>
						<th>Stock</th>
						<th></th>
					</tr>
					</thead>
					<tbody>
						<c:forEach items="${mesProduits}" var="produit">
							<c:url value="/produit/edit" var="editUrl">
								<c:param name="id" value="${produit.id}"/>
							</c:url>
							<c:url value="/produit/delete/${produit.id}" var="removeUrl"/>
							<tr>
								<td>${produit.id}</td>
								<td>${produit.libelle}</td>
								<td>${produit.prixAchat}</td>
								<td>${produit.prixVente}</td>
								<td>${produit.reference}</td>
								<td>${produit.stock}</td>
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
				<c:url value="/produit/add" var="addUrl"/>
				<a href="${addUrl}" class="btn btn-success btn-lg">
					<i class="bi bi-plus-square"></i>
				</a>
			</div>
		</div>
	</div>
	
<script src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>