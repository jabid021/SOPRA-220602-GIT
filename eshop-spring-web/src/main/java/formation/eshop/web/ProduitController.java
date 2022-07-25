package formation.eshop.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.eshop.model.Fournisseur;
import formation.eshop.model.Produit;
import formation.eshop.repo.IFournisseurRepository;
import formation.eshop.repo.IProduitRepository;

@Controller
@RequestMapping("/produit")
public class ProduitController {
	@Autowired
	private IProduitRepository produitRepo;
	@Autowired
	private IFournisseurRepository fournisseurRepo;

	// ETAPE 1 : réception de la requête
	@GetMapping({ "", "/list" })
	public String list(Model model) {
		// ETAPE 2 : récupération des données
		List<Produit> produits = produitRepo.findAll();

		// ETAPE 3 : Renseigner le Model
		model.addAttribute("mesProduits", produits);

		// ETAPE 4 : Appel de la View (en passant le Model)
		return "produit/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("fournisseurs", fournisseurRepo.findAll());
		
		return "produit/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		Optional<Produit> optProduit = produitRepo.findById(id);

		model.addAttribute("monProduit", optProduit.get());
		model.addAttribute("fournisseurs", fournisseurRepo.findAll());

		return "produit/form";
	}

	@PostMapping("/save")
	public String save(@RequestParam(required = false) Long id, @RequestParam String libelle,
			@RequestParam(required = false) Double prixAchat, @RequestParam(required = false) Double prixVente,
			@RequestParam String reference, @RequestParam(required = false, defaultValue = "0") int stock, @RequestParam(required = false) Long idFournisseur) {

		Produit produit = null;

		if (id == null) {
			produit = new Produit();
		} else {
//			Optional<Produit> optProduit = produitRepo.findById(id);
//			produit = optProduit.get();
			produit = new Produit();
			produit.setId(id);
		}

		produit.setLibelle(libelle);
		produit.setPrixAchat(prixAchat);
		produit.setPrixVente(prixVente);
		produit.setReference(reference);
		produit.setStock(stock);
		
		if(idFournisseur != null) {
//			Optional<Fournisseur> optFournisseur = fournisseurRepo.findById(idFournisseur);
//			produit.setFournisseur(optFournisseur.get());
			Fournisseur fournisseur = new Fournisseur();
			fournisseur.setId(idFournisseur);
			
			produit.setFournisseur(fournisseur);
		}

		produit = produitRepo.save(produit);

		return "redirect:list";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:list";
	}

	@GetMapping("/delete/{idProduit}")
	public String delete(@PathVariable("idProduit") Long id) {
		produitRepo.deleteById(id);

		return "redirect:../list";
	}
}
