package formation.eshop.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.eshop.model.Adresse;
import formation.eshop.model.Fournisseur;
import formation.eshop.repo.IAdresseRepository;
import formation.eshop.repo.IFournisseurRepository;
import formation.eshop.web.dto.FournisseurDTO;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {
	@Autowired
	private IFournisseurRepository fournisseurRepo;
	@Autowired
	private IAdresseRepository adresseRepo;

	@GetMapping({ "", "/list" })
	public String list(Model model) {
		List<Fournisseur> fournisseurs = fournisseurRepo.findAll();

		model.addAttribute("fournisseurs", fournisseurs);

		return "fournisseur/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("fournisseur", new FournisseurDTO());
		model.addAttribute("adresses", adresseRepo.findAllOrphan());

		return "fournisseur/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		Optional<Fournisseur> optFournisseur = fournisseurRepo.findById(id);
		
		FournisseurDTO fournisseurDTO = new FournisseurDTO();
		fournisseurDTO.setId(optFournisseur.get().getId());
		fournisseurDTO.setNom(optFournisseur.get().getNom());
		fournisseurDTO.setPrenom(optFournisseur.get().getPrenom());
		fournisseurDTO.setSociete(optFournisseur.get().getSociete());
		
		if(optFournisseur.get().getAdresse() != null) {
			fournisseurDTO.setRue(optFournisseur.get().getAdresse().getRue());
			fournisseurDTO.setCodePostal(optFournisseur.get().getAdresse().getCodePostal());
			fournisseurDTO.setVille(optFournisseur.get().getAdresse().getVille());
		}
		

		model.addAttribute("fournisseur", fournisseurDTO);
		model.addAttribute("adresses", adresseRepo.findAllOrphan());

		return "fournisseur/form";
	}

	@PostMapping("/save")
	public String save(@RequestParam(required = false) Long id, @RequestParam String nom, @RequestParam String prenom,
			@RequestParam String societe, @RequestParam String rue, @RequestParam String codePostal,
			@RequestParam String ville) {

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

		if(!rue.isBlank() || !codePostal.isBlank() || !ville.isBlank()) {
			Adresse adresse = new Adresse(rue, codePostal, ville);
				
			adresse = adresseRepo.save(adresse);
			
			fournisseur.setAdresse(adresse);
		}

		fournisseur = fournisseurRepo.save(fournisseur);

		return "redirect:list";
	}
	
	@PostMapping("/saveBis")
	public String saveBis(@ModelAttribute("fournisseur") FournisseurDTO fournisseurDTO) {
		Fournisseur fournisseur = new Fournisseur();

		if (fournisseurDTO.getId() != null) {
			fournisseur.setId(fournisseurDTO.getId());
		}

		fournisseur.setNom(fournisseurDTO.getNom());
		fournisseur.setPrenom(fournisseurDTO.getPrenom());
		fournisseur.setSociete(fournisseurDTO.getSociete());

		if(!fournisseurDTO.getRue().isBlank() || !fournisseurDTO.getCodePostal().isBlank() || !fournisseurDTO.getVille().isBlank()) {
			Adresse adresse = new Adresse(fournisseurDTO.getRue(), fournisseurDTO.getCodePostal(), fournisseurDTO.getVille());
				
			adresse = adresseRepo.save(adresse);
			
			fournisseur.setAdresse(adresse);
		}

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
