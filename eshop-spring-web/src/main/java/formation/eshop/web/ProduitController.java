package formation.eshop.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.eshop.model.Produit;
import formation.eshop.repo.IProduitRepository;

@Controller
@RequestMapping("/produit")
public class ProduitController {
	@Autowired
	private IProduitRepository produitRepo;
	
	// ETAPE 1 : réception de la requête 
	@GetMapping("/list")
	public String list(Model model) {
		// ETAPE 2 : récupération des données
		List<Produit> produits = produitRepo.findAll();
		
		// ETAPE 3 : Renseigner le Model
		model.addAttribute("mesProduits", produits);
		
		// ETAPE 4 : Appel de la View (en passant le Model)
		return "produit/list";
	}

	@GetMapping("/add")
	public String add() {
		return "produit/form";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		model.addAttribute("id", id);
		
		
		return "produit/form";
	}
}
