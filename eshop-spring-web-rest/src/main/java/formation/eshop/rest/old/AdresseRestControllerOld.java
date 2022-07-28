package formation.eshop.rest.old;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import formation.eshop.model.Adresse;
import formation.eshop.repo.IAdresseRepository;

@Controller
@RequestMapping("/old/adresse")
@CrossOrigin("*")
public class AdresseRestControllerOld {

	@Autowired
	private IAdresseRepository adresseRepo;

	@GetMapping("")
	@ResponseBody
	public List<Adresse> findAll() {
		return adresseRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Adresse> findById(@PathVariable Long id) {
		Optional<Adresse> optAdresse = adresseRepo.findById(id);

		if (optAdresse.isPresent()) {
			return new ResponseEntity<Adresse>(optAdresse.get(), HttpStatus.OK);
		}

		return new ResponseEntity<Adresse>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("")
	public ResponseEntity<Adresse> create(@RequestBody Adresse adresse) {
		adresse = adresseRepo.save(adresse);

		return new ResponseEntity<Adresse>(adresse, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Adresse> update(@RequestBody Adresse adresse, @PathVariable Long id) {
		adresse = adresseRepo.save(adresse);

		return new ResponseEntity<Adresse>(adresse, HttpStatus.OK);
	}

}
