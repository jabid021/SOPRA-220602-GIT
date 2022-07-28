package formation.eshop.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.eshop.model.Adresse;
import formation.eshop.repo.IAdresseRepository;

@Controller
@RequestMapping("/adresse")
public class AdresseController {
	@Autowired
	private IAdresseRepository adresseRepo;

	@GetMapping({ "", "/list" })
	public String list(Model model) {
		List<Adresse> adresses = adresseRepo.findAll();

		model.addAttribute("adresses", adresses);

		return "adresse/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("adresse", new Adresse());
		
		return "adresse/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		Optional<Adresse> optAdresse = adresseRepo.findById(id);

		model.addAttribute("adresse", optAdresse.get());

		return "adresse/form";
	}

	@PostMapping("/save")
	public String save(@RequestParam(required = false) Long id, @RequestParam String rue, @RequestParam String codePostal,
			@RequestParam String ville) {

		Adresse adresse = null;

		if (id == null) {
			adresse = new Adresse();
		} else {
			adresse = new Adresse();
			adresse.setId(id);
		}

		adresse.setRue(rue);
		adresse.setCodePostal(codePostal);
		adresse.setVille(ville);

		adresse = adresseRepo.save(adresse);

		return "redirect:list";
	}
	
	@PostMapping("/saveBis")
	public String saveBis(@ModelAttribute("adresse") @Valid Adresse adresse, BindingResult result) {
		if(result.hasErrors()) {
			return "adresse/form";
		}
		
		adresse = adresseRepo.save(adresse);
		
		return "redirect:list";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:list";
	}

	@GetMapping("/delete/{idProduit}")
	public String delete(@PathVariable("idProduit") Long id) {

		adresseRepo.deleteById(id);

		return "redirect:../list";
	}
}
