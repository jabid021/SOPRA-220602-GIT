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

import formation.eshop.model.Client;
import formation.eshop.model.Views;
import formation.eshop.repo.IClientRepository;

@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientRestController {
	@Autowired
	private IClientRepository clientRepo;

	@GetMapping("")
	@JsonView(Views.ViewClient.class)
	public List<Client> findAll() {

		return clientRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewClient.class)
	public Client findById(@PathVariable("id") Long id) {
		Optional<Client> optClient = clientRepo.findById(id);

		if(optClient.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optClient.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewClient.class)
	public Client create(@RequestBody @Valid Client client, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le client n'a pu être créée");
		}
		
		client = clientRepo.save(client);

		return client;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewClient.class)
	public Client update(@RequestBody Client client, @PathVariable Long id) {
		client = clientRepo.save(client);

		return client;
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		clientRepo.deleteById(id);
	}

}
