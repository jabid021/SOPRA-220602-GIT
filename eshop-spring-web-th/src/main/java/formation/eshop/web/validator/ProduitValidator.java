package formation.eshop.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import formation.eshop.model.Produit;

public class ProduitValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Produit.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Produit produit = (Produit) target;
		
		if(produit.getPrixAchat() != null && produit.getPrixVente() == null) {
			errors.rejectValue("prixVente", "prixVente.required", "Le prix de vente doit être renseigné");
		}
		
		if(produit.getPrixAchat() != null && produit.getPrixVente() != null && produit.getPrixAchat() > produit.getPrixVente()) {
			errors.rejectValue("prixVente", "prixVente.supPrixAchat", "Le prix de vente doit être strictement supérieur au prix d'achat");
		}
	}

}
