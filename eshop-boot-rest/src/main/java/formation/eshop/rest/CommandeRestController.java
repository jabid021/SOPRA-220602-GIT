package formation.eshop.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import formation.eshop.model.Commande;
import formation.eshop.model.Views;
import formation.eshop.repo.ICommandeRepository;
import formation.eshop.rest.dto.PanierDTO;

@RestController
@RequestMapping("/commande")
@CrossOrigin("*")
public class CommandeRestController {
	@Autowired
	private ICommandeRepository commandeRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommande.class)
	public List<Commande> findAll() {

		return commandeRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommande.class)
	public Commande findById(@PathVariable("id") Long id) {
		Optional<Commande> optCommande = commandeRepo.findById(id);

		if (optCommande.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCommande.get();
	}

	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewCommandeDetail.class)
	public Commande detailById(@PathVariable("id") Long id) {
		Optional<Commande> optCommande = commandeRepo.findByIdWithAchats(id);

		if (optCommande.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCommande.get();
	}

	@GetMapping("/{id}/panier")
	public PanierDTO panierById(@PathVariable("id") Long id) {
		return null;
	}

	@PostMapping("")
	@JsonView(Views.ViewCommande.class)
	public Commande create(@RequestBody @Valid Commande commande, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La commande n'a pu être créée");
		}

		commande = commandeRepo.save(commande);

		return commande;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommande.class)
	public Commande update(@RequestBody Commande commande, @PathVariable Long id) {
		commande = commandeRepo.save(commande);

		return commande;
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		commandeRepo.deleteById(id);
	}

}
