package formation.eshop.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import formation.eshop.model.Produit;
import formation.eshop.repo.IProduitRepository;

@RestController
@RequestMapping("/produit")
@CrossOrigin("*")
public class ProduitRestController {
	@Autowired
	private IProduitRepository produitRepo;

	@GetMapping("")
	public List<Produit> findAll() {

		return produitRepo.findAll();
	}

	

}
