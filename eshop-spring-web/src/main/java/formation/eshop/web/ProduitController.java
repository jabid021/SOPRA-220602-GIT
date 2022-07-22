package formation.eshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import formation.eshop.repo.IProduitRepository;

@Controller
public class ProduitController {
	@Autowired
	private IProduitRepository produitRepo;
}
