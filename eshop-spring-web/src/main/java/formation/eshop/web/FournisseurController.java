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
import formation.eshop.repo.IFournisseurRepository;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {
	@Autowired
	private IFournisseurRepository fournisseurRepo;

	@GetMapping({ "", "/list" })
	public String list(Model model) {
		List<Fournisseur> fournisseurs = fournisseurRepo.findAll();

		model.addAttribute("fournisseurs", fournisseurs);

		return "fournisseur/list";
	}

	@GetMapping("/add")
	public String add() {
		return "fournisseur/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		Optional<Fournisseur> optFournisseur = fournisseurRepo.findById(id);

		model.addAttribute("fournisseur", optFournisseur.get());

		return "fournisseur/form";
	}

	@PostMapping("/save")
	public String save(@RequestParam(required = false) Long id, @RequestParam String nom, @RequestParam String prenom,
			@RequestParam String societe) {

		Fournisseur fournisseur = null;

		if (id == null) {
			fournisseur = new Fournisseur();
		} else {
			fournisseur = new Fournisseur();
			fournisseur.setId(id);
		}

		fournisseur.setNom(nom);
		fournisseur.setPrenom(prenom);
		fournisseur.setSociete(societe);

		fournisseur = fournisseurRepo.save(fournisseur);

		return "redirect:list";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:list";
	}

	@GetMapping("/delete/{idProduit}")
	public String delete(@PathVariable("idProduit") Long id) {

		fournisseurRepo.deleteById(id);

		return "redirect:../list";
	}
}
