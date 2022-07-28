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

import formation.eshop.model.Produit;
import formation.eshop.model.Views;
import formation.eshop.repo.IProduitRepository;

@RestController
@RequestMapping("/produit")
@CrossOrigin("*")
public class ProduitRestController {
	@Autowired
	private IProduitRepository produitRepo;

	@GetMapping("")
	@JsonView(Views.ViewProduit.class)
	public List<Produit> findAll() {
		return produitRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewProduitDetail.class)
	public Produit findById(@PathVariable("id") Long id) {
		Optional<Produit> optProduit = produitRepo.findById(id);

		if (optProduit.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optProduit.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewProduit.class)
	public Produit create(@RequestBody Produit produit) {
		produit = produitRepo.save(produit);

		return produit;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewProduit.class)
	public Produit update(@RequestBody Produit produit, @PathVariable Long id) {
		if (id != produit.getId() || !produitRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		produit = produitRepo.save(produit);

		return produit;
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		produitRepo.deleteById(id);
	}
	
	@GetMapping("/by-libelle/{libelle}")
	@JsonView(Views.ViewProduit.class)
	public List<Produit> findAllByLibelle(@PathVariable String libelle) {
		return produitRepo.findByLibelleStartingWith(libelle);
	}

	
}
