package formation.eshop.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import formation.eshop.web.dto.FournisseurDTO;

public class FournisseurValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return FournisseurDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		FournisseurDTO fournisseur = (FournisseurDTO) target;

		if (fournisseur.getNom().isBlank() ^ fournisseur.getPrenom().isBlank()) {
			errors.rejectValue("nom", "nom.required", "Le nom et le prénom sont obligatoires conjointement");
			errors.rejectValue("prenom", "prenom.required", "Le nom et le prénom sont obligatoires conjointement");
		}
	}

}
