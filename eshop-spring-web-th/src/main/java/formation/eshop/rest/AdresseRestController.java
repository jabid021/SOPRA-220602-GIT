package formation.eshop.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.eshop.model.Adresse;
import formation.eshop.model.Views;
import formation.eshop.repo.IAdresseRepository;
import formation.eshop.rest.exception.AdresseNotFoundException;

@RestController
@RequestMapping("/adresse")
@CrossOrigin("*")
public class AdresseRestController {
	@Autowired
	private IAdresseRepository adresseRepo;

	@GetMapping("")
	@JsonView(Views.ViewAdresse.class)
	public List<Adresse> findAll() {

		return adresseRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewAdresse.class)
	public Adresse findById(@PathVariable("id") Long id) {
		Optional<Adresse> optAdresse = adresseRepo.findById(id);

		if(optAdresse.isEmpty()) {
			throw new AdresseNotFoundException();
		}
		
		return optAdresse.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewAdresse.class)
	public Adresse create(@RequestBody @Valid Adresse adresse, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'adresse n'a pu être créée");
		}
		
		adresse = adresseRepo.save(adresse);

		return adresse;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewAdresse.class)
	public Adresse update(@RequestBody Adresse adresse, @PathVariable Long id) {
		adresse = adresseRepo.save(adresse);

		return adresse;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.ViewAdresse.class)
	public Adresse partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
		Optional<Adresse> optAdresse = adresseRepo.findById(id);

		if (optAdresse.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adresse non trouvé");
		}

		Adresse adresse = optAdresse.get();

		if(fields.containsKey("id")) {
			adresse.setId(((Integer)fields.get("id")).longValue());
		}
		
		if(fields.containsKey("rue")) {
			adresse.setRue((String)fields.get("rue"));
		}
		
		if(fields.containsKey("codePostal")) {
			adresse.setCodePostal((String)fields.get("codePostal"));
		}
		
		if(fields.containsKey("ville")) {
			adresse.setVille((String)fields.get("ville"));
		}
		
		adresse = adresseRepo.save(adresse);

		return adresse;
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		adresseRepo.deleteById(id);
	}

}
