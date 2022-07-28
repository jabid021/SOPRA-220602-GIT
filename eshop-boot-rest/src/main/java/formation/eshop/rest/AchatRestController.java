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

import formation.eshop.model.Achat;
import formation.eshop.model.Views;
import formation.eshop.repo.IAchatRepository;

@RestController
@RequestMapping("/achat")
@CrossOrigin("*")
public class AchatRestController {
	@Autowired
	private IAchatRepository achatRepo;

	@GetMapping("")
	@JsonView(Views.ViewAchat.class)
	public List<Achat> findAll() {

		return achatRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewAchat.class)
	public Achat findById(@PathVariable("id") Long id) {
		Optional<Achat> optAchat = achatRepo.findById(id);

		if(optAchat.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optAchat.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewAchat.class)
	public Achat create(@RequestBody @Valid Achat achat, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'achat n'a pu être créée");
		}
		
		achat = achatRepo.save(achat);

		return achat;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewAchat.class)
	public Achat update(@RequestBody Achat achat, @PathVariable Long id) {
		achat = achatRepo.save(achat);

		return achat;
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		achatRepo.deleteById(id);
	}

}
