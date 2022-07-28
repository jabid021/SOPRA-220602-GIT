package formation.eshop.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.eshop.model.Fournisseur;
import formation.eshop.model.Views;
import formation.eshop.repo.IFournisseurRepository;

@RestController
@RequestMapping("/api/fournisseur")
@CrossOrigin("*")
public class FournisseurRestController {
	@Autowired
	private IFournisseurRepository fournisseurRepo;

	@GetMapping("/{id}")
	@JsonView(Views.ViewFournisseur.class)
	public Fournisseur findById(@PathVariable Long id) {
		Optional<Fournisseur> optFournisseur = fournisseurRepo.findById(id);

		if(optFournisseur.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optFournisseur.get();
	}
	
	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewFournisseurDetail.class)
	public Fournisseur findDetailById(@PathVariable Long id) {
		Optional<Fournisseur> optFournisseur = fournisseurRepo.findByIdWithProduits(id);

		if(optFournisseur.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optFournisseur.get();
	}

	

}
