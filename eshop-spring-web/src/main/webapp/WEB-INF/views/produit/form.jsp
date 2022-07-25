<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition du produit</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/bootstrap-icons.css"/>">
</head>
<body>
	<div class="container">
		<div class="card mt-3">
			<form action="<c:url value="/produit/save"/>" method="post">
				<div class="card-header bg-info text-white"><h3>Edition du produit</h3></div>
				<div class="card-body">
					<div class="form-group">
						<label for="id">Identifiant:</label> <input type="number"
							class="form-control" name="id" readonly value="${monProduit.id}">
					</div>
					<div class="form-group">
						<label for="libelle">Libellé:</label> <input type="text"
							class="form-control" name="libelle" value="${monProduit.libelle}">
					</div>
					<div class="form-group">
						<label for="prixAchat">Prix d'achat:</label> <input type="number" step=".01"
							class="form-control" name="prixAchat" value="${monProduit.prixAchat}">
					</div>
					<div class="form-group">
						<label for="prixVente">Prix de vente:</label> <input type="number" step=".01"
							class="form-control" name="prixVente" value="${monProduit.prixVente}">
					</div>
					<div class="form-group">
						<label for="reference">Référence:</label> <input type="text"
							class="form-control" name="reference" value="${monProduit.reference}">
					</div>
					<div class="form-group">
						<label for="stock">Stock:</label> <input type="number"
							class="form-control" name="stock" value="${monProduit.stock}">
					</div>
					
					<div class="form-group">
						<label for="idFournisseur">Fournisseur:</label>
						<select class="form-control" name="idFournisseur">
							<option value="">Veuillez sélectionner un fournisseur</option>
							<c:forEach items="${fournisseurs}" var="four">
								<option value="${four.id}" ${four.id == monProduit.fournisseur.id ? 'selected' : ''}>${four.id} - ${four.nom}</option>
							</c:forEach>
						</select> 
					</div>
				</div>
				<div class="card-footer d-flex justify-content-end" >
					<div class="btn-group btn-group-lg ">
						<button type="submit" class="btn btn-success">
							<i class="bi bi-check-square"></i>
						</button>
						<c:url value="/produit/cancel" var="cancelUrl"/>
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