package formation.eshop.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.eshop.model.Fournisseur;
import formation.eshop.model.Views;
import formation.eshop.repo.IFournisseurRepository;

@RestController
@RequestMapping("/fournisseur")
@CrossOrigin("*")
public class FournisseurRestController {
	@Autowired
	private IFournisseurRepository fournisseurRepo;

	@GetMapping("")
	@JsonView(Views.ViewFournisseur.class)
	public List<Fournisseur> findAll() {

		return fournisseurRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewFournisseur.class)
	public Fournisseur findById(@PathVariable Long id) {
		Optional<Fournisseur> optFournisseur = fournisseurRepo.findById(id);

		if (optFournisseur.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optFournisseur.get();
	}

	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewFournisseurDetail.class)
	public Fournisseur findDetailById(@PathVariable Long id) {
		Optional<Fournisseur> optFournisseur = fournisseurRepo.findByIdWithProduits(id);

		if (optFournisseur.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optFournisseur.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewFournisseur.class)
	public Fournisseur create(@RequestBody Fournisseur fournisseur) {
		fournisseur = fournisseurRepo.save(fournisseur);

		return fournisseur;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewFournisseur.class)
	public Fournisseur update(@RequestBody Fournisseur fournisseur, @PathVariable Long id) {
		fournisseur = fournisseurRepo.save(fournisseur);

		return fournisseur;
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		fournisseurRepo.deleteById(id);
	}

}
